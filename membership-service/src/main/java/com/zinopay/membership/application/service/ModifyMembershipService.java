package com.zinopay.membership.application.service;

import com.zinopay.common.UseCase;
import com.zinopay.membership.adapter.out.persistence.MembershipEntity;
import com.zinopay.membership.adapter.out.persistence.MembershipMapper;
import com.zinopay.membership.application.port.in.ModifyMembershipCommand;
import com.zinopay.membership.application.port.in.ModifyMembershipUseCase;
import com.zinopay.membership.application.port.out.FindMembershipPort;
import com.zinopay.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@UseCase
@RequiredArgsConstructor
public class ModifyMembershipService implements ModifyMembershipUseCase {
    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;
    // find 후 save

    @Transactional
    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        MembershipEntity membershipEntity = findMembershipPort.findMembership(command.getMembershipId());
        membershipEntity.setName(command.getName());
        membershipEntity.setAddress(command.getAddress());
        membershipEntity.setEmail(command.getEmail());
        membershipEntity.setCorp(command.isCorp());

        return membershipMapper.toDomain(membershipEntity);
    }
}
