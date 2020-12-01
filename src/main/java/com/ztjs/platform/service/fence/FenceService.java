package com.ztjs.platform.service.fence;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.mapper.fence.FenceMapper;
import com.ztjs.platform.model.po.fence.FencePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by aa on 2019/8/20.
 */
@Service
public class FenceService extends ServiceImpl<FenceMapper,FencePo>{

    @Autowired
    private FenceMapper fenceMapper;
    /**
     * 查询所有区域的地理信息
     * @return
     */
    public List<Map<String, Object>> getAllFence() {
        QueryWrapper<FencePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("LONGITUDE_COLUMN");
        queryWrapper.isNotNull("LATITUDE_COLUMNS");
        queryWrapper.isNotNull("FENCE_NAME");
        return this.baseMapper.selectMaps(queryWrapper);
    }

    public FencePo getFence(Map<String, Object> params) {
        return this.baseMapper.selectByFenceName(params);
    }

    /**
     * 删除区域信息
     */
    public boolean deleteUserByName(Map<String, Object> params) {
        try {
            this.baseMapper.deleteUserByName(params);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Boolean.FALSE;
        }
    }

    /**
     * 添加区域的地理信息
     * @param po
     * @return
     */
    public int addFence(FencePo po) {
        return this.baseMapper.insert(po);
    }

    /**
     * 查看工点
     */
    public List<String> selectName() {
        return fenceMapper.selectName();
    }

    public List<String> selectName2(String workPoint) {
        return fenceMapper.selectName2(workPoint);
    }
    public List<FencePo> findFence() {
        return fenceMapper.findFence();
    }
    /**
     * 查看具DayValue
     */
    public double selectDayValue(String workPoint) {
        return fenceMapper.selectDayValue(workPoint);
    }
    /**
     * 添查看具MouValue
     */
    public double selectMouValue(String workPoint) {
        return fenceMapper.selectMouValue(workPoint);
    }

}
