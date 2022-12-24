package ru.spb.ifuture.bank.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "CNT_ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @Column(name = "ACCOUNT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ACCOUNT_ID_SEQ_GEN")
    @SequenceGenerator(name = "ACCOUNT_ID_SEQ_GEN",
            sequenceName = "ACCOUNT_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "BALANCE", nullable = false)
    private Long balance;
}
