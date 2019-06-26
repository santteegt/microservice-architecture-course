package com.ucuenca.dtic.courseregistry.service;

import com.ucuenca.dtic.courseregistry.domain.TblCourses;
import com.ucuenca.dtic.courseregistry.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * Query a {@link TblCourses} record by its courseCode id
     *
     * @param courseCode course identifier
     * @return a {@link TblCourses} record
     */
    @Override
    public TblCourses getCourseById(String courseCode) {
        return courseRepository.findOne(courseCode);
    }

    /**
     * Obtain all available course in the repository
     *
     * @return an iterable object of {@link TblCourses} records
     */
    @Override
    public Iterable<TblCourses> findAllCourses() {
        return courseRepository.findAll();
    }
}
