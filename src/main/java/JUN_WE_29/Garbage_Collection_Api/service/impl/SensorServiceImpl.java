package JUN_WE_29.Garbage_Collection_Api.service.impl;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.SensorRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.model.Dustbin;
import JUN_WE_29.Garbage_Collection_Api.model.Sensor;
import JUN_WE_29.Garbage_Collection_Api.repository.DustbinRepository;
import JUN_WE_29.Garbage_Collection_Api.repository.SensorRepository;
import JUN_WE_29.Garbage_Collection_Api.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;
    private final DustbinRepository dustbinRepository;

    @Override
    public void addSensor(Long id,SensorRequestDTO sensorRequestDTO) {

        Optional<Dustbin> dustbinOptional = dustbinRepository.findById(id);
        Dustbin dustbin = dustbinOptional.orElseThrow(
                () -> new RuntimeException("Dustbin not found")
        );
        Sensor sensor = new Sensor();
        sensor.setMqData(sensorRequestDTO.getMqData());
        sensor.setDistance(sensorRequestDTO.getDistance());
        sensor.setDustbin(dustbin);
        sensorRepository.save(sensor);
    }
}
