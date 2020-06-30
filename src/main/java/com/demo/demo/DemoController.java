package com.demo.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class DemoController {
//Take note , Oauth 2.0 security.
    @RequestMapping(
            value = "/user/{userId}/detail",
            produces = "application/json",
            method = RequestMethod.GET
    )
    public ResponseEntity<User> getUser(@PathVariable("userId") String id){
        log.info("GET: received request from front end with id of - {}", id);
//        log.debug("");
//        log.error("");
        //assume this is what we would get from the db
        User user = new User("yang", "zhao", "well",18);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    // create a new endpoint for POST action which accept a UserAddressModel
    // Upon receiving the request use System.out.println() to print out the details of this request
    // then return a dummy UserModel with UserAddressModel information.
    // Note: hardcoded value is okay for now since there is no real database yet.
    // Hint: add a private field to hold UserAddress information in the user Model

    @RequestMapping(
            value = "/user/{userId}/detail",
            produces = "application/json",
            method = RequestMethod.POST
    )

    public ResponseEntity<UserAddressModel> getUser2(@PathVariable("userId") String id){
        System.out.println("POST: received request from front end with id of - " + id    );
        //assume this is what we would get from the db
        UserAddressModel user = new UserAddressModel("123321", "123 Nl drive");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
