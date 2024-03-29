package com.zippy.vehicles.service.interfaces;

import com.zippy.vehicles.model.Vehicle;
import java.util.List;

public interface IVehicleService {
  public List<Vehicle> findAll();

  public Vehicle findById(Long id);

  public List<Vehicle> findByStationId(Long stationId);

  public List<Vehicle> findByVehicleStatusName(String name);

  public List<Vehicle> findByVehicleTypeName(String name);

  public List<Vehicle> findByVehicleStationIdAndStatusName(Long stationId, String name);

  public Vehicle updateVehicleStatusByName(Long id, String status);

  public Vehicle updateVehicleStatusById(Long id, Integer statusId);

  public Vehicle updateVehicleStation(Long id, Long stationId);

}
