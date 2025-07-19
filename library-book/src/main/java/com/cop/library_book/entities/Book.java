package com.cop.library_book.entities;

import com.cop.library_shared.entities.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "lib_book")
public class Book extends BaseEntity {
    @Column(name = "book_name")
    private String bookName;
    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;
    private Integer totalStock;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }
}
