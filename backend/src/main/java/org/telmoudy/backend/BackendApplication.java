package org.telmoudy.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telmoudy.backend.entities.Payment;
import org.telmoudy.backend.entities.PaymentStatus;
import org.telmoudy.backend.entities.PaymentType;
import org.telmoudy.backend.entities.Student;
import org.telmoudy.backend.repositories.PaymentRepository;
import org.telmoudy.backend.repositories.StudentRepository;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository){
        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .code("112233").firstName("Mohamed").lastName("Mohamed").programId("GLSID").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .code("112244").firstName("Imane").lastName("Imane").programId("GLSID").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .code("112255").firstName("Aymane").lastName("Aymane").programId("BDCC").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .code("112266").firstName("Lobna").lastName("Lobna").programId("BDCC").build());

            PaymentType[] paymentTypes = PaymentType.values();
            Random random=new Random();
            studentRepository.findAll().forEach(st->{
                for (int i = 0; i <10 ; i++) {
                    int index = random.nextInt(paymentTypes.length);
                    Payment payment = Payment.builder()
                            .date(LocalDate.now())
                            .amount(1000+(int)(Math.random()*20000))
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREATED)
                            .student(st)
                            .build();
                    paymentRepository.save(payment);
                }
            });
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .code("1125233").firstName("Mohamed").lastName("Mohamed").programId("GLSID").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .code("11244244").firstName("Imane").lastName("Imane").programId("GLSID").build());

        };
    }


}
