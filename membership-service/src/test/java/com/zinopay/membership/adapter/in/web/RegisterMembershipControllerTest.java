package com.zinopay.membership.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zinopay.membership.domain.Membership;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegisterMembershipControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("회원가입 테스트")
    void testReigsterMembership() throws Exception {

        // request
        RegisterMembershipRequest request = new RegisterMembershipRequest(
                "name1",
                "address 1",
                "abc@abc.com",
                false
        );

        Membership membership = Membership.builder()
                .membershipId("1")
                .name("name1")
                .address("address 1")
                .email("abc@abc.com")
                .isCorp(false)
                .isValid(true)
                .build();

        // mvc test
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/membership/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        mapper.writeValueAsString(membership)));

    }


}