package com.zinopay.membership.domain;

import lombok.*;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Membership {
    @Getter
    private final String membershipId;
    @Getter
    private final String name;
    @Getter
    private final String email;
    @Getter
    private final String address;
    @Getter
    private final boolean isValid;
    @Getter
    private final boolean isCorp;


    public static Membership generateMember(
            Long membershipId,
            String name,
            String email,
            String address,
            boolean isCorp,
            boolean isValid
            ) {
        return new Membership(
                membershipId+"",
                name,
                email,
                address,
                isCorp,
                isValid
                );
    }




}
