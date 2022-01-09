package com.example.demo.web_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseCtrlTest {

    @Autowired
    private MockMvc mockMvc;

    // @Test
    // public void testStudentsPage() throws Exception {
    //     mockMvc.perform(get("/courses")).andExpect(status().isOk()).andExpect(view().name("detail"))
    //             .andExpect(content().string(Matchers.containsString("Sigle")));
    // }
}
