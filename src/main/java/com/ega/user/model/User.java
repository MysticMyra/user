package com.ega.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "user ")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId;
    private String firstName;
    private String lastName;
    private String loginName;
    private String password;
    private String email;
    private String contactNumber;
    private String address;
    private String state;
    private String country;
    private String pincode;
    private Long accountNumber;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "account_id")
    private Account account;
}
