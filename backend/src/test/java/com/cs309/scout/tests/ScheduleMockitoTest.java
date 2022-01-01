package com.cs309.scout.tests;

import com.cs309.scout.entity.ScheduledEvent;
import com.cs309.scout.repository.ScheduledEventRepository;
import com.cs309.scout.service.ScheduledEventService;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class ScheduleMockitoTest {

    @MockBean
    ScheduledEventService seService;

    @MockBean
    ScheduledEventRepository repo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void allEventsTest() {
        List<ScheduledEvent> events = new ArrayList<>();

        when(repo.findAll()).thenReturn(events);
        when(repo.save((ScheduledEvent) org.mockito.Matchers.any(ScheduledEvent.class)))
                .thenAnswer(x -> {
                    ScheduledEvent s = x.getArgument(0);
                    events.add(s);
                    return null;
                });

        ScheduledEvent one = new ScheduledEvent("COM S 321", new Date(), new Date(), true);
        ScheduledEvent two = new ScheduledEvent("Work", new Date(), new Date(), true);

        events.add(one);
        events.add(two);

        when(seService.allEventsScheduled(1)).thenReturn(events);
        List<ScheduledEvent> list = seService.allEventsScheduled(1);

        verify(seService).allEventsScheduled(1);
    }
}
