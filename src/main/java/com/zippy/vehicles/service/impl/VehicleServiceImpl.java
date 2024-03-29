package com.zippy.vehicles.service.impl;

import com.zippy.vehicles.service.interfaces.IVehicleService;
import com.zippy.vehicles.repository.IVehiclesRepository;
import java.util.List;
import com.zippy.vehicles.dto.VehicleDTO;
import com.zippy.vehicles.mappers.VehicleMapper;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements IVehicleService{
  private final IVehiclesRepository vehicleRepository;

  public VehicleServiceImpl(IVehiclesRepository vehicleRepository){
    this.vehicleRepository = vehicleRepository;
  }

  public List<VehicleDTO> findAll(){
    return vehicleRepository.findAll().stream().map(VehicleMapper.INSTANCE::vehicleToVehicleDTO).toList();
  }

  public VehicleDTO findById(Long id){
    return VehicleMapper.INSTANCE.vehicleToVehicleDTO(vehicleRepository.findById(id).orElse(null));
  }

  public List<VehicleDTO> findByStationId(Long stationId){
    return vehicleRepository.findByStationId(stationId).stream().map(VehicleMapper.INSTANCE::vehicleToVehicleDTO).toList();
  }

  public List<VehicleDTO> findByVehicleStatusName(String name){
    return vehicleRepository.findByVehicleStatusName(name).stream().map(VehicleMapper.INSTANCE::vehicleToVehicleDTO).toList();
  }

  public List<VehicleDTO> findByVehicleTypeName(String name){
    return vehicleRepository.findByVehicleTypeName(name).stream().map(VehicleMapper.INSTANCE::vehicleToVehicleDTO).toList();
  }

  public List<VehicleDTO> findByVehicleStatusNameAndStationId(String name, Long stationId){
    return vehicleRepository.findByVehicleStatusNameAndStationId(name, stationId).stream().map(VehicleMapper.INSTANCE::vehicleToVehicleDTO).toList();
  }
}
