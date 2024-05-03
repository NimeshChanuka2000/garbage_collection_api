package JUN_WE_29.Garbage_Collection_Api.controller;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.UserAuthRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.UserRegisterRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.UserUpdateRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserRegisterResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserLoginResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserUpdateDeleteResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/authenticate",headers = ("version=v1"))
    public UserLoginResponseDTO authenticate(@RequestBody UserAuthRequestDTO requestDTO) {

        return userService.authenticate(requestDTO);
    }
    @RolesAllowed({"ADMIN"})
    @PostMapping(value = "/register",headers = ("version=v1"))
    public UserRegisterResponseDTO addUser(@RequestBody UserRegisterRequestDTO requestDTO){

        return  userService.addUser(requestDTO);
    }
    @RolesAllowed({"USER","ADMIN"})
    @GetMapping(value = "/get-all",headers = ("version=v1"))
    public List<UserResponseDTO> getUser(){
        return userService.getUser();
    }

    @RolesAllowed({"ADMIN"})
    @PutMapping(value = "/{id}/update", headers = ("version=v1"))
    public UserUpdateDeleteResponseDTO userUpdate(@PathVariable Long id, @RequestBody UserUpdateRequestDTO userUpdateRequestDTO){
        return userService.updateUser(id,userUpdateRequestDTO);
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/{id}/delete")
    public UserUpdateDeleteResponseDTO userDelete(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
