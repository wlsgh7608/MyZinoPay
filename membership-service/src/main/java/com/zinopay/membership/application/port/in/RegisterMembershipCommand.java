package com.zinopay.membership.application.port.in;


import common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {
    @NotNull
    private final String name;
    @NotNull
    private final String email;
    @NotNull
    private final String address;
    @AssertTrue
    private final boolean isValid;
    @NotNull
    private final boolean isCorp;


}
