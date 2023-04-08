package com.example.fwitterbackend;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;

    
    @GetMapping
    public ResponseEntity<List<Users>> getAllPosts() {
        return new ResponseEntity<List<Users>>(userService.allPosts(), HttpStatus.OK);
    }

             
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Users>> getSinglePost(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Users>>(userService.singlePost(id), HttpStatus.OK);
    }

    @GetMapping("/{userId}/all")
    public ResponseEntity<List<Users>> findPostsByUserId(@PathVariable String userId) {
        return new ResponseEntity<List<Users>>(HttpStatus.OK);
    }


    @CrossOrigin("http://localhost:3000")
    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Users>(userService.createUser(null, payload.get("email"), payload.get("firstName"),payload.get("lastName"), payload.get("password"),payload.get("picturePath"), payload.get("occupation"),payload.get("location")), HttpStatus.OK);
    }
 
    @CrossOrigin("http://localhost:3000")
    @PostMapping("/register")
    public ResponseEntity<Users> register(@ModelAttribute User user) {
      try {
        // String firstName = user.getFullName();
        // String lastName = user.getName();
        // String email = ((Users) user).getEmail();
        String password = user.getPassword();
        // String picturePath = ((Users) user).getPicturePath();
        // List<String> friends = ((Object) user).getFriends();
        String location = ((Users) user).getLocation();
        String occupation = ((Users) user).getOccupation();
  
        // String salt = ( (Object) new BCryptPasswordEncoder()).generateSalt(10);
        String passwordHash = new BCryptPasswordEncoder().encode(password);
  
        Users newUser = new Users();
  
        Users savedUser = userRepository.save(newUser);
  
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
 
}