package com.webservice.rentalSpace.domain.user;

import com.webservice.rentalSpace.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Column(nullable = false)
    private boolean emailVerified;

    @Column
    private String verificationCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, boolean emailVerified, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.emailVerified = emailVerified;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public void updateToSeller() {
        this.role = Role.SELLER;
    }

    public void updateToUser() {
        this.role = Role.USER;
    }

    public void updateEmailVerified() {
        this.emailVerified = true;
    }

    public void updateVerificationCode(String code) {
        this.verificationCode = code;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}