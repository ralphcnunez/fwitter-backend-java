package com.example.fwitterbackend;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
   
    public List<Posts> allPosts() {
        return postRepository.findAll();
    }

    
    public Optional<Posts> singlePost(ObjectId id) {
        return postRepository.findById(id);
    }
    



    
}
