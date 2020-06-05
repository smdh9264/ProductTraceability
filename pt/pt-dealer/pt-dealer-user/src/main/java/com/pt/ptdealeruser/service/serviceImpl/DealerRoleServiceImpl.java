package com.pt.ptdealeruser.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.pt.ptdealeruser.mapper.DealerRoleMapper;
import com.pt.ptdealeruser.entity.DealerRole;
import com.pt.ptdealeruser.service.DealerRoleService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class DealerRoleServiceImpl extends ServiceImpl<DealerRoleMapper,DealerRole> implements DealerRoleService{
    @Override
    public List<DealerRole> findRolesByUserId(String UserId) {
        return baseMapper.listRolesByUserId(UserId);
    }
}
