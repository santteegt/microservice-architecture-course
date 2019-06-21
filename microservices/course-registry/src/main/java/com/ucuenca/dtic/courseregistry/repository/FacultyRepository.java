package com.ucuenca.dtic.courseregistry.repository;

import com.ucuenca.dtic.courseregistry.domain.TblFaculty;
import org.springframework.data.repository.CrudRepository;

public interface FacultyRepository extends CrudRepository<TblFaculty, String> {

}