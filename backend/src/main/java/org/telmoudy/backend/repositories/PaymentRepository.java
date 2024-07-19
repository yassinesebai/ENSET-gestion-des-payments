package org.telmoudy.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telmoudy.backend.entities.Payment;
import org.telmoudy.backend.entities.PaymentStatus;
import org.telmoudy.backend.entities.PaymentType;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}