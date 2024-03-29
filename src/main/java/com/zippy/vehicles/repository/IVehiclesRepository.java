package com.zippy.vehicles.repository;
import com.zippy.vehicles.model.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IVehiclesRepository extends JpaRepository<Vehicle, Long>{
  @SuppressWarnings("null")
  List<Vehicle> findAll();
  @SuppressWarnings("null")
  Optional<Vehicle> findById(Long id);
  List<Vehicle> findByStationId(Long stationId);
  List<Vehicle> findByVehicleStatusName(String name);
  List<Vehicle> findByVehicleTypeName(String name);
  List<Vehicle> findByVehicleStatusNameAndStationId(String name, Long stationId);
}
