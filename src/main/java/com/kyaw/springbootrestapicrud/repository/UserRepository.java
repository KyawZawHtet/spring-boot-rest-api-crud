package com.kyaw.springbootrestapicrud.repository;

import com.kyaw.springbootrestapicrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Step 2

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
