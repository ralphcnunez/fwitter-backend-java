package com.example.fwitterbackend;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PostService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PostRepository postRepository;
   
    public List<Posts> allPosts() {
        return postRepository.findAll();
    }

    
    public Optional<Posts> singlePost(ObjectId id) {
        return postRepository.findById(id);
    }
    

    
    public List<Posts> findPostsByUserId(String userId) {
        return postRepository.findPostsByUserId(userId);
    }


    public Posts createPost(String string, String postBody) {
        Posts post = postRepository.insert(new Posts( null, string, postBody, postBody, postBody, postBody, postBody, postBody, null));

        mongoTemplate.update(Posts.class)
            .matching(Criteria.where("userId").is(string))
            .apply(new Update().push("commentBody").value(postBody))
            .first();

        return post;
    }


    

    
}
