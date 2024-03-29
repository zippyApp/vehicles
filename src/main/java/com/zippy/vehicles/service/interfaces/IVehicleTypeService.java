package com.zippy.vehicles.service.interfaces;

import java.util.List;
import com.zippy.vehicles.model.VehicleType;

public interface IVehicleTypeService {
  public VehicleType findById(Integer id);

  public VehicleType findByName(String name);

  public List<VehicleType> findAll();
}
