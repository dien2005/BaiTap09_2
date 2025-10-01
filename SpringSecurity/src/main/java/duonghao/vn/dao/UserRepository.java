package duonghao.vn.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import duonghao.vn.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
