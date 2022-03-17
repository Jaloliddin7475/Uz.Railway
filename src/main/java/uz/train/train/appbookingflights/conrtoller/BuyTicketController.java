package uz.train.train.appbookingflights.conrtoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.train.train.appbookingflights.Dto.createDto.BuyTicketCreateDto;
import uz.train.train.appbookingflights.service.BuyTicketService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class BuyTicketController {
    private final BuyTicketService buyTicketService;

    @GetMapping
    public ResponseEntity<?> getTickets () {
        return ResponseEntity.ok(buyTicketService.getTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicket(@PathVariable Integer id) {
        return ResponseEntity.ok(buyTicketService.getTicket(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTicket (@RequestBody BuyTicketCreateDto buyTicketCreateDto) {
        buyTicketService.addTicket(buyTicketCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editTicket (@PathVariable Integer id, @RequestBody BuyTicketCreateDto buyTicketCreateDto) {
        return ResponseEntity.ok(buyTicketService.editTicket(id,buyTicketCreateDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket (@PathVariable Integer id) {
        return ResponseEntity.ok(buyTicketService.deleteTicket(id));
    }
}
