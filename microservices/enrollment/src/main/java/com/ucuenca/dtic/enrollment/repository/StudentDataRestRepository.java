package com.ucuenca.dtic.enrollment.repository;

import com.ucuenca.dtic.enrollment.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "student", collectionResourceRel = "students")
public interface StudentDataRestRepository extends PagingAndSortingRepository<Student, String> {

    @Override
    Iterable<Student> findAll(Sort var1);

    @Override
    Page<Student> findAll(Pageable var1);

    @Override
    Student findOne(String id);

}
