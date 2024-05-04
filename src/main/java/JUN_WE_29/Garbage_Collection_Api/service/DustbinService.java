package JUN_WE_29.Garbage_Collection_Api.service;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.DustbinRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.DustbinResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DustbinService {

    void addDustbin(DustbinRequestDTO dustbinRequestDTO);

    DustbinResponseDTO getDustbin(Long id);

    List<DustbinResponseDTO> getAllDustbin();

}
