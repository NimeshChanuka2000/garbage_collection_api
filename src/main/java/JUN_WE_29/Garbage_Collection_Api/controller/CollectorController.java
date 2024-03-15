package JUN_WE_29.Garbage_Collection_Api.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CollectorController {
    @PostMapping("/collectors")
    public void addCollector(){
        System.out.println("add");
    }
}
