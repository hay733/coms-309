package com.cs309.scout.tests;

import com.cs309.scout.controller.UserController;
import com.cs309.scout.entity.User;
import com.cs309.scout.repository.UserRepository;
import com.cs309.scout.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
public class UserMockitoTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUserByID() {
        when(userRepository.findById(1)).thenReturn(new User("kmytien", "MyTien", "Kien",
                "classof2023", "kmytien@iastate.edu", 2023,
                50013, "Ames", "Iowa"));

        User user = userService.findById(1);

        assertEquals("kmytien", user.getUsername());
        assertEquals(2023, user.getAge());
        assertEquals("classof2023", user.getPassword());

        verify(userRepository).findById(1);
    }
}
