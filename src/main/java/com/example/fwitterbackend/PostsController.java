package com.example.fwitterbackend;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tweets")
public class PostsController {

    @Autowired
    private PostService postService;


    
    @GetMapping
    public ResponseEntity<List<Posts>> getAllPosts() {
        return new ResponseEntity<List<Posts>>(postService.allPosts(), HttpStatus.OK);
    }

             
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Posts>> getSinglePost(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Posts>>(postService.singlePost(id), HttpStatus.OK);
    }

    @GetMapping("/{userId}/all")
    public ResponseEntity<List<Posts>> findPostsByUserId(@PathVariable String userId) {
        return new ResponseEntity<List<Posts>>(postService.findPostsByUserId(userId), HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity<Posts> createPost(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Posts>(postService.createPost(payload.get("userId"), payload.get("postBody")), HttpStatus.OK);
    }
 
 
}

 