package org.telmoudy.backend.services;

import org.springframework.web.multipart.MultipartFile;
import org.telmoudy.backend.entities.Payment;
import org.telmoudy.backend.entities.PaymentStatus;
import org.telmoudy.backend.entities.PaymentType;
import org.telmoudy.backend.entities.Student;
import org.telmoudy.backend.repositories.PaymentRepository;
import org.telmoudy.backend.repositories.StudentRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface IPaymentService {
    public Payment savePayment(MultipartFile file, double amount, PaymentType type,
                               LocalDate date, String studentCode) throws IOException;
    public byte[] getPaymentFile(Long id) throws IOException;
    public Payment updatePaymentStatus(PaymentStatus status, Long paymentId);

}