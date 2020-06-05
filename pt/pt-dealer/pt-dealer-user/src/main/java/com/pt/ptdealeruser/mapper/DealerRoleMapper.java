package com.pt.ptdealeruser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pt.ptdealeruser.entity.DealerRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DealerRoleMapper extends BaseMapper<DealerRole> {
    List<DealerRole> listRolesByUserId(@Param("userId") String userId);
}