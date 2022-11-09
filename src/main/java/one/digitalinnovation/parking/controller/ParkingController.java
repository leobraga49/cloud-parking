package one.digitalinnovation.parking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.parking.dto.ParkingCreateDTO;
import one.digitalinnovation.parking.dto.ParkingDTO;
import one.digitalinnovation.parking.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "ParkingController")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll(){
        var parkingList = parkingService.findAll();
        var result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find one parking spot")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
        var parking = parkingService.findById(id);
        var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation("Create a parking spot")
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO parkingDTO){
        var parkingCreate = parkingMapper.toParkingCreate(parkingDTO);
        var parking = parkingService.create(parkingCreate);
        var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
