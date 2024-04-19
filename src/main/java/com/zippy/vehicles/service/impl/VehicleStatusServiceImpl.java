package com.zippy.vehicles.service.impl;

import com.zippy.vehicles.service.interfaces.IVehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zippy.vehicles.repository.IVehicleStatusRepository;
import jakarta.annotation.Nonnull;

import com.zippy.vehicles.model.VehicleStatus;
import java.util.List;

@Service
public class VehicleStatusServiceImpl implements IVehicleStatusService {
  private  IVehicleStatusRepository vehicleStatusRepository;


  public VehicleStatus findById(@Nonnull Integer id) {
    return vehicleStatusRepository.findById(id).orElse(null);
  }

  public VehicleStatus findByName(String name) {
    return vehicleStatusRepository.findByName(name).orElse(null);
  }

  public List<VehicleStatus> findAll() {
    return vehicleStatusRepository.findAll();
  }

  @Autowired
  public void setVehicleStatusRepository(IVehicleStatusRepository vehicleStatusRepository) {
    this.vehicleStatusRepository = vehicleStatusRepository;
  }
}
