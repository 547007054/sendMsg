package com.ztjs.platform.mapper.fence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztjs.platform.model.po.fence.TokenPo;

public interface TokenMapper extends BaseMapper<TokenPo> {
   TokenPo getToken(TokenPo po);
   TokenPo selectToken();
}