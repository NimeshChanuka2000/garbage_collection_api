package JUN_WE_29.Garbage_Collection_Api.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DustbinResponseDTO {

    private String name;

    private String city;

    private String street;

    private Float mqData;

    private Float distance;
}

