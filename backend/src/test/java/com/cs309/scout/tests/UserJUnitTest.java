package com.cs309.scout.tests;

import com.cs309.scout.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class UserJUnitTest {

    @Test
    public void userFullNameTest() {
        User user = new User("isudummy", "isu", "dummy",
                             "classof2023", "isudummy@iastate.edu", 2023,
                             50013, "Ames", "Iowa");

        assertEquals("isu", user.getFirst_name());
        assertEquals("dummy", user.getLast_name());
    }

    @Test
    public void userEmailTest() {
        User user = new User("isudummy", "isu", "dummy",
                "classof2023", "isudummy@iastate.edu", 2023,
                50013, "Ames", "Iowa");

        assertEquals("isudummy@iastate.edu", user.getEmail());
    }

    @Test
    public void userLocationTest() {
        User user = new User("isudummy", "isu", "dummy",
                "classof2023", "isudummy@iastate.edu", 2023,
                50013, "Ames", "Iowa");

        assertEquals("Ames", user.getCity());
        assertEquals("Iowa", user.getState());
    }
}
