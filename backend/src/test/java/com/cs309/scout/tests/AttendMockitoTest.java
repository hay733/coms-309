package com.cs309.scout.tests;

import com.cs309.scout.entity.Activity;
import com.cs309.scout.entity.Attend;
import com.cs309.scout.repository.ActivityRepository;
import com.cs309.scout.repository.AttendRepository;
import com.cs309.scout.service.ActivityService;
import com.cs309.scout.service.AttendService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class AttendMockitoTest {

    @InjectMocks
    AttendService attendService;

    @Mock
    private AttendRepository repo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAttendList() {
        List<Attend> at = new ArrayList<Attend>();

        Attend one = new Attend(1);
        Attend two = new Attend(0);
        Attend three = new Attend(1);

        at.add(one);
        at.add(two);
        at.add(three);

        when(repo.findAll()).thenReturn(at);
    }

    @Test
    public void testAttendByID() {
        when(repo.findById(3)).thenReturn(new Attend(1));

        Attend at = attendService.findById(3);

        assertEquals(1, at.getFavorite());
    }

    @Test
    public void testAllFavorites() {
        List<Attend> list = new ArrayList<Attend>();
        Attend one = new Attend(1);

        list.add(one);

        when(repo.allFavorites(1)).thenReturn(list);

        List<Attend> favList = attendService.allFavorites(1);

        assertEquals(1, list.size());
        assertEquals(1, favList.size());
        verify(repo, times(1)).allFavorites(1);

        assertEquals(list.get(0), favList.get(0));
    }
}