package com.cop.library_book.entities;

import com.cop.library_shared.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "lib_catalog")
public class Catalog extends BaseEntity {
    @Column(name = "catalog_name")
    private String catalogName;
    @Column(name = "catalog_code")
    private String catalogCode;

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }
}
