package org.telmoudy.backend.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDTO {
    private String code;
    private String firstName;
    private String lastName;
    private String programId;
    private String photo;

}