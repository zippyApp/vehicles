package com.zippy.vehicles.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class VehicleDTO {
    private Long id;
    private String type;
    private String status;
    private Long stationId;
    private boolean electric;
    private int batteryLevel;
}
