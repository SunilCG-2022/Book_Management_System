package com.cg.bookmanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
