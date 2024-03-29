package com.zippy.vehicles.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vehicle")
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vehicle_type_id", referencedColumnName = "id")
  private VehicleType vehicleType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vehicle_status_id", referencedColumnName = "id")
  private VehicleStatus vehicleStatus;

  @Column(name = "electric")
  private boolean electric;

  @Column(name = "battery")// rename to battery_level
  private int batteryLevel;

  @Column(name = "station_id")
  private long stationId;
}
