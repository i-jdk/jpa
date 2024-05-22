package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "Member")
@Getter
@Setter
@Table(name = "Member"
//        , uniqueConstraints = {
//        @UniqueConstraint(
//                name = "NAME_AGE_UNIQUE",
//                columnNames = {"NAME, AGE"}
//        )
//}
)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column(nullable = false, length = 10, unique = true)
    private String userName;

    @Column(unique = true)
    private int age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    private String fullName;

    @Transient
    private String firstName;

    @Transient
    private String lastName;

    @Access(AccessType.PROPERTY)
    public String getFullName(){
        return firstName + lastName;
    }
}
