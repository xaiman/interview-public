package com.devexperts.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transfer")
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_id")
    private Long source_id;

    @Column(name = "target_id")
    private Long target_id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "transfer_time",
            nullable = false,
            updatable = false,
            insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime transfer_time;

    public Transfer (Long source_id, Long target_id, double amount) {
        this.source_id = source_id;
        this.target_id = target_id;
        this.amount = amount;
    }
}
