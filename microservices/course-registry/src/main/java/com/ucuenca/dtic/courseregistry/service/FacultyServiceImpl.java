package com.ucuenca.dtic.courseregistry.service;

import com.ucuenca.dtic.courseregistry.domain.TblFaculty;
import com.ucuenca.dtic.courseregistry.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    FacultyRepository facultyRepository;

    /**
     * Obtain all the available faculties in the repository
     *
     * @return an iterable object of {@link TblFaculty} records
     */

    @Override
    public Iterable<TblFaculty> getAllFaculty() {

        return facultyRepository.findAll();
    }
}
