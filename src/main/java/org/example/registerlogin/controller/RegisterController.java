package org.example.registerlogin.controller;

import org.example.registerlogin.dto.RegisterDTO;
import org.example.registerlogin.dto.RequestLoginDTO;
import org.example.registerlogin.entity.UserEntity;
import org.example.registerlogin.service.JwtService;
import org.example.registerlogin.service.LoginService;
import org.example.registerlogin.service.RegisterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/register")
@CrossOrigin(origins = "*")
// cho phép front end gọi từ cỗng 5173
//@CrossOrigin(origins = "http://localhost:5173")
public class RegisterController {
    public final RegisterService registerService;
    public final LoginService loginService;
    private PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    /*                                   ĐĂNG KÝ                              */

// @RequestBody :
//"Lấy dữ liệu JSON trong body của request, chuyển nó thành một đối tượng Java kiểu RegisterEntity."
@PostMapping
public String create(@Valid @RequestBody RegisterDTO dto) {

    // kiểm tra email tồn tại
    if (registerService.emailExists(dto.getEmail())) {
        System.out.println("email đã tồn tại");
        return "email đã tồn tại";
    }

    // map DTO -> Entity
    UserEntity user = new UserEntity();
    user.setLastName(dto.getLastName());
    user.setFirstName(dto.getFirstName());
    user.setAge(dto.getAge());
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword()); // dạng RAW → service sẽ encode

    registerService.save(user);

    return "đăng ký thành công, hãy xác thực email";
}


    @GetMapping("/verify")
    // @RequestParam ấy giá trị của tham số "token" trong URL
    public String verify(@RequestParam String token){
        boolean verified = registerService.verifyAccount(token);
        return verified
                ? "✅ Xác nhận tài khoản thành công!"
                : "❌ Token không hợp lệ hoặc đã hết hạn.";
    }


// kiểm tra kết nối từ fe đến service
    @GetMapping("/ping")
    public String ping() {
        return "Service OK";
    }
// passwork phải có chữ hoa đầu câu, tối thiều 8 ký tự, phải có ký tự đặc biệt, số, chữ
// xác thực email
// khi người dùng đăng ký,
// email xác nhận sẽ được gởi đến mail đăng ký dùng app password: huxg rexa prnz zgmf
// người dùng bấm xác nhận email thì db lưu tạm sẽ được lưu vào db gốc



    /*                                     ĐĂNG NHẬP                              */

// đăng nhập = email, mk , đã verified =1
//  user nhập email, mk
//  gọi xún db xem có email đó không,
//    nếu không có thì hiện thông báo 0 đúng
//    nếu có thì hiện thông báo đăng nhập thành công
//    @GetMapping("/login")
//    public RegisterEntity findEmail(@RequestParam String email,String password){
//        return iLoginService.findEmailAndPassword(email,password);
//    }
    // @RequestBody chỉ nhận 1 tham số duy nhất
    // dùng post để truyền tham số email , password, trả ra thông tin user
    @PostMapping("/login")
    public ResponseEntity<?> findEmail(@RequestBody RequestLoginDTO requestLoginDTO){
        // tìm user có email
        UserEntity user = loginService.findEmail(requestLoginDTO.getEmail());
        // nếu email, mk tồn tại thì xem verified là true hay false,
        if (user != null){
            // lấy password trong db
            String hashedPassword = user.getPassword();
            // kiểm tra password trong db và password user nhập có giống nhau
            boolean isMatch = passwordEncoder.matches(requestLoginDTO.getPassword(),hashedPassword);
            // true thì in ra thông báo đăng nhập thành công
            if (isMatch){
                if (user.isVerified()){
                    // tạo jwt
                    String jwt =jwtService.generateToken(user);
                    // trả ra jwt
                    return ResponseEntity.ok(jwt);
                } else {
                    // false thì in ra thông báo
                    return ResponseEntity.badRequest().body("chưa xt email");
                }
            }
        } return ResponseEntity.badRequest().body("chưa đăng ký 1");

        // nếu email, pw không tồn tại thì thông báo chưa đăng ký

        // nếu email đúng, nhưng pw không đúng, verified false thì
    }

}
