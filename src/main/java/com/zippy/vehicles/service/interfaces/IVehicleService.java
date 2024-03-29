package com.zippy.vehicles.service.interfaces;

import com.zippy.vehicles.dto.VehicleDTO;
import java.util.List;

public interface IVehicleService {
  public List<VehicleDTO> findAll();
  public VehicleDTO findById(Long id);
  public List<VehicleDTO> findByStationId(Long stationId);
  public List<VehicleDTO> findByVehicleStatusName(String name);
  public List<VehicleDTO> findByVehicleTypeName(String name);
  public List<VehicleDTO> findByVehicleStatusNameAndStationId(String name, Long stationId);
}
