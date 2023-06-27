package demo.alliance.ne.binarysupermarket.controllers;

import demo.alliance.ne.binarysupermarket.dtos.SignUpDTO;
import demo.alliance.ne.binarysupermarket.enums.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import demo.alliance.ne.binarysupermarket.services.IUserService;
import demo.alliance.ne.binarysupermarket.models.User;
import demo.alliance.ne.binarysupermarket.payload.ApiResponse;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/users")
@CrossOrigin
public class UserController {

    private final IUserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserController(IUserService userService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping(path = "/current-user")
    public ResponseEntity<ApiResponse> currentlyLoggedInUser() {
        return ResponseEntity.ok(new ApiResponse(true, userService.getLoggedInUser()));
    }

    @PostMapping(path = "/register/admin")
    public ResponseEntity<ApiResponse> registerAsAdmin(@Valid @RequestBody SignUpDTO dto) {

        User user = new User();

        String pw = bCryptPasswordEncoder.encode(dto.getPassword());

        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setRole(ERole.ADMIN);
        user.setPassword(pw);

        User entity = this.userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, entity));
    }

    @PostMapping(path = "/register/customer")
    public ResponseEntity<ApiResponse> registerAsCustomer(@Valid @RequestBody SignUpDTO dto) {

        User user = new User();

        String encoded = bCryptPasswordEncoder.encode(dto.getPassword());

        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setRole(ERole.CUSTOMER);
        user.setPassword(encoded);

        User entity = this.userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, entity));
    }

}