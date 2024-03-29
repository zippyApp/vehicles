package com.zippy.vehicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zippy.vehicles.model.VehicleType;
import java.util.Optional;

@Repository
public interface IVehicleTypeRepository extends JpaRepository<VehicleType, Integer> {
  Optional<VehicleType> findByName(String name);
}
