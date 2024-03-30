package JUN_WE_29.Garbage_Collection_Api.controller;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.UserAuthRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.UserRegisterRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserRegisterResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserLoginResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/authenticate",headers = ("version=v1"))
    public UserLoginResponseDTO authenticate(@RequestBody UserAuthRequestDTO requestDTO) {

        return userService.authenticate(requestDTO);
    }
    @RolesAllowed("ADMIN")
    @PostMapping(value = "/register",headers = ("version=v1"))
    public UserRegisterResponseDTO addUser(@RequestBody UserRegisterRequestDTO requestDTO){

        return  userService.addUser(requestDTO);
    }
    @RolesAllowed({"USER","ADMIN"})
    @GetMapping(value = "/users",headers = ("version=v1"))
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("This is the all users in our system");
    }
}
