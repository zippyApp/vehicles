package com.zippy.vehicles.service.interfaces;

import java.util.List;

import com.zippy.vehicles.model.VehicleStatus;

public interface IVehicleStatusService {
  public VehicleStatus findById(Integer id);

  public VehicleStatus findByName(String name);

  public List<VehicleStatus> findAll();
}
