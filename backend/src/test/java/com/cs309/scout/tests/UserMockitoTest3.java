package com.cs309.scout.tests;

import com.cs309.scout.controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import com.cs309.scout.entity.User;
import com.cs309.scout.repository.UserRepository;
import com.cs309.scout.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(controllers = UserController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserMockitoTest3 {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private List<User> userList;

    @BeforeEach
    void setUp() {
        this.userList = new ArrayList<>();

        User user1 = new User("isudummy", "isu", "dummy",
                "classof2023", "isudummy@iastate.edu", 20,
                50013, "Ames", "Iowa");
        User user2 = new User("isuCy", "isu", "Cy",
                "password", "isuCy@iastate.edu", 2021,
                50013, "Ames", "Iowa");
        User user3 = new User("ash", "Ash", "Kien",
                "imacat", "ashkien@iastate.edu", 5,
                50013, "Ames", "Iowa");

        this.userList.add(user1);
        this.userList.add(user2);
        this.userList.add(user3);
    }

    //not working for some reason
   /* @Test
    public void allUsersTest() throws Exception {
        UserService myService = mock(UserService.class, Mockito.RETURNS_DEEP_STUBS);
        given(myService.findAll()).willReturn(userList);

        this.mockMvc.perform(get("/user/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(userList.size())));
    }*/
}
