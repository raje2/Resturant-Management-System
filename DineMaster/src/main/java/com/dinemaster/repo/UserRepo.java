package com.dinemaster.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinemaster.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
