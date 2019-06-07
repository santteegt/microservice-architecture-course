package com.ucuenca.dtic.courseregistry.service;

import com.ucuenca.dtic.courseregistry.domain.TblCourses;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

    // @MockBean is used when the service is not yet implemented
//    @MockBean
    @Mock
    private CourseService courseService;

    @Before
    public void setup() {
        // With this call to initMocks we tell Mockito to process the annotations
        MockitoAnnotations.initMocks(this);
        this.courseService = new CourseServiceImpl();
    }

    @Test
    public void getCourseByIdTest() {
        TblCourses course = this.courseService.getCourseById("C001");
        Assert.assertTrue("Course with code C001 should be found and has \"Demo Course \" as description",
                course != null && course.getDescription().compareTo("Demo Course") == 0);

        course = this.courseService.getCourseById("C002");
        Assert.assertTrue("Course C002 should not be found", course == null);
    }

    @Test
    public void getCoursesTest() {
       Iterable<TblCourses> courses = this.courseService.findAllCourses();
       Assert.assertTrue("Total Courses should be 1",
               courses != null && ((Collection<TblCourses>) courses).size() == 1 );
    }
}