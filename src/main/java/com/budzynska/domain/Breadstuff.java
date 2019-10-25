package com.budzynska.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "breadstuff")
public class Breadstuff {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "type_id")
    private BreadstuffType breadstuffType;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
}
