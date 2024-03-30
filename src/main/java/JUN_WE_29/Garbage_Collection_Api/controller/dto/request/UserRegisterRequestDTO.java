package JUN_WE_29.Garbage_Collection_Api.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequestDTO {

    private String username;

    private String password;

    private String email;

    private String phone;

    private String role;
}
