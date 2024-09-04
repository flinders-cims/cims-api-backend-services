package com.flinders.cims.repository;


import com.flinders.cims.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface
UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailId(String username);

    Optional<User> findByUsername(String username);
}

