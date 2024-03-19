package JUN_WE_29.Garbage_Collection_Api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String phone;

    @ManyToMany(mappedBy = "userList")
    private List<Dustbin> dustbinList;
}
