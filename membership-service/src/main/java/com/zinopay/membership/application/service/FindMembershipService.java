package com.zinopay.membership.application.service;

import com.zinopay.membership.adapter.out.persistence.MembershipEntity;
import com.zinopay.membership.adapter.out.persistence.MembershipMapper;
import com.zinopay.membership.application.port.in.FindMembershipCommand;
import com.zinopay.membership.application.port.in.FindMembershipUseCase;
import com.zinopay.membership.application.port.out.FindMembershipPort;
import com.zinopay.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;


@UseCase
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {
    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {

        MembershipEntity membershipEntity = findMembershipPort.findMembership(command.getMembershipId());

        System.out.println("membershipEntity.isCorp() = " + membershipEntity.isCorp());
        System.out.println("membershipEntity.isValid() = " + membershipEntity.isValid());

        // entity -> domain
        //domain
        Membership membership = membershipMapper.toDomain(membershipEntity);
        System.out.println("membership.isCorp() = " + membership.isCorp());
        System.out.println("membership.isValid() = " + membership.isValid());
        return membershipMapper.toDomain(membershipEntity);
    }
}
