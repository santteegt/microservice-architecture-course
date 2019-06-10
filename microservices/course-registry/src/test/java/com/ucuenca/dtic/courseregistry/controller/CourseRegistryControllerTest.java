package com.ucuenca.dtic.courseregistry.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc // Needed to inject MockMVC for testing
public class CourseRegistryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenRegistry_whenGetCourses_thenReturnCourses()
            throws Exception {

        mvc.perform(
                get("/registry/courses")
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[{\"courseCode\":\"C001\",\"description\":\"Demo Course\"}]"));

    }

    @Test
    public void givenRegistry_andIdC001_whenGetCoursesByid_thenReturnCourse()
            throws Exception {

        mvc.perform(
                get("/registry/courses?id=C001")
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[{\"courseCode\":\"C001\",\"description\":\"Demo Course\"}]"));
    }

    @Test
    public void givenRegistry_andIdC002_whenGetCoursesByid_thenReturnNull()
            throws Exception {

        mvc.perform(
                get("/registry/courses?id=C002")
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[null]"));
    }

    @Test
    public void givenRegistry_whenGetCoursesC001_thenReturnCourse()
            throws Exception {

        mvc.perform(
                get("/registry/course/C001")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"courseCode\":\"C001\",\"description\":\"Demo Course\"}"));
    }

    @Test
    public void givenRegistry_whenGetCoursesC002_thenReturnNull()
            throws Exception {

        mvc.perform(
                get("/registry/courses/C002")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }
}
