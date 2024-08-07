package com.compilou.regex.repositories;

import com.compilou.regex.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByOtp(String otp);
    Optional<User> findByEmailAndOtp(String email, String otp);
    User findByResetPasswordToken(String token);
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmailResetPassword(@Param("email") String email);
}