package com.ata2.art22;

import com.ata2.art22.entity.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Void> getAll() {
        userService.getAll();
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateJPQL(@PathVariable Long id) {
        userService.updateUsingJPQL(id);
        return ResponseEntity.ok().body(null);
    }

    @PostMapping("/repo")
    public ResponseEntity<UserDTO> saveRepo(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.saveRepo(userDTO));
    }

    @PostMapping("/em-persist")
    public ResponseEntity<UserDTO> saveEmPersist(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.saveEmPersist(userDTO));
    }

    @PostMapping("/em-native")
    public ResponseEntity<UserDTO> saveEmNative(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.saveEmNative(userDTO));
    }
}
