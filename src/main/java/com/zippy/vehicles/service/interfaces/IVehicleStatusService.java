package com.zippy.vehicles.service.interfaces;

import java.util.List;

import com.zippy.vehicles.model.VehicleStatus;

public interface IVehicleStatusService {
  VehicleStatus findById(Integer id);

  VehicleStatus findByName(String name);

  List<VehicleStatus> findAll();
}
