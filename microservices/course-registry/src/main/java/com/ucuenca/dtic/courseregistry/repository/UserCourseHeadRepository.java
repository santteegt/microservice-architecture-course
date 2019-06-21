package com.ucuenca.dtic.courseregistry.repository;

import com.ucuenca.dtic.courseregistry.domain.TblUsercoursehead;
import com.ucuenca.dtic.courseregistry.domain.TblUsercourseheadPK;
import org.springframework.data.repository.CrudRepository;

public interface UserCourseHeadRepository extends
        CrudRepository<TblUsercoursehead, TblUsercourseheadPK> {

}
