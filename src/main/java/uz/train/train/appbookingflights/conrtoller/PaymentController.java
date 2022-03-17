package uz.train.train.appbookingflights.conrtoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.train.train.appbookingflights.Dto.createDto.PaymentCreateDto;
import uz.train.train.appbookingflights.service.PaymentService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<?> getPayments () {
        return ResponseEntity.ok(paymentService.getPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPayment (@PathVariable Integer id) {
        return ResponseEntity.ok(paymentService.getPayment(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPayment (@RequestBody PaymentCreateDto paymentCreateDto) {
        paymentService.addPayment(paymentCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editPayment (@PathVariable Integer id, @RequestBody PaymentCreateDto paymentCreateDto) {
        return ResponseEntity.ok(paymentService.editPayment(id,paymentCreateDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePayment (@PathVariable Integer id) {
        return ResponseEntity.ok(paymentService.deletePayment(id));
    }
    
}
