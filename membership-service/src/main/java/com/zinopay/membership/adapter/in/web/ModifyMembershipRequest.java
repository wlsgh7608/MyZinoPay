package com.zinopay.membership.adapter.in.web;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModifyMembershipRequest {
    private String address;
    private String email;
    private String name;
    private boolean isCorp;
}
