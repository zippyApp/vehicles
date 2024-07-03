package com.zippy.vehicles;

import com.zippy.vehicles.dto.VehicleDTO;
import com.zippy.vehicles.mappers.VehicleMapper;
import com.zippy.vehicles.model.Vehicle;
import com.zippy.vehicles.model.VehicleStatus;
import com.zippy.vehicles.model.VehicleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleMapperTest {

    private final VehicleMapper vehicleMapper = Mappers.getMapper(VehicleMapper.class);

    private Vehicle vehicle;
    private VehicleDTO vehicleDTO;

    @BeforeEach
    public void setUp() {

        vehicle = Vehicle.builder()
                .id(1L)
                .vehicleType(VehicleType.builder()
                        .id(1)
                        .name("BYKE")
                        .build())
                .vehicleStatus(VehicleStatus.builder()
                        .id(1)
                        .name("Available")
                        .build())
                .stationId(1L)
                .electric(true)
                .batteryLevel(80)
                .build();

        vehicleDTO = VehicleDTO.builder()
                .id(1L)
                .type("BYKE")
                .status("Available")
                .stationId(1L)
                .electric(true)
                .batteryLevel(80)
                .build();
    }

    // Intención: Verificar que el método vehicleToVehicleDTO realice correctamente el mapeo de Vehicle a VehicleDTO.
    @Test
    public void testVehicleToVehicleDTO() {
        VehicleDTO result = vehicleMapper.vehicleToVehicleDTO(vehicle);

        assertEquals(vehicleDTO.getId(), result.getId());
        assertEquals(vehicleDTO.getType(), result.getType());
        assertEquals(vehicleDTO.getStatus(), result.getStatus());
        assertEquals(vehicleDTO.getStationId(), result.getStationId());
        assertEquals(vehicleDTO.isElectric(), result.isElectric());
        assertEquals(vehicleDTO.getBatteryLevel(), result.getBatteryLevel());
    }
}
