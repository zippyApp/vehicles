package com.zippy.vehicles.service.interfaces;

import com.zippy.vehicles.model.Vehicle;
import java.util.List;

public interface IVehicleService {
  List<Vehicle> findAll();

  Vehicle findById(Long id);

  List<Vehicle> findByStationId(Long stationId);

  List<Vehicle> findByVehicleStatusName(String name);

  List<Vehicle> findByVehicleTypeName(String name);

  List<Vehicle> findByVehicleStationIdAndStatusName(Long stationId, String name);

  Vehicle updateVehicleStatusByName(Long id, String status);

  Vehicle updateVehicleStatusById(Long id, Integer statusId);

  Vehicle updateVehicleStation(Long id, Long stationId);

}
