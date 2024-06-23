package com.zinopay.membership.adapter.in.web;


import com.zinopay.common.WebAdapter;
import com.zinopay.membership.application.port.in.RegisterMembershipCommand;
import com.zinopay.membership.application.port.in.RegisterMembershipUsecase;
import com.zinopay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUsecase registerMembershipUsecase;


    @PostMapping("/membership/register")
    public Membership registerMembersihp(@RequestBody RegisterMembershipRequest request) {
        // request
        // request -> command

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .isCorp(request.isCorp())
                .isValid(true)
                .build();

        // usecase(command)
        return registerMembershipUsecase.registerMembership(command);
    }


}
