package com.ztjs.platform.mapper.fence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztjs.platform.model.po.fence.FencePo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by aa on 2019/8/20.
 */
public interface FenceMapper extends BaseMapper<FencePo> {

    /**
     * 查看具体区域信息
     * @param
     * @return
     */
    FencePo selectByFenceName( @Param("params") Map<String, Object> params);

    /**
     * 删除具体区域信息
     */
    boolean deleteUserByName(@Param("params") Map<String, Object> params);

    public List<String> selectName();
    public List<FencePo> findFence();
    public List<String> selectName2(String workPoint);
    public double selectDayValue(String workPoint);
    public double selectMouValue(String workPoint);

}
