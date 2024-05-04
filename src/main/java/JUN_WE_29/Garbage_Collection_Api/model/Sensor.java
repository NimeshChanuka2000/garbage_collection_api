package JUN_WE_29.Garbage_Collection_Api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor")
@Data
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float mqData;
    private float distance;
    private LocalDateTime createdAt;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dustbin_id")
    private Dustbin dustbin;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
