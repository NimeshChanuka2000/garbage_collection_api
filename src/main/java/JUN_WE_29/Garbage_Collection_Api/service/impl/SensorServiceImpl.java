package JUN_WE_29.Garbage_Collection_Api.service.impl;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.SensorRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.model.Sensor;
import JUN_WE_29.Garbage_Collection_Api.repository.SensorRepository;
import JUN_WE_29.Garbage_Collection_Api.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    @Override
    public void addSensor(SensorRequestDTO sensorRequestDTO) {
        Sensor sensor = new Sensor();
        sensor.setMqData(sensorRequestDTO.getMqData());
        sensor.setDistance(sensorRequestDTO.getDistance());
        sensorRepository.save(sensor);
    }
}
