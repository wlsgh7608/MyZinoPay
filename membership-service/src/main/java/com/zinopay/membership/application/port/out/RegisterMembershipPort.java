package com.zinopay.membership.application.port.out;

import com.zinopay.membership.adapter.out.persistence.MembershipEntity;

public interface RegisterMembershipPort {
    MembershipEntity registerMembership(
            String name,
            String email,
            String address,
            boolean isValid,
            boolean isCorp);
}
