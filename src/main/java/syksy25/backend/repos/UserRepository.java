package syksy25.backend.repos;

import org.springframework.data.repository.CrudRepository;

import syksy25.backend.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
