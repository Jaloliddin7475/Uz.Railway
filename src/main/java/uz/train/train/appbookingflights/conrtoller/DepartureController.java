package uz.train.train.appbookingflights.conrtoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.train.train.appbookingflights.Dto.createDto.DepartureCreateDto;
import uz.train.train.appbookingflights.service.DepartureService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departures")
public class DepartureController {
    private final DepartureService departureService;

    @GetMapping
    public ResponseEntity<?> getDepartures () {
        return ResponseEntity.ok(departureService.getDepartures());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getDeparture (@PathVariable Integer id) {
        return ResponseEntity.ok(departureService.getDepartures(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDeparture (@RequestBody DepartureCreateDto departureCreateDto) {
        departureService.addDepartures(departureCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editDeparture (@PathVariable Integer id, @RequestBody DepartureCreateDto departureCreateDto) {
        return ResponseEntity.ok(departureService.editDeparture(id,departureCreateDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteDeparture (@PathVariable Integer id) {
        return ResponseEntity.ok(departureService.deleteDeparture(id));
    }
}
