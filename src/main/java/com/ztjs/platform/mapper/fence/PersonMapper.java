package com.ztjs.platform.mapper.fence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztjs.platform.model.po.fence.PersonPo;

import java.util.List;

/**
 * Created by aa on 2019/8/20.
 */
public interface PersonMapper extends BaseMapper<PersonPo> {
    List<PersonPo> getPerson();
}
