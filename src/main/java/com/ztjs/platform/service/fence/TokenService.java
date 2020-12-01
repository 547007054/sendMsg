package com.ztjs.platform.service.fence;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.mapper.fence.TokenMapper;
import com.ztjs.platform.model.po.fence.TokenPo;
import org.springframework.stereotype.Service;
@Service
public class TokenService extends ServiceImpl<TokenMapper,TokenPo> {
    /**
     * 添加token值
     * @param po
     * @return
     */
    public int addToken(TokenPo po) {

        return this.baseMapper.insert(po);
    }
    public TokenPo getToken(TokenPo po) {
        QueryWrapper   <TokenPo>  queryWrapper = new QueryWrapper<>();
        queryWrapper.like("TOKEN",po.getToken());
        return this.baseMapper.selectOne(queryWrapper);
    }
    public TokenPo selectToken(){
        return this.baseMapper.selectToken();
    }
}