package uz.universes.mongodb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.universes.mongodb.dto.UsersDto;
import uz.universes.mongodb.entity.Users;
import uz.universes.mongodb.service.UsersService;
import uz.universes.mongodb.service.mail.MailSenderService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    private final MailSenderService mailSenderService;

    @PostMapping
    public ResponseEntity<Users>  create(@RequestBody UsersDto dto){
        return ResponseEntity.status(201).body(usersService.create(dto));
    }
    @PostMapping("/smtp/on-off")
    public ResponseEntity<Boolean>  turnOnOFFSMTPService(){
     return ResponseEntity.ok(mailSenderService.turnOnOffSMTPservice());
    }
    @GetMapping
    public ResponseEntity<ConcurrentHashMap<Object, Map<Object,Object>>>  getCashe(){
     return ResponseEntity.ok(mailSenderService.getCashe());
    }

}
