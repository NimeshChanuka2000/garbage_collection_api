package JUN_WE_29.Garbage_Collection_Api.repository;

import JUN_WE_29.Garbage_Collection_Api.model.Role;
import JUN_WE_29.Garbage_Collection_Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    List<User> findAllByRole(Role role);
}
