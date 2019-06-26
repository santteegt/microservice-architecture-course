package com.ucuenca.dtic.courseregistry.service;

import com.ucuenca.dtic.courseregistry.domain.TblCourses;
import com.ucuenca.dtic.courseregistry.repository.CourseRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void getCourseByIdTest() {

        TblCourses course = this.courseService.getCourseById("SUB001");
        Assert.assertTrue("Course with code SUB001 should be found and has \"MATEMATICAS\" as description",
                course != null && course.getDescription().compareTo("MATEMATICAS") == 0);
    }

    @Test
    public void getCoursesTest() {
       Iterable<TblCourses> courses = this.courseService.findAllCourses();
       Assert.assertTrue("Total Courses should be 5",
               courses != null && ((Collection<TblCourses>) courses).size() == 5 );
    }
}