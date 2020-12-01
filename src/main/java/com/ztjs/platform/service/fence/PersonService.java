package com.ztjs.platform.service.fence;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.mapper.fence.PersonMapper;
import com.ztjs.platform.model.po.fence.PersonPo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * Created by aa on 2019/8/20.
 */
@Service
public class PersonService extends ServiceImpl<PersonMapper,PersonPo>{

    /**
     * 查询人员信息
     * @return`
     */
    /*public List<Map<String, Object>> getPerson() {
        QueryWrapper<PersonPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("LONGITUDE");
        queryWrapper.isNotNull("LATITUDE");
        queryWrapper.isNotNull("WE_CHAT_ID");
        queryWrapper.isNotNull("UNION_ID");
        queryWrapper.isNotNull("FLAG");
        return this.baseMapper.selectMaps(queryWrapper);
//        return this.baseMapper.selectList(queryWrapper);
    }*/
    public List<PersonPo> getPerson() {
        return this.baseMapper.getPerson();
    }

    /**
     * 更改flag
     */
    public PersonPo updateFlag(PersonPo po) {
        try {
            this.baseMapper.updateById(po);
            return po;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }

}
