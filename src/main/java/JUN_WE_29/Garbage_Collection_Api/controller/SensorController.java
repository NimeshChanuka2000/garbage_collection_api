package JUN_WE_29.Garbage_Collection_Api.controller;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.SensorRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor

public class SensorController {

    private final SensorService sensorService;

    @PostMapping("/sensors")
    public void addSensor(@RequestBody SensorRequestDTO sensorRequestDTO) {
        sensorService.addSensor(sensorRequestDTO);
    }

}
