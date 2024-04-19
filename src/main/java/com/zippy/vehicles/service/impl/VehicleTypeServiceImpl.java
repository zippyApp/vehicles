package com.zippy.vehicles.service.impl;

import com.zippy.vehicles.service.interfaces.IVehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zippy.vehicles.repository.IVehicleTypeRepository;
import com.zippy.vehicles.model.VehicleType;
import java.util.List;

@Service
public class VehicleTypeServiceImpl implements IVehicleTypeService {
  private IVehicleTypeRepository vehicleTypeRepository;

  public VehicleType findById(Integer id) {
    return vehicleTypeRepository.findById(id).orElse(null);
  }

  public VehicleType findByName(String name) {
    return vehicleTypeRepository.findByName(name).orElse(null);
  }

  public List<VehicleType> findAll() {
    return vehicleTypeRepository.findAll();
  }

  @Autowired
  public void setVehicleTypeRepository(IVehicleTypeRepository vehicleTypeRepository) {
    this.vehicleTypeRepository = vehicleTypeRepository;
  }

}
