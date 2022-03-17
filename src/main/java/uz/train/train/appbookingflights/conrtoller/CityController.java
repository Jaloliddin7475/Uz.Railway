package uz.train.train.appbookingflights.conrtoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.train.train.appbookingflights.Dto.CityDto;
import uz.train.train.appbookingflights.service.CityService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    @GetMapping()
    public ResponseEntity<?> getCities () {
        return ResponseEntity.ok(cityService.getCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCityById (@PathVariable Integer id) {
        return ResponseEntity.ok(cityService.getCity(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addCity (@RequestBody CityDto cityDto) {
        cityService.addCity(cityDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<?> editCity(@PathVariable Integer id, @RequestBody CityDto cityDto) {
        return ResponseEntity.ok(cityService.editCity(id,cityDto));
    }

    @DeleteMapping(value = "/deleteCity/{cityNumber}")
    public ResponseEntity<?> deleteCity(@PathVariable String cityNumber) {
        return ResponseEntity.ok(cityService.deleteCity(cityNumber));
    }


}
