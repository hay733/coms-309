package com.cs309.scout.tests;

import com.cs309.scout.controller.LocationController;
import com.cs309.scout.entity.Location;
import com.cs309.scout.repository.LocationRepository;
import com.cs309.scout.service.LocationService;
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
public class LocationMockitoTests {

    @InjectMocks
    LocationService locationService;

    @Mock
    private LocationRepository repo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLocationList() {
        List<Location> loc = new ArrayList<Location>();

        Location one = new Location(1, "Parks Library",  "701 Morrill Road, Ames, Iowa","A library at Iowa State University", 42.027584, -93.648789, 50010,"Libraries");
        Location two = new Location(2, "Ada Hayden Park", "5205 Grand Ave, Ames, Iowa", "A pretty park with a lake", 42.064430, -93.623400, 50010, "Parks");
        Location three = new Location(3, "North Grand Mall", "2801 Grand Ave, Ames, Iowa", "A mall located north of Ames", 42.049382, -93.621755, 50010, "Shopping Centers");

        loc.add(one);
        loc.add(two);
        loc.add(three);

        when(repo.findAll()).thenReturn(loc);

        assertEquals(one, loc.get(0));
        assertEquals(two, loc.get(1));
        assertEquals(three, loc.get(2));
    }

    @Test
    public void testLocationByID() {
        when(repo.findById(1)).thenReturn(new Location(1, "Parks Library", "701 Morrill Road, Ames, Iowa", "A library at Iowa State University",42.027584, -93.648789, 50010,"Libraries"));

        Location loc = locationService.findById(1);

        assertEquals(1, loc.getId());
        assertEquals("Parks Library", loc.getName());
        assertEquals("701 Morrill Road, Ames, Iowa", loc.getAddress());
        assertEquals("A library at Iowa State University", loc.getDescription());
        assertEquals(50010, loc.getZip());
        assertEquals("Libraries", loc.getFilter());
    }

    @Test
    public void getAllAccountTest() {
        List<String> list = new ArrayList<String>();
        String one = "Libraries";
        String two = "Parks";
        String three = "Shopping Centers";
        String four = "Restaurants";

        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        when(repo.findAllFilters()).thenReturn(list);

        List<String> filterList = locationService.findAllFilters();

        assertEquals(4, list.size());
        assertEquals(4, filterList.size());
        verify(repo, times(1)).findAllFilters();

        assertEquals(list.get(0), filterList.get(0));
        assertEquals(list.get(1), filterList.get(1));
        assertEquals(list.get(2), filterList.get(2));
        assertEquals(list.get(3), filterList.get(3));
    }
}
