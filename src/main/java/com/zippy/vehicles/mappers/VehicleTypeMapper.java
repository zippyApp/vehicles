package com.zippy.vehicles.mappers;

import com.zippy.vehicles.dto.VehicleTypeDTO;
import com.zippy.vehicles.model.VehicleType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleTypeMapper {
  VehicleTypeMapper INSTANCE = Mappers.getMapper(VehicleTypeMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  VehicleTypeDTO vehicleTypeToVehicleTypeDTO(VehicleType vehicleType);
}
