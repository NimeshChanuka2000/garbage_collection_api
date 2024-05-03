package JUN_WE_29.Garbage_Collection_Api.controller;


import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.DustbinRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.DustbinResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.service.DustbinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DustbinController {

    private DustbinService dustbinService;

    @PostMapping("/sensors/{id}/dustbins")
    public void addDustbin(@PathVariable Long id, @RequestBody DustbinRequestDTO dustbinRequestDTO){
        dustbinService.addDustbin(dustbinRequestDTO,id);
    }

    @GetMapping("/dustbin/{id}")
    public DustbinResponseDTO getDustbin(@PathVariable Long id){
        return dustbinService.getDustbin(id);
    }


}
