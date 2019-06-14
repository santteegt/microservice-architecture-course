package com.ucuenca.dtic.enrollment.repository;

import com.ucuenca.dtic.enrollment.domain.Enrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "enrollment", collectionResourceRel = "enrollment")
public interface EnrollmentDataRestRepository extends PagingAndSortingRepository<Enrollment, String> {

    @Override
    Iterable<Enrollment> findAll(Sort var1);

    @Override
    Page<Enrollment> findAll(Pageable var1);

    @Override
    Enrollment findOne(String id);
}

