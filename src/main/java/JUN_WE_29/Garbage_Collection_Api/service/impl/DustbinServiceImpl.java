package JUN_WE_29.Garbage_Collection_Api.service.impl;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.DustbinRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.DustbinResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.model.Dustbin;
import JUN_WE_29.Garbage_Collection_Api.model.Sensor;
import JUN_WE_29.Garbage_Collection_Api.repository.DustbinRepository;
import JUN_WE_29.Garbage_Collection_Api.repository.SensorRepository;
import JUN_WE_29.Garbage_Collection_Api.service.DustbinService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DustbinServiceImpl implements DustbinService {

    private DustbinRepository dustbinRepository;
    private SensorRepository sensorRepository;

    @Override
    public void addDustbin(DustbinRequestDTO dustbinRequestDTO, Long id) {
        Optional<Sensor> optionalSensor = sensorRepository.findById(id);
        if (optionalSensor.isPresent()) {
            Dustbin dustbin = new Dustbin();
            dustbin.setName(dustbinRequestDTO.getName());
            dustbin.setCity(dustbinRequestDTO.getCity());
            dustbin.setStreet(dustbinRequestDTO.getStreet());

            Sensor sensor = optionalSensor.get();
            dustbin.setSensor(sensor);
            dustbinRepository.save(dustbin);
        }
    }

    @Override
    public DustbinResponseDTO getDustbin(Long id) {
        Optional<Dustbin>optionalDustbin = dustbinRepository.findById(id);
        Dustbin dustbin = optionalDustbin.orElseThrow(
                () -> new RuntimeException("Dustbin not found")
        );
        DustbinResponseDTO dustbinResponseDTO = new DustbinResponseDTO();
        dustbinResponseDTO.setName(dustbin.getName());
        dustbinResponseDTO.setCity(dustbin.getCity());
        dustbinResponseDTO.setStreet(dustbin.getStreet());
        dustbinResponseDTO.setMqData(dustbin.getSensor().getMqData());
        dustbinResponseDTO.setDistance(dustbin.getSensor().getDistance());

        return dustbinResponseDTO;
        }

}