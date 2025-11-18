//package org.example.registerlogin.service.impl;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class EmailServiceImpl {
//    @Autowired
//    // JavaMailSender thư viện có sẵn trong Spring Boot để gửi email.
//    private final JavaMailSender mailSender;
//    // gởi email xác thực đến địa chỉ to với token: mã xác nhận duy nhất (UUID)
//    public void sendVerificationEmail(String to, String token){
//        // lớp đơn giản để tạo email dạng text.
//        SimpleMailMessage message = new SimpleMailMessage();
//        // địa chỉ người nhận.
//        message.setTo(to);
//        // tiêu đề mail
//        message.setSubject("Xác nhận tài khoản của bạn");
//        // đường dẫn mà người dùng sẽ bấm vào để xác nhận tài khoản.
//        String link= "http://localhost:8081/api/register/verify?token=" + token ;
//        // nội dung mail.
//        message.setText("Nhấn vào link sau để xác nhận tài khoản: " + link);
//        // gửi email đi thông qua Gmail SMTP
//        mailSender.send(message);
//        System.out.println("đã gởi mail đến "+ to);
//    }
//
//}
//
