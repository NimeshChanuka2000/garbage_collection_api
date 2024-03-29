package JUN_WE_29.Garbage_Collection_Api.controller;


import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.DustbinRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.DustbinResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.service.DustbinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DustbinController {

    private DustbinService dustbinService;

    @PostMapping("/dustbins")
    public DustbinResponseDTO addDusbin(@RequestBody DustbinRequestDTO dustbinRequestDTO){
        return dustbinService.addDustbin(dustbinRequestDTO);
    }
    @GetMapping("/dustbins")
    public void readAllDusbin(){
        System.out.println("read all dustbin");
    }
}
