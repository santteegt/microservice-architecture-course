package com.ucuenca.dtic.courseregistry.controller;

import com.ucuenca.dtic.courseregistry.domain.TblCourses;
import com.ucuenca.dtic.courseregistry.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/registry/")
public class CourseRegistryController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseRegistryController.class);

    @Autowired
    CourseService courseService;

    @RequestMapping("/courses")
    public Iterable<TblCourses> queryAllCourses(
            @RequestParam(value = "id", required = false) Optional<String> id) {

        LOG.debug("Requesting courses with id={}", id);
        return id.isPresent() ? Arrays.asList(courseService.getCourseById(id.get())):courseService.findAllCourses();
    }

    @RequestMapping("/course/{id}")
    public TblCourses getCourseById(@PathVariable() String id) {

        LOG.debug("Requesting course with id={}", id);
        return courseService.getCourseById(id);
    }
}
