package JUN_WE_29.Garbage_Collection_Api.controller;


import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.DustbinRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.DustbinResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.service.DustbinService;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DustbinController {

    private DustbinService dustbinService;

//    @RolesAllowed("ADMIN")
    @PostMapping("/sensors/{id}/dustbins")
    public void addDustbin(@PathVariable Long id, @RequestBody DustbinRequestDTO dustbinRequestDTO){
        dustbinService.addDustbin(dustbinRequestDTO,id);
    }

//    @RolesAllowed("ADMIN")
    @GetMapping("/dustbin/{id}")
    public DustbinResponseDTO getDustbin(@PathVariable Long id){
        return dustbinService.getDustbin(id);
    }

    @GetMapping("/dustbins")
    public List<DustbinResponseDTO> getAllDustbin(){
        return dustbinService.getAllDustbin();
    }
}
