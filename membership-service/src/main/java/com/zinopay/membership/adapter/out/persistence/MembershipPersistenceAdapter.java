package com.zinopay.membership.adapter.out.persistence;

import com.zinopay.membership.application.port.out.FindMembershipPort;
import com.zinopay.membership.application.port.out.RegisterMembershipPort;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {
    private final MembershipRepository membershipRepository;

    @Override
    public MembershipEntity registerMembership(String name, String email, String address, boolean isValid, boolean isCorp) {
        return membershipRepository.save(
                new MembershipEntity(
                        name,
                        email,
                        address,
                        isValid,
                        isCorp
                )
        );
    }

    @Override
    public MembershipEntity findMembership(String membershipId) {
        return membershipRepository.findById(Long.parseLong(membershipId)).orElseThrow(() -> new RuntimeException());
    }
}
