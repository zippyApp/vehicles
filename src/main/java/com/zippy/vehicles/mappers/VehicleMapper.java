package com.zippy.vehicles.mappers;

import com.zippy.vehicles.dto.VehicleDTO;
import com.zippy.vehicles.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {
  VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "type", source = "vehicleType.name")
  @Mapping(target = "status", source = "vehicleStatus.name")
  @Mapping(target = "stationId", source = "stationId")
  @Mapping(target = "electric", source = "electric")
  @Mapping(target = "batteryLevel", source = "batteryLevel")
  VehicleDTO vehicleToVehicleDTO(Vehicle vehicle);
}