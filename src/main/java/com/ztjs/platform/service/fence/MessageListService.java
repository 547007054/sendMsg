package com.ztjs.platform.service.fence;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.mapper.fence.MessageListMapper;
import com.ztjs.platform.model.po.fence.MessageListPo;
import org.springframework.stereotype.Service;

/**
 * Created by aa on 2019/9/11.
 */
@Service
public class MessageListService extends ServiceImpl<MessageListMapper,MessageListPo> {

    public int addMessageList(MessageListPo messageListPo){
        return this.baseMapper.insert(messageListPo);
    }
/*    public MessageListPo getMessage(MessageListPo po) {
        QueryWrapper<MessageListPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("PUSH_TIME", po.getTime());
        return this.baseMapper.selectOne(queryWrapper);
    }*/
    public MessageListPo getMessage(String time,String name) {
        return this.baseMapper.findByFenceName(time,name);
    }
}
