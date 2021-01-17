package com.rr.bookservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    @NotNull
    private UUID id;

    @NotBlank
    private String bookName;

    @NotBlank
    private String genre;

    @Positive
    private Long isbn;
}
