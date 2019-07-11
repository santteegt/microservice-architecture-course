package com.ucuenca.dtic.enrollment.repository;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // Needed to inject MockMVC when testing Spring Data Rest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc // Needed to inject MockMVC when testing Spring Data Rest
@ActiveProfiles("test")
public class StudentDataRestRepositoryTest {

    @Autowired
    private MockMvc mvc;

    private static final String STUDENT_ID = "4444444444";
    private static final String STUDENT_NAME = "Santiago Gonzalez";
    private static final String CREATION_DATE = "2019-07-09";

    @Test
    public void givenRepository_whenGetBase_thenFindStudentEndpoint() throws Exception {
        MvcResult result = mvc.perform(
                get("/").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andReturn();

        String jsonString = result.getResponse().getContentAsString();
        Assert.isTrue(new JSONObject(jsonString).getJSONObject("_links").has("students"),
                "Data Rest should have students endpoint");
    }

    @Test
    public void givenStudentsRepository_whenGetStudents_thenReturnOk()
            throws Exception {

        mvc.perform(
            get("/student").contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk());
    }

    @Test
    public void givenStudentRepository_whenGetWithNonStoredRecordId_thenReturnNotFound()
            throws Exception {

        mvc.perform(
                get("/student/XXXXXXXXXX").contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
    }

    @Test
    public void givenStudentRepository_whenPutNewRecord_thenReturnNewlyCreatedReg()
            throws Exception {

        JSONObject data = new JSONObject();
        data.put("name", STUDENT_NAME);
        data.put("creationDate", CREATION_DATE);

        mvc.perform(
                put("/student/" + STUDENT_ID).contentType(MediaType.APPLICATION_JSON).content(data.toString())
        ).andExpect(status().isCreated());

        MvcResult rs = mvc.perform(
                get("/student/" + STUDENT_ID).contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk()).andReturn();

        data = new JSONObject(rs.getResponse().getContentAsString());

        Assert.isTrue(data.has("name") && data.getString("name").compareTo(STUDENT_NAME) == 0,
                String.format("Data Rest record should have %s as name parameter", STUDENT_NAME));
    }

}
