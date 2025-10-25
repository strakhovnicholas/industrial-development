package ru.strakhov.devs.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PagesController.class)
class PagesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHomePageReturnsCorrectView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void testHomePageContainsRequiredModelAttributes() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("contactForm"))
                .andExpect(model().attributeExists("propertyForm"));
    }

    @Test
    void testHomePageRendersCorrectly() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Агентство")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("КомфортDom")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Связаться")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Добавить объект")));
    }
}
