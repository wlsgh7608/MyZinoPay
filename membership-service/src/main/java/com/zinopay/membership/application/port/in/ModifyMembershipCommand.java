package com.zinopay.membership.application.port.in;

import com.zinopay.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {
    @NotNull
    private final String membershipId;
    @NotNull
    private final String name;
    @NotNull
    private final String address;
    @NotNull
    private final String email;
    @NotNull
    private final boolean isCorp;


    public ModifyMembershipCommand(String membershipId, String name, String address, String email, boolean isCorp) {
        this.membershipId = membershipId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.isCorp = isCorp;
        this.validateSelf();
    }
}
