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
public class EnrollmentDataRestRepositoryTest {

    @Autowired
    private MockMvc mvc;

    private static final String STUDENT_ID = "5555555555";
    private static final String ENROLLMENT_ID = "EING010099";

    @Test
    public void givenRepository_whenGetBase_thenFindEnrollmentEndpoint() throws Exception {
        MvcResult result = mvc.perform(
                get("/").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        String jsonString = result.getResponse().getContentAsString();
        Assert.isTrue(new JSONObject(jsonString).getJSONObject("_links").has("enrollment"),
                "Data Rest should have enrollment endpoint");
    }

    @Test
    public void givenEnrollmentRepository_whenGetEnrollments_thenReturnOk() throws Exception {
        mvc.perform(
                get("/enrollment").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    public void givenEnrollmentRepository_whenGetWithNonStoredRecordId_thenReturnNotFound() throws Exception {
        mvc.perform(
                get("/enrollment/ZZZZZZZZZZ").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNotFound());
    }

    @Test
    public void givenEnrollmentRepository_whenPutNewRecord_thenReturnNewEntity()
            throws Exception {

        JSONObject data = new JSONObject();
        data.put("name", "Dummy Record");
        data.put("creationDate", "2019-07-09");

        mvc.perform(
                put(String.format("/student/%s", STUDENT_ID))
                    .contentType(MediaType.APPLICATION_JSON).content(data.toString())
        ).andExpect(status().isCreated());

        data = new JSONObject();
        data.put("studentId", STUDENT_ID);
        data.put("facultyId", "ING");
        data.put("programmeId", "MSCWSBDA");
        data.put("term", 1);
        data.put("creationDate", "2019-07-09");

        mvc.perform(
                put(String.format("/enrollment/%s", ENROLLMENT_ID))
                        .contentType(MediaType.APPLICATION_JSON).content(data.toString())
        ).andExpect(status().isCreated());

        mvc.perform(
                get(String.format("/enrollment/%s", ENROLLMENT_ID)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
