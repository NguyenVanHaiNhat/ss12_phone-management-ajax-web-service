package org.example.phonemanagementajaxwebservice.controller;

import org.example.phonemanagementajaxwebservice.model.Phone;
import org.example.phonemanagementajaxwebservice.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/phones")
public class PhoneRestController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public ResponseEntity<Iterable<Phone>> list(){
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Phone> create(@RequestBody Phone phone){
        return new ResponseEntity<>(phoneService.save(phone), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> update(@PathVariable Long id, @RequestBody Phone phone){
        Optional<Phone> phoneOptional = phoneService.findById(id);
        if (!phoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phone.setId(id);
        return new ResponseEntity<>(phoneService.save(phone), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> delete(@PathVariable Long id){
        Optional<Phone> phoneOptional = phoneService.findById(id);
        if (!phoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phoneService.remove(id);
        return new ResponseEntity<>(phoneOptional.get(), HttpStatus.OK);
    }
}
