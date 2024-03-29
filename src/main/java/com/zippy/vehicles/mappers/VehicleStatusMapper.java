package com.zippy.vehicles.mappers;

import com.zippy.vehicles.dto.VehicleStatusDTO;
import com.zippy.vehicles.model.VehicleStatus;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleStatusMapper {
  VehicleStatusMapper INSTANCE = Mappers.getMapper(VehicleStatusMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  VehicleStatusDTO vehicleStatusToVehicleStatusDTO(VehicleStatus vehicleStatus);

}
