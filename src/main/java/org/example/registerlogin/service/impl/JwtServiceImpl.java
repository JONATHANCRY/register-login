package org.example.registerlogin.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.example.registerlogin.entity.UserEntity;
import org.example.registerlogin.service.JwtService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;


@Service
public class JwtServiceImpl implements JwtService {
    // SECRET_KEY: khóa bí mật để ký JWT (phải dài >= 32 bytes cho HS256)
    private static final String SECRET_KEY = "AAAAAAAAAA_BBBBBBBBBB_CCCCCCCCCC_DDDDDDDDDD";

    // Tạo key HMAC từ chuỗi SECRET_KEY
    // SECRET_KEY.getBytes() => convert String thành mảng byte
    // Keys.hmacShaKeyFor() => convert byte[] thành Key hợp lệ cho HS256
    private SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());



    @Override
    // tạo token từ email
    public String generateToken(UserEntity user) {

        // Bắt đầu xây dựng JWT
        return Jwts.builder()

                // setSubject: nội dung chính của JWT (chứa email/username)
                // FE/BE sẽ đọc subject để biết user nào đang login
                .setSubject(user.getEmail())

                // setIssuedAt: thời điểm token được tạo
                .setIssuedAt(new Date())

                // setExpiration: thời điểm token hết hạn (ở đây: 24 giờ)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))

                // signWith: ký token bằng key và thuật toán HS256
                .signWith(key, SignatureAlgorithm.HS256)

                // compact(): convert tất cả thành chuỗi JWT cuối cùng
                // gồm header.payload.signature
                .compact();
    }

    @Override
    // chiết xuất email từ token
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }


    @Override
    // kiểm tra token có valid chưa
    public boolean isTokenValid(String token, UserDetails userDetails) {
        String email = extractEmail(token);
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // kiểm tra token còn hạn sử dụng không
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    };

    // giải mã token
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) key)   // dùng verifyWith thay cho setSigningKey
                .build()
                // token hết hạn
                .parseSignedClaims(token)
                .getPayload();                 // thay .getBody() bằng .getPayload()
    }

}
