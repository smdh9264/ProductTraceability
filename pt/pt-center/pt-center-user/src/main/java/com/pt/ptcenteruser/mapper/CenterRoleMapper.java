package com.pt.ptcenteruser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pt.ptcenteruser.entity.CenterRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CenterRoleMapper extends BaseMapper<CenterRole> {
    List<CenterRole> listRolesByUserId(@Param("userId") String userId);
}