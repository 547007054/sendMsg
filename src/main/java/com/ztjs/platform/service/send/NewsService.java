package com.ztjs.platform.service.send;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.mapper.fence.PersonMapper;
import com.ztjs.platform.model.po.fence.PersonPo;

import java.util.List;
import java.util.Map;

/**
 * @Author: Lenovo-卫瑞涛
 * @Date: 2019/9/13
 * @Version: v1.0
 */
public class NewsService  extends ServiceImpl<PersonMapper,PersonPo> {
    /**
     * 查询全部用户信息
     * @return`
     */
    public List<Map<String, Object>> getAllPerson() {
        QueryWrapper<PersonPo> queryWrapper = new QueryWrapper<>();
        return this.baseMapper.selectMaps(queryWrapper);
    }

}
