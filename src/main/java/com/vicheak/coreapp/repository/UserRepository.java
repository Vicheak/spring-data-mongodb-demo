package com.vicheak.coreapp.repository;

import com.vicheak.coreapp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {



}
