package com.example.fwitterbackend;

import java.util.List;
import java.util.Map;

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

    public Posts(String string, String postBody2) {
    }

    @Id
    private ObjectId id; 

    private String userId; 

    private String postBody; 

    private String firstName; 

    private String lastName; 

    private String location; 

    private String description; 

    private String picturePath; 

    // private String userPicturePath; 

    // private Map<String, Boolean> likes;
    
    private String[] comments;

}