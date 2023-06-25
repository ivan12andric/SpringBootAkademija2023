package hr.kingict.akademija2023.springbootakademija2023.repository;

import hr.kingict.akademija2023.springbootakademija2023.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
