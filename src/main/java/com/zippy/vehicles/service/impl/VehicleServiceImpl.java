package com.zippy.vehicles.service.impl;

import com.zippy.vehicles.service.interfaces.IVehicleService;

import com.zippy.vehicles.repository.IVehicleRepository;
import java.util.List;
import com.zippy.vehicles.model.Vehicle;
import com.zippy.vehicles.model.VehicleStatus;

import com.zippy.vehicles.service.interfaces.IVehicleStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.Nonnull;

@Service
public class VehicleServiceImpl implements IVehicleService {
  private IVehicleRepository vehicleRepository;
  private IVehicleStatusService vehicleStatusService;


  public List<Vehicle> findAll() {
    return vehicleRepository.findAll();
  }

  public Vehicle findById(@Nonnull Long id) {
    return vehicleRepository.findById(id).orElse(null);
  }

  public List<Vehicle> findByStationId(Long stationId) {
    return vehicleRepository.findByStationId(stationId);
  }

  public List<Vehicle> findByVehicleStatusName(String name) {
    return vehicleRepository.findByVehicleStatusName(name);
  }

  public List<Vehicle> findByVehicleTypeName(String name) {
    return vehicleRepository.findByVehicleTypeName(name);
  }

  public List<Vehicle> findByVehicleStationIdAndStatusName(Long stationId, String name) {
    return vehicleRepository.findByStationIdAndVehicleStatusName(stationId, name);
  }

  public Vehicle updateVehicleStatusByName(Long id, String status) {
    Vehicle vehicle = findById(id);
    VehicleStatus vehicleStatus = vehicleStatusService.findByName(status);
    if (vehicle != null && vehicleStatus != null && vehicle.getVehicleStatus() != vehicleStatus) {
      vehicle.setVehicleStatus(vehicleStatus);
      vehicleRepository.save(vehicle);
    }
    return vehicle;
  }

  public Vehicle updateVehicleStatusById(Long id, Integer statusId) {
    Vehicle vehicle = findById(id);
    VehicleStatus vehicleStatus = vehicleStatusService.findById(statusId);
    if (vehicle != null && vehicleStatus != null && vehicle.getVehicleStatus() != vehicleStatus) {
      vehicle.setVehicleStatus(vehicleStatus);
      vehicleRepository.save(vehicle);
    }
    return vehicle;
  }

  public Vehicle updateVehicleStation(Long id, Long stationId) {
    Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
    if (vehicle != null) {
      vehicle.setStationId(stationId);
      vehicleRepository.save(vehicle);
    }
    return vehicle;
  }

  @Autowired
  public void setVehicleRepository(IVehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @Autowired
  public void setVehicleStatusService(IVehicleStatusService vehicleStatusService) {
    this.vehicleStatusService = vehicleStatusService;
  }
}
