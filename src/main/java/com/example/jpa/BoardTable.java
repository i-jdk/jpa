package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table
@TableGenerator(
        name = "BOARD_SEQ_GENERATOR2",
        table = "MY_SEQUENCE",
        pkColumnName = "TABLE_NAME",
        valueColumnName = "TABLE_NEXT_VAL",
        pkColumnValue = "BOARD_SEQUENCE",
        initialValue = 1,
        allocationSize = 1
)
public class BoardTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR2")
    private Long id;
}
