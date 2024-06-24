package com.learning.spring.jpa.relationships.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
/*@Table(
        name = "tableName" // we can specify the name we want the table to be
) */
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String firstName;
    private String lastName;
    @Column(
            name = "email_address", // name of field in db
            length = 50,    // varchar(50)
            unique = true,  // should be unique
            nullable = false    // can not be null
    )
    private String email;
    @Column(
            length = 10,
            unique = true,
            nullable = false
    )
    private Integer contactNumber;
}
