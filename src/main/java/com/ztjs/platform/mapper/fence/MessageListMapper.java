package com.ztjs.platform.mapper.fence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztjs.platform.model.po.fence.MessageListPo;

/**
 * Created by aa on 2019/9/11.
 */
public interface MessageListMapper extends BaseMapper<MessageListPo> {
    MessageListPo findByFenceName(String time, String name);
}
