package com.ega.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    @JsonIgnore
    @OneToOne(mappedBy = "account")
    @JoinColumn(name = "user_id")
    private User user;

    private Long accountNumber;
    private Long currentBalance;
}