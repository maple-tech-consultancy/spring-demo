package com.demo.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // query by id (document id)
    User getById(String id);

    User getFirstByAgeLessThan(int age);
}
