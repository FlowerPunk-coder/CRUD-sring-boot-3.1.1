package web311.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import web311.entity.User;
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
}
