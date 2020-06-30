package com.demo.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserModelTest {

    @Test
    void testUser(){
        //Act
        User newUser = new User("yang", "zhao", "well",18);
        UserAddressModel newUser2 = new UserAddressModel("123321", "123 Nl drive");
        //Assert
        assertEquals("yang", newUser.getFirstName());
        assertEquals("zhao", newUser.getLastName());
        assertEquals("well", newUser.getNickName());
        assertEquals("123321", newUser2.getUserID());
        assertEquals("123 Nl drive", newUser2.getUserAddress());

    }
}
