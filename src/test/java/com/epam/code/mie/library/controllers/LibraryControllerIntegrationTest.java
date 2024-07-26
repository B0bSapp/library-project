package com.epam.code.mie.library.controllers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.epam.code.mie.library.LibraryApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LibraryApplication.class, webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = "/test-data.sql")
public class LibraryControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetBookByName() throws Exception {
        mockMvc.perform(get("/books/name")
                .param("name", "Test Book"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Book"))
                .andExpect(jsonPath("$.author.name").value("AuthorName"))
                .andExpect(jsonPath("$.genre").value("Genre"))
                .andExpect(jsonPath("$.description").value("Description"));
    }

    @Test
    public void testGetBookByName_NotFound() throws Exception {
        mockMvc.perform(get("/books/name")
                .param("name", "Nonexistent Book"))
                .andExpect(status().isNotFound());
    }
}
