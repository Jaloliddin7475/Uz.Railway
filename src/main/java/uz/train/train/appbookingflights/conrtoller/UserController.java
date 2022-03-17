package uz.train.train.appbookingflights.conrtoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.train.train.appbookingflights.Dto.UserDto;
import uz.train.train.appbookingflights.service.UserService;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getUser(@PathVariable UUID user_id) {
        return ResponseEntity.ok(userService.getUser(user_id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/edit/{user_id}")
    public ResponseEntity<?> editUser (@PathVariable UUID user_id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.editUser(user_id,userDto));
    }

    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID user_id) {
        return ResponseEntity.ok(userService.deleteUser(user_id));
    }

}

