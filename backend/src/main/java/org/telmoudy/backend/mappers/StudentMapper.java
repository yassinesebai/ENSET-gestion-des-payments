package org.telmoudy.backend.mappers;

import org.telmoudy.backend.dto.StudentDTO;
import org.telmoudy.backend.entities.Student;

public class StudentMapper {

    public Student dtoToEntite(StudentDTO dto){


        return Student.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .photo(dto.getPhoto())
                .programId(dto.getProgramId())
                .code(dto.getCode())
                .build();
    }
}
