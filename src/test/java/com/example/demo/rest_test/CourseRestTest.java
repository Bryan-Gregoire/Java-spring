package com.example.demo.rest_test;

import com.example.demo.web.restCtrl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(restCtrl.class)
public class CourseRestTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private restCtrl restService;

    @Test
    public void getUserByName() throws Exception {
        mvc.perform(get("/api/coursesjson")).andExpect(status().isOk());
    }
}