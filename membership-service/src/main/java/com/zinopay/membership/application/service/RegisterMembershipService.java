package com.zinopay.membership.application.service;

import com.zinopay.membership.adapter.out.persistence.MembershipEntity;
import com.zinopay.membership.adapter.out.persistence.MembershipMapper;
import com.zinopay.membership.application.port.in.RegisterMembershipCommand;
import com.zinopay.membership.application.port.in.RegisterMembershipUsecase;
import com.zinopay.membership.application.port.out.RegisterMembershipPort;
import com.zinopay.membership.domain.Membership;
import common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterMembershipService implements RegisterMembershipUsecase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        // command => DB 통신

        // 하지만 DB는 외부 서비스
        // port와 adapter을 통해야만 나갈 수 있음
        MembershipEntity membershipEntity = registerMembershipPort.registerMembership(
                command.getName(),
                command.getEmail(),
                command.getAddress(),
                command.isCorp(),
                command.isValid()
        );
        // entity -> domain으로 변환
        return membershipMapper.toDomain(membershipEntity);
    }
}
