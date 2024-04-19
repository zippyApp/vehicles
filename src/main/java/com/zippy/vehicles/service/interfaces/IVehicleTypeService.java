package com.zippy.vehicles.service.interfaces;

import java.util.List;
import com.zippy.vehicles.model.VehicleType;

public interface IVehicleTypeService {
  VehicleType findById(Integer id);

  VehicleType findByName(String name);

  List<VehicleType> findAll();
}
