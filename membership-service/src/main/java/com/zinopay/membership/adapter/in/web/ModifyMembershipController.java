package com.zinopay.membership.adapter.in.web;

import com.zinopay.common.WebAdapter;
import com.zinopay.membership.application.port.in.ModifyMembershipCommand;
import com.zinopay.membership.application.port.in.ModifyMembershipUseCase;
import com.zinopay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequiredArgsConstructor
public class ModifyMembershipController {
    private final ModifyMembershipUseCase modifyMembershipUseCase;


    @PutMapping("/membership/{membershipId}")
    public ResponseEntity<Membership> modifyMembership(
            @PathVariable String membershipId,
            @RequestBody ModifyMembershipRequest request) {
        // command
        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(membershipId)
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .isCorp(request.isCorp())
                .build();

        Membership membership = modifyMembershipUseCase.modifyMembership(command);
        return ResponseEntity.ok(membership);


    }
}
