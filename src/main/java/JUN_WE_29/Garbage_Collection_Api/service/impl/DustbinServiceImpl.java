package JUN_WE_29.Garbage_Collection_Api.service.impl;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.DustbinRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.DustbinResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.model.Dustbin;
import JUN_WE_29.Garbage_Collection_Api.repository.DustbinRepository;
import JUN_WE_29.Garbage_Collection_Api.service.DustbinService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DustbinServiceImpl implements DustbinService {

    private DustbinRepository dustbinRepository;
    @Override
    public DustbinResponseDTO addDustbin(DustbinRequestDTO dustbinRequestDTO) {
        Dustbin dustbin = new Dustbin();
        dustbin.setName(dustbinRequestDTO.getName());

        dustbinRepository.save(dustbin);

        DustbinResponseDTO dustbinResponseDTO = new DustbinResponseDTO();
        dustbinResponseDTO.setName(dustbin.getName());

        return dustbinResponseDTO;
    }
}
