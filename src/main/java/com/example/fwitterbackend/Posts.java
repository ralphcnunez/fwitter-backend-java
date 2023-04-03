package com.example.fwitterbackend;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posts {

    @Id
    private ObjectId id; 

    private String userId; 

    private String firstName; 

    private String lastName; 

    private String location; 

    private String description; 

    private String picturePath; 

    private String userPicturePath; 

    // private List<String>likes ;

    // private List<Comments> comments  ; 

}