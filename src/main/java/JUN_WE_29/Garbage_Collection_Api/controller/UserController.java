package JUN_WE_29.Garbage_Collection_Api.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    @PostMapping("/collectors")
    public void addCollector(){
        System.out.println("add");
    }

    @GetMapping("/users")
    public void getUser(){
        System.out.println("get user");
    }
}
