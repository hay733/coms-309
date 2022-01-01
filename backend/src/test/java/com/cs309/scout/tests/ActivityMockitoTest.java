package com.cs309.scout.tests;

import com.cs309.scout.controller.ActivityController;
import com.cs309.scout.entity.Activity;
import com.cs309.scout.repository.ActivityRepository;
import com.cs309.scout.service.ActivityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ActivityMockitoTest {

    @InjectMocks
    ActivityService activityService;

    @Mock
    private ActivityRepository repo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testActivityList() {
        List<Activity> act = new ArrayList<Activity>();

        Activity one = new Activity("Dog Therapy", new Date(), new Date(), "testfilter");
        Activity two = new Activity("Free Coffee at Bookends", new Date(), new Date(), "testfilter");
        Activity three = new Activity("Dance Marathon", new Date(), new Date(), "testfilter");

        act.add(one);
        act.add(two);
        act.add(three);

        when(repo.findAll()).thenReturn(act);
    }

    @Test
    public void testActivityByID() {
        when(repo.findById(1)).thenReturn(new Activity("Dog Therapy", new Date(), new Date(), "testfilter"));

        Activity act = activityService.findById(1);

        assertEquals("Dog Therapy", act.getName());
        assertEquals(0, act.getId());
    }

    @Test
    public void getAllAccountTest() {
        List<Activity> list = new ArrayList<Activity>();
        Activity actTwo = new Activity("50% Off Pizza Dinner", new Date(), new Date(), "Meal Discounts");
        Activity actThree = new Activity("Free Coffee for Finals", new Date(), new Date(), "Meal Discounts");

        list.add(actTwo);
        list.add(actThree);

        when(repo.allBoardElements(2)).thenReturn(list); //will match what we have in our database

        List<Activity> acctList = activityService.allBoardElements(2);

        assertEquals(2, acctList.size());
        verify(repo, times(1)).allBoardElements(2);
    }


}
