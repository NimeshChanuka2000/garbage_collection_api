package JUN_WE_29.Garbage_Collection_Api.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DustbinRequestDTO {

    private String name;

    private String city;

    private String street;


}
