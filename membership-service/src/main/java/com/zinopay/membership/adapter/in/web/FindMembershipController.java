package com.zinopay.membership.adapter.in.web;

import com.zinopay.membership.application.port.in.FindMembershipCommand;
import com.zinopay.membership.application.port.in.FindMembershipUseCase;
import com.zinopay.membership.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequiredArgsConstructor
public class FindMembershipController {
    private final FindMembershipUseCase findMembershipUseCase;


    @GetMapping("/membership/{membershipId}")
    public ResponseEntity<Membership> findMembership(@PathVariable String membershipId) {

        // command
        FindMembershipCommand command = FindMembershipCommand.builder()
                .membershipId(membershipId)
                .build();

        Membership membership = findMembershipUseCase.findMembership(command);
        return ResponseEntity.ok(membership);


    }
}
