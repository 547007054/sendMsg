package com.ztjs.platform.service.upms;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.common.entity.PageInfo;
import com.ztjs.platform.common.utils.DateUtils;
import com.ztjs.platform.mapper.upms.DutyMapper;
import com.ztjs.platform.model.po.upms.DutyPo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 职责 服务实现类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:11
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Service
@CacheConfig(cacheNames = "ztjs:upms:duty")
@Transactional(rollbackFor = Exception.class)
public class DutyService extends ServiceImpl<DutyMapper, DutyPo> {

    /**
     * 查询职务信息
     *
     * @param params
     * @return
     */
    public PageInfo<DutyPo> getDutyByParams(Map<String, Object> params) {
        QueryWrapper<DutyPo> queryWrapper = new QueryWrapper<>();

        if (!StrUtil.isEmptyIfStr(params.get("dutyName"))) {
            queryWrapper.like("DUTY_NAME", params.get("dutyName"));
            queryWrapper.or().like("TYPE", params.get("dutyName"));
        }

        Integer pageNo = Integer.valueOf(params.get("pageNo").toString());
        Integer pageSize = Integer.valueOf(params.get("pageSize").toString());
        IPage<DutyPo> iPage = this.baseMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper);

        PageInfo<DutyPo> pageInfo = new PageInfo<>();
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(iPage.getTotal());
        pageInfo.setRows(iPage.getRecords());
        return pageInfo;
    }

    /**
     * 添加职务信息
     *
     * @param po
     * @return
     */
    public int addDuty(DutyPo po) {
        po.setCreateTime(DateUtils.getSysTimestamp());
        return this.baseMapper.insert(po);
    }

    /**
     * 根据职务ID删除职务信息
     *
     * @param id
     * @return
     */
    public boolean deleteDutyById(Integer id) {
        return this.baseMapper.deleteById(id) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 修改职务信息
     *
     * @param
     * @return
     */
    public boolean updateDuty(DutyPo po) {
        return this.baseMapper.updateById(po) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

}