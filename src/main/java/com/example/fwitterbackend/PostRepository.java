package com.example.fwitterbackend;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Repository

public interface PostRepository extends MongoRepository<Posts, ObjectId> {
 

    
}
