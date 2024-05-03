package JUN_WE_29.Garbage_Collection_Api.service;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.DustbinRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.DustbinResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface DustbinService {

    void addDustbin(DustbinRequestDTO dustbinRequestDTO, Long id);
}
