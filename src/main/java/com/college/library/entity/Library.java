package com.college.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Library {
    @Id
    private int bookNo;
    private String bookName;
    private String author;
    private int shelfId;
}
