package JUN_WE_29.Garbage_Collection_Api.service.impl;

import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.UserAuthRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.request.UserRegisterRequestDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserRegisterResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.controller.dto.response.UserLoginResponseDTO;
import JUN_WE_29.Garbage_Collection_Api.model.Role;
import JUN_WE_29.Garbage_Collection_Api.model.User;
import JUN_WE_29.Garbage_Collection_Api.repository.UserRepository;
import JUN_WE_29.Garbage_Collection_Api.security.JwtService;
import JUN_WE_29.Garbage_Collection_Api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserRegisterResponseDTO addUser(UserRegisterRequestDTO requestDTO) {

        if (requestDTO.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        User user = new User();
        user.setUsername(requestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        user.setEmail(requestDTO.getEmail());
        user.setPhone(requestDTO.getPhone());
        user.setRole(Role.valueOf(requestDTO.getRole()));

        user = userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new UserRegisterResponseDTO(token,"User Register Successful");

    }

    @Override
    public UserLoginResponseDTO authenticate(UserAuthRequestDTO requestDTO) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDTO.getUsername(),
                        requestDTO.getPassword()
                )
        );

        User user = userRepository.findByUsername(requestDTO.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
        String token = jwtService.generateToken(user);

        return new UserLoginResponseDTO(token,"User Login Successful");
    }


}
