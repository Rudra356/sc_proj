package com.rudra356.cms.cms.Controller;

import com.rudra356.cms.cms.Entity.PUCcenters;
import com.rudra356.cms.cms.Service.PUCcenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Centers")
public class PUCcenterController {

    @Autowired
    private PUCcenterService ps;

    @Transactional
    @PostMapping
    public ResponseEntity<String> createCenter(@Valid @RequestBody PUCcenters pc) {
        LocalDateTime nowInKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        pc.setRegistrationDate(nowInKolkata);
        pc.setExpiryDate(nowInKolkata.plusDays(31));
        ps.createCenter(pc);
        return ResponseEntity.ok("PUC Center created successfully");
    }

    @Transactional
    @GetMapping
    public ResponseEntity<?> getAllCenters() {
        List<PUCcenters> listedCenters = ps.getAllCenters();
        if (!listedCenters.isEmpty()) {
            return new ResponseEntity<>(listedCenters, HttpStatus.FOUND);
        }
        return new ResponseEntity<>("No center is listed right now.", HttpStatus.OK);
    }

    @Transactional
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getCenterById(@PathVariable String id) {
        PUCcenters listedCenters = ps.getCenterById(id);
        if (listedCenters != null) {
            return new ResponseEntity<>(listedCenters, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> DeleteCenterById(@PathVariable String id) {
        Optional<PUCcenters> dlt = ps.deleteCenterById(id); // ✅ fixed line
        return dlt.isPresent() ? new ResponseEntity<>(dlt.get(),HttpStatus.GONE) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    @GetMapping("/name/{centerName}")
    public ResponseEntity<?> getCenterByCenterName(@PathVariable String centerName) {
        Optional<PUCcenters> listedCenters = ps.getCenterByCenterName(centerName);
        if (listedCenters.isPresent()) {
            return new ResponseEntity<>(listedCenters, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/name/{centerName}")
    public ResponseEntity<?> DeleteCenterByCenterName(@PathVariable String centerName) {
        Optional<PUCcenters> dlt = ps.deleteCenterByCenterName(centerName);
        return dlt.isPresent() ? new ResponseEntity<>(dlt.get(),HttpStatus.GONE) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
