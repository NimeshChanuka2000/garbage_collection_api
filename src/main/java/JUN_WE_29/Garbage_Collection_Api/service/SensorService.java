package JUN_WE_29.Garbage_Collection_Api.service;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.SensorRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface SensorService {

    void addSensor(Long id,SensorRequestDTO sensorRequestDTO);
}
