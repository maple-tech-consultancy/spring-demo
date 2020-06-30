package com.demo.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class DemoController {

    @Autowired
    private UserRepository userRepository;

    //Take note , Oauth 2.0 security.
    // refactor this endpoint
    // query by first name and age less than a value
    // note: first name needs to be passed as PathVariable, and age value needs to be passed as Query parameter
    // write a new query method in UserRepository
    // return the query result to FE
    @RequestMapping(
            value = "/user/{userId}/detail",
            produces = "application/json",
            method = RequestMethod.GET
    )
    public ResponseEntity<User> getUser(@PathVariable("userId") String id) {
        log.info("GET: received request from front end with id of - {}", id);

        User user = userRepository.getById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    // refactor this endpoint to have a request body
    // request body has user related information such as name, age, nick name
    // create a new user based on the incoming request body and store in the database
    // return the saved document to the FE
    // challenge: store User address related information using UserAddressModel in the user collection
    @RequestMapping(
            value = "/user/{userId}/detail",
            produces = "application/json",
            method = RequestMethod.POST
    )
    public ResponseEntity<User> postUser(@PathVariable("userId") String id) {
        System.out.println("POST: received request from front end with id of - " + id);
        // create a dummy user
        User user = new User();
        user.setAge(18);
        user.setFirstName("Jim");
        user.setLastName(id);

        // save to database
        User savedUser = userRepository.save(user);

        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
}
