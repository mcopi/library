package com.cop.library_shared.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    @PrePersist
    private void prePersist() {
        this.createdDate = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        this.modifiedDate = new Date();
    }
}
