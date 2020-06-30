package com.cmsystem.wms.mapper;

import com.cmsystem.wms.model.ApproveLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApproveLogMapper {

    Integer insert(@Param("approveLog") ApproveLog approveLog);

}
