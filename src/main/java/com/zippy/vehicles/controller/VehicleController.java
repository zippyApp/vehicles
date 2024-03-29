package com.zippy.vehicles.controller;

import org.springframework.web.bind.annotation.*;
import com.zippy.vehicles.service.interfaces.IVehicleService;
import com.zippy.vehicles.dto.VehicleDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
  private final IVehicleService vehicleService;

  public VehicleController(IVehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<VehicleDTO>> findAll() {
    return ResponseEntity.ok(vehicleService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<VehicleDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok(vehicleService.findById(id)); 
  }

  @GetMapping("/station/{stationId}")
  public ResponseEntity<List<VehicleDTO>> findByStationId(@PathVariable Long stationId) {
    return ResponseEntity.ok(vehicleService.findByStationId(stationId));
  }

  @GetMapping("/status/{name}")
  public ResponseEntity<List<VehicleDTO>> findByVehicleStatusName(@PathVariable String name) {
    return ResponseEntity.ok(vehicleService.findByVehicleStatusName(name));
  }

  @GetMapping("/type/{name}")
  public ResponseEntity<List<VehicleDTO>> findByVehicleTypeName(@PathVariable String name) {
    return ResponseEntity.ok(vehicleService.findByVehicleTypeName(name));
  }

  @GetMapping("/status/{name}/station/{stationId}")
  public ResponseEntity<List<VehicleDTO>> findByVehicleStatusNameAndStationId(@PathVariable String name, @PathVariable Long stationId) {
    return ResponseEntity.ok(vehicleService.findByVehicleStatusNameAndStationId(name, stationId));
  }
}
