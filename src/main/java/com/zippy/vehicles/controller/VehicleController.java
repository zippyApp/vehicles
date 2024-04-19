package com.zippy.vehicles.controller;

// General
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

// Services
import com.zippy.vehicles.service.interfaces.IVehicleService;
import com.zippy.vehicles.service.interfaces.IVehicleStatusService;
import com.zippy.vehicles.service.interfaces.IVehicleTypeService;

// DTOs
import com.zippy.vehicles.dto.VehicleDTO;
import com.zippy.vehicles.dto.VehicleStatusDTO;
import com.zippy.vehicles.dto.VehicleTypeDTO;

// Mappers
import com.zippy.vehicles.mappers.VehicleMapper;
import com.zippy.vehicles.mappers.VehicleStatusMapper;
import com.zippy.vehicles.mappers.VehicleTypeMapper;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
  private final IVehicleStatusService vehicleStatusService;
  private final IVehicleService vehicleService;
  private final IVehicleTypeService vehicleTypeService;

  public VehicleController(IVehicleService vehicleService, IVehicleStatusService vehicleStatusService,
      IVehicleTypeService vehicleTypeService) {
    this.vehicleService = vehicleService;
    this.vehicleStatusService = vehicleStatusService;
    this.vehicleTypeService = vehicleTypeService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<VehicleDTO>> findAll() {
    return ResponseEntity
        .ok(vehicleService.findAll().stream().map(VehicleMapper.INSTANCE::vehicleToVehicleDTO).toList());
  }

  @GetMapping("/{id}")
  public ResponseEntity<VehicleDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok(VehicleMapper.INSTANCE.vehicleToVehicleDTO(vehicleService.findById(id)));
  }

  @PutMapping("/{id}/status/{statusName}")
  public ResponseEntity<VehicleDTO> updateVehicleStatus(@PathVariable Long id, @PathVariable String statusName) {
    return ResponseEntity
        .ok(VehicleMapper.INSTANCE.vehicleToVehicleDTO(vehicleService.updateVehicleStatusByName(id, statusName)));
  }

  @PutMapping("/{id}/station/{stationId}")
  public ResponseEntity<VehicleDTO> updateVehicleStatus(@PathVariable Long id, @PathVariable Long stationId) {
    return ResponseEntity
        .ok(VehicleMapper.INSTANCE.vehicleToVehicleDTO(vehicleService.updateVehicleStation(id, stationId)));
  }

  @GetMapping("/status/{name}")
  public ResponseEntity<List<VehicleDTO>> findByVehicleStatusName(@PathVariable String name) {
    return ResponseEntity.ok(vehicleService.findByVehicleStatusName(name).stream()
        .map(VehicleMapper.INSTANCE::vehicleToVehicleDTO).toList());
  }

  @GetMapping("/status/all")
  public ResponseEntity<List<VehicleStatusDTO>> findAllVehicleStatus() {
    return ResponseEntity.ok(vehicleStatusService.findAll().stream()
        .map(VehicleStatusMapper.INSTANCE::vehicleStatusToVehicleStatusDTO).toList());
  }

  @GetMapping("/type/all")
  public ResponseEntity<List<VehicleTypeDTO>> findAllVehicleType() {
    return ResponseEntity.ok(vehicleTypeService.findAll().stream()
        .map(VehicleTypeMapper.INSTANCE::vehicleTypeToVehicleTypeDTO).toList());
  }

  @GetMapping("/type/{name}")
  public ResponseEntity<List<VehicleDTO>> findByVehicleTypeName(@PathVariable String name) {
    return ResponseEntity.ok(
        vehicleService.findByVehicleTypeName(name).stream().map(VehicleMapper.INSTANCE::vehicleToVehicleDTO).toList());
  }

  @GetMapping("/station/{stationId}")
  public ResponseEntity<List<VehicleDTO>> findByStationId(@PathVariable Long stationId) {
    return ResponseEntity.ok(
        vehicleService.findByStationId(stationId).stream().map(VehicleMapper.INSTANCE::vehicleToVehicleDTO).toList());
  }

  @GetMapping("/station/{stationId}/status/{name}")
  public ResponseEntity<List<VehicleDTO>> findByVehicleStationIdAndStatusName(@PathVariable Long stationId,
      @PathVariable String name) {
    return ResponseEntity.ok(vehicleService.findByVehicleStationIdAndStatusName(stationId, name).stream()
        .map(VehicleMapper.INSTANCE::vehicleToVehicleDTO).toList());
  }
}
