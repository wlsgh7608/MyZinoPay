package com.zinopay.membership.application.port.in;

import com.zinopay.membership.domain.Membership;

public interface RegisterMembershipUsecase {


    Membership registerMembership(RegisterMembershipCommand command);
}
