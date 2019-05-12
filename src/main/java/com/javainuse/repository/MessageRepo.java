package com.javainuse.repository;

import com.javainuse.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<User, Long> {
    User findByName(String name);
}
