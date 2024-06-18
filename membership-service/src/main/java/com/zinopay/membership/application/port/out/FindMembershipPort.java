package com.zinopay.membership.application.port.out;

import com.zinopay.membership.adapter.out.persistence.MembershipEntity;

public interface FindMembershipPort {

    MembershipEntity findMembership(String membershipId);


}
