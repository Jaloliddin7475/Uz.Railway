package uz.train.train.appbookingflights.conrtoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.train.train.appbookingflights.Dto.createDto.PassengerCreateDto;
import uz.train.train.appbookingflights.service.PassengerService;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users/{user_id}/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    @GetMapping
    public ResponseEntity<?> getPassengers (@PathVariable UUID user_id) {
        return ResponseEntity.ok(passengerService.getPassengers(user_id));
    }

    @GetMapping("/{passenger_id}")
    public ResponseEntity<?> getPassenger (@PathVariable UUID user_id,@PathVariable UUID passenger_id) {
        return ResponseEntity.ok(passengerService.getPassenger(user_id,passenger_id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPassenger (@PathVariable UUID user_id, @RequestBody PassengerCreateDto passengerCreateDto) {
        passengerService.addPassenger(user_id,passengerCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/edit/{passenger_id}")
    public ResponseEntity<?> editPassenger (@PathVariable UUID user_id,@PathVariable UUID passenger_id,@RequestBody PassengerCreateDto passengerCreateDto) {
        return ResponseEntity.ok(passengerService.editPassenger(user_id,passenger_id,passengerCreateDto));
    }

    @DeleteMapping("/delete/{passenger_id}")
    public ResponseEntity<?> deletePassenger (@PathVariable UUID user_id, @PathVariable UUID passenger_id) {
        passengerService.deletePassenger(user_id,passenger_id);
        return ResponseEntity.ok(passengerService.deletePassenger(user_id,passenger_id));
    }

}
