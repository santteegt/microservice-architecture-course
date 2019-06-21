package com.ucuenca.dtic.courseregistry.repository;

import com.ucuenca.dtic.courseregistry.domain.TblCourses;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<TblCourses, String> {

}
