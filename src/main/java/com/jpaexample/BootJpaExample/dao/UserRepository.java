package com.jpaexample.BootJpaExample.dao;

import com.jpaexample.BootJpaExample.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
