package com.example.fwitterbackend;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;
   
    public List<Users> allPosts() {
        return userRepository.findAll();
    }

    
    public Optional<Users> singlePost(ObjectId id) {
        return userRepository.findById(id);
    }
    

    
    public List<Users> findPostsByUserId(ObjectId userId) {
        return userRepository.findPostsByUserId(userId);
    }


    public Users createUser(ObjectId id, String firstName, String lastName, String email, String password, String picturePath, String occupation, String location) {
        Users user = userRepository.insert(new Users(id, firstName, lastName, email, password, picturePath, occupation, location ));

        mongoTemplate.update(User.class)
            .matching(Criteria.where("id").is(id))
            .apply(new Update().push("firstName").value(firstName).push("lastName").value(lastName).push("password").value(password).push("picturePath").value(picturePath).push("occupation").value(occupation).push("email").value(email).push("location").value(location))
            // .apply(new Update().push("lastName").value(lastName))
            // .apply(new Update().push("password").value(password))

            .first();

        return user;
    }


    

    
}
