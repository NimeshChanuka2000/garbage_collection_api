package JUN_WE_29.Garbage_Collection_Api.repository;

import JUN_WE_29.Garbage_Collection_Api.model.Dustbin;
import JUN_WE_29.Garbage_Collection_Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DustbinRepository extends JpaRepository<Dustbin,Long> {

}
