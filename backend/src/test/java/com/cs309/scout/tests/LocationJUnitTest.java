package com.cs309.scout.tests;

import com.cs309.scout.entity.Location;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class LocationJUnitTest {

    @Test
    public void testLocationName() {
        Location loc = new Location(1, "Parks Library", "701 Morrill Road, Ames, IA", "Library at ISU", 42.027595, -93.648809, 50010, "Parks");
        assertEquals("Parks Library", loc.getName());
    }

    @Test
    public void testLocationAddress() {
        Location loc = new Location(1, "Parks Library", "701 Morrill Road, Ames, IA", "Library at ISU", 42.027595, -93.648809, 50010, "Parks");
        assertEquals("701 Morrill Road, Ames, IA", loc.getAddress());
    }

    @Test
    public void testLocationZip() {
        Location loc = new Location(1, "Parks Library", "701 Morrill Road, Ames, IA", "Library at ISU", 42.027595, -93.648809, 50010, "Parks");
        assertEquals(50010, loc.getZip());
    }
}
