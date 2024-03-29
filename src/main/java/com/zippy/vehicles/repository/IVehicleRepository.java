package com.zippy.vehicles.repository;

import com.zippy.vehicles.model.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
  List<Vehicle> findByStationId(Long stationId);

  List<Vehicle> findByVehicleStatusName(String name);

  List<Vehicle> findByVehicleTypeName(String name);

  List<Vehicle> findByStationIdAndVehicleStatusName(Long stationId, String name);
}