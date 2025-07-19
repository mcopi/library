package com.cop.library_membership.entities;

import com.cop.library_shared.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lib_role")
@Getter
@Setter
public class Role extends BaseEntity {
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_code")
    private String roleCode;
}
