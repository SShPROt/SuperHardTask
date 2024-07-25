package com.example.superhardtask.users.controller;

import com.example.superhardtask.entity.User;
import com.example.superhardtask.repository.UserRepository;
import com.example.superhardtask.rest.dto.UserRequestDto;
import com.example.superhardtask.rest.dto.UserResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UserRepository userRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13.2");

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertThat(postgreSQLContainer.isCreated()).isTrue();
        assertThat(postgreSQLContainer.isRunning()).isTrue();
    }

    @SneakyThrows
    @Test
    void getUser() {
        mvc.perform(get("http://localhost:4040/user?mail=vlad"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @SneakyThrows
    @Test
    void postUser() {
        UserResponseDto userResponseDto;
        MvcResult result = mvc.perform(post("http://localhost:4040/user")
                        .content(objectMapper.writeValueAsString(new UserRequestDto("Vladmail", "vlad")))
                        .contentType("application/json"))
//                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        userResponseDto = objectMapper.readValue(result.getResponse().getContentAsString(), UserResponseDto.class);
        User user = userRepository.findById(userResponseDto.id()).orElse(null);
        assertThat(user).isNotNull();
    }
}