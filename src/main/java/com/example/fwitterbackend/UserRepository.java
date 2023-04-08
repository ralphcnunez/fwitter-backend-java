package com.example.fwitterbackend;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, ObjectId> {

    List<Users> findPostsByUserId(ObjectId userId);
    
}
