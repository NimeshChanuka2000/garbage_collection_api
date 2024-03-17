package JUN_WE_29.Garbage_Collection_Api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class DustbinController {

    @PostMapping("/dustbins")
    public void addDusbin(){
        System.out.println("add dustbit");
    }
}
