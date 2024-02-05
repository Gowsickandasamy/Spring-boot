package com.spring.wecare.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.wecare.entities.EmailOtp;

@Repository
public interface EmailOtpRepository extends JpaRepository<EmailOtp, Long> {

	EmailOtp findByEmailAndOtpAndExpirationDateAfter(String email, String otp, Date expirationDate);
}