package JUN_WE_29.Garbage_Collection_Api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "dustbin")
@Data
public class Dustbin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;

    private String street;

    @ManyToMany
    @JoinTable(
            name = "dustbin_user",
            joinColumns = @JoinColumn(name = "dustbin_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userList;

    @OneToOne(mappedBy = "dustbin")
    private Sensor sensor;
}
