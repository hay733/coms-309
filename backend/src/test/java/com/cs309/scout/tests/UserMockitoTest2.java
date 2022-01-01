package com.cs309.scout.tests;

import com.cs309.scout.entity.ScheduledEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import com.cs309.scout.entity.User;
import com.cs309.scout.repository.UserRepository;
import com.cs309.scout.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserMockitoTest2 {

    @TestConfiguration
    static class StringContextConfiguration { // can be named whatever

        @Bean
        public UserService uService() {
            return new UserService();
        }

        @Bean
        UserRepository getRepo() {
            return mock(UserRepository.class);
        }
    }

    @Autowired
    private UserService us;

    @Autowired
    private UserRepository repo;

    @Test
    public void basicMethodsTest() {
        List<User> list = new ArrayList<>();

        when(repo.findAll()).thenReturn(list);

        //mock the save() method to save argument to the list
        when(repo.save((User) org.mockito.Matchers.any(User.class)))
                .thenAnswer(x -> {
                    User u = x.getArgument(0);
                    list.add(u);
                    return null;
                });
    }
}
