package JUN_WE_29.Garbage_Collection_Api.service;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.UserAuthRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.UserRegisterRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.UserUpdateRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserRegisterResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserLoginResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserUpdateDeleteResponseDTO;

import java.util.List;

public interface UserService {

    UserRegisterResponseDTO addUser(UserRegisterRequestDTO requestDTO);

    UserLoginResponseDTO authenticate( UserAuthRequestDTO requestDTO);

    List<UserResponseDTO> getUser();

    UserUpdateDeleteResponseDTO updateUser(Long id, UserUpdateRequestDTO userUpdateRequestDTO);

    UserUpdateDeleteResponseDTO deleteUser(Long id);
}
