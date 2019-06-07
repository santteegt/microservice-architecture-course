package com.ucuenca.dtic.courseregistry.service;

import com.ucuenca.dtic.courseregistry.domain.TblCourses;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CourseServiceImpl implements CourseService {
    /**
     * Query a {@link TblCourses} record by its courseCode id
     *
     * @param courseCode course identifier
     * @return a {@link TblCourses} record
     */
    @Override
    public TblCourses getCourseById(String courseCode) {
        if (courseCode.compareTo("C001") == 0) {
            TblCourses course = new TblCourses("C001");
            course.setDescription("Demo Course");
            return course;
        } else {
            return null;
        }
    }

    /**
     * Obtain all available course in the repository
     *
     * @return an iterable object of {@link TblCourses} records
     */
    @Override
    public Iterable<TblCourses> findAllCourses() {
        TblCourses course = new TblCourses("C001");
        course.setDescription("Demo Course");
        return Arrays.asList(course);
    }
}
