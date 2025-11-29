package com.college.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import lombok.Data;


@Entity
@Data

//@getter
//@setter    ->@Data do all these 3 things
public class Library {
    @Id
    private int bookNo;
    @NotBlank
    @NotNull
    private String bookName;
    private String author;
    @Column(unique = true)
    private int shelfId;

}
//@Email also there
//@Size(min = 1,max = 10) =@Min(1)+@Max(19)

//for phone no
//@Pattern(regexp = "^[0-9]{10}$")  it should be 0-9(mentioned in []) and 10 digit(mentioned in {})