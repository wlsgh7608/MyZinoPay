package com.zinopay.membership.adapter.out.persistence;

import com.zinopay.membership.domain.Membership;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface MembershipMapper {


    @Mapping(source = "valid", target = "isValid")
    @Mapping(source = "corp", target = "isCorp")
    Membership toDomain(MembershipEntity entity);


}
