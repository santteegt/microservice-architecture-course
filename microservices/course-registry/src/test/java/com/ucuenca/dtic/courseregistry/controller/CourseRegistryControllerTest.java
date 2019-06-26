package com.ucuenca.dtic.courseregistry.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.*;

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
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(5)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[*].courseCode").isNotEmpty());

    }

    @Test
    public void givenRegistry_andIdSUB001_whenGetCoursesByid_thenReturnCourse()
            throws Exception {

        mvc.perform(
                get("/registry/courses?id=SUB001")
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[{\"courseCode\":\"SUB001\",\"description\":\"MATEMATICAS\"}]"));

    }

    @Test
    public void givenRegistry_andIdSUB002_whenGetCoursesByid_thenReturnCourse()
            throws Exception {

        mvc.perform(
                get("/registry/courses?id=SUB002")
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[{\"courseCode\":\"SUB002\",\"description\":\"CALCULO\"}]"));
    }

    @Test
    public void givenRegistry_whenGetCoursesSUB001_thenReturnCourse()
            throws Exception {

        mvc.perform(
                get("/registry/course/SUB001")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"courseCode\":\"SUB001\",\"description\":\"MATEMATICAS\"}"));
    }

    @Test
    public void givenRegistry_whenGetCoursesSUB002_thenReturnCourse()
            throws Exception {

        mvc.perform(
                get("/registry/course/SUB002")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json("{\"courseCode\":\"SUB002\",\"description\":\"CALCULO\"}"));
    }

    @Test
    public void givenFaculty_whenGetFaculties_thenReturnFaculties()
            throws Exception {

        mvc.perform(
                get("/registry/faculty")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].facultyId").isNotEmpty());

    }

}
