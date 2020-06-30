package com.cmsystem.wms.mapper;

import com.cmsystem.wms.entity.Sort;
import com.cmsystem.wms.model.Warehouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    Warehouse findById(@Param("id") Integer id);

    List<Warehouse> selectWhere(@Param("warehouse") Warehouse warehouse, @Param("sort") Sort sort);

    Integer update(@Param("warehouse") Warehouse warehouse);

    @Update("update warehouse set is_del = now() where id in (${ids})")
    Integer deleteByIds(@Param("ids") String ids);

    Integer insert(@Param("warehouse") Warehouse warehouse);

    List<Warehouse> selectAll();

}
