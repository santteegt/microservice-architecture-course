package com.ucuenca.dtic.courseregistry.service;

import com.ucuenca.dtic.courseregistry.domain.TblCourses;

public interface CourseService {

    /**
     * Query a {@link TblCourses} record by its courseCode id
     * @param courseCode course identifier
     * @return a {@link TblCourses} record
     */
    TblCourses getCourseById(String courseCode);

    /**
     * Obtain all available course in the repository
     * @return an iterable object of {@link TblCourses} records
     */
    Iterable<TblCourses> findAllCourses();
}
