package com.zinopay.membership.adapter.out.persistence;

import com.zinopay.membership.domain.Membership;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MembershipMapper {


    Membership toDomain(MembershipEntity entity);


}
