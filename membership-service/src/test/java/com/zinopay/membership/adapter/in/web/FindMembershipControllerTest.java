package com.zinopay.membership.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zinopay.membership.application.port.in.RegisterMembershipCommand;
import com.zinopay.membership.application.service.RegisterMembershipService;
import com.zinopay.membership.domain.Membership;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class FindMembershipControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    RegisterMembershipService registerMembershipService;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        registerMembershipService.registerMembership(RegisterMembershipCommand.builder()
                .name("name1")
                .address("address 1")
                .email("abc@abc.com")
                .isValid(true)
                .isCorp(false)
                .build());
    }


    @DisplayName("회원찾기 테스트")
    @Test
    void findMembershipTest() throws Exception {

        Membership expect = Membership.builder()
                .membershipId("1")
                .name("name1")
                .address("address 1")
                .email("abc@abc.com")
                .isCorp(false)
                .isValid(true)
                .build();


        String membershipId = "1";
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/membership/{membershipId}", membershipId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(expect)))
        ;


    }


}