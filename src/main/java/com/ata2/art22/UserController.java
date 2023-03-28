package com.ata2.art22;

import com.ata2.art22.entity.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) {
//    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
//        UserDTO result = userService.preSave(userDTO);
//         userService.save(userDTO);
         userService.preSave(userDTO);
        return ResponseEntity.ok(null);
    }
}
