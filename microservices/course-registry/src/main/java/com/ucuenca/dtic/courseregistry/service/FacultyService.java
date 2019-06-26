package com.ucuenca.dtic.courseregistry.service;

import com.ucuenca.dtic.courseregistry.domain.TblFaculty;

public interface FacultyService {
    /**
     * Obtain all the available faculties in the repository
     * @return an iterable object of {@link TblFaculty} records
     */
    Iterable<TblFaculty> getAllFaculty();

}