package com.ata2.art22.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "jhi_user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jhiUserSequenceGenerator")
    @SequenceGenerator(name = "jhiUserSequenceGenerator", sequenceName = "jhi_user_sequence", initialValue = 1, allocationSize = 1)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
