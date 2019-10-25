package com.trilogy.motorcycleservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogy.motorcycleservice.dao.MotorcycleDao;
import com.trilogy.motorcycleservice.model.Motorcycle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(MotorcycleController.class)
public class MotorcycleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MotorcycleDao motorcycleDao;

    private ObjectMapper mapper = new ObjectMapper();


    @Test
    public void createMotorcycle() throws Exception{
        Motorcycle motoIn = new Motorcycle(
                1, BigDecimal.valueOf(10.99), "1","honda","vroom","1999", "black"
        );
        Motorcycle motoOut = new Motorcycle(
                1, BigDecimal.valueOf(10.99), "1","honda","vroom","1999", "black"
        );


        String inputJson = mapper.writeValueAsString(motoIn);

        String outputJson = mapper.writeValueAsString(motoOut);

        when(motorcycleDao.save(motoIn)).thenReturn(motoOut);

        mockMvc.perform(MockMvcRequestBuilders.post("/motorcycles")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void readMotorcycle() {
        String outputJson = mapper.writeValueAsString(bvm);

        when(bookService.findById(2)).thenReturn(bvm);

        this.mockMvc.perform(get("/books/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updateMotorcycle() {
    }

    @Test
    public void deleteMotorcycle() {
    }

    @Test
    public void getAllMotorcycles() {
    }
}