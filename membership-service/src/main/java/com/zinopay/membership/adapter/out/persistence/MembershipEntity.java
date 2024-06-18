package com.zinopay.membership.adapter.out.persistence;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "membership")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MembershipEntity {
    @Id
    @GeneratedValue
    private Long membershipId;

    private String name;
    private String address;
    private String email;
    private boolean isCorp;
    private boolean isValid;


    public MembershipEntity(String name, String address, String email, boolean isCorp, boolean isValid) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isCorp = isCorp;
        this.isValid = isValid;
    }
}
