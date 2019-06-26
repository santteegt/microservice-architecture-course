package com.ucuenca.dtic.courseregistry.service;


import com.ucuenca.dtic.courseregistry.domain.TblFaculty;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacultyServiceTest {

    @Autowired
    private FacultyService facultyService;

    @Test
    public void getFacultiesTest() {
        Iterable<TblFaculty> faculties = this.facultyService.getAllFaculty();
        Assert.assertTrue("Total Courses should be 4",
                faculties != null && ((Collection<TblFaculty>) faculties).size() == 4 );
    }
}
