package com.example.Lecture.controller;

import com.example.Lecture.entity.Member;
import com.example.Lecture.entity.MemberAuth;
import com.example.Lecture.entity.PortTest;
import com.example.Lecture.security.AuthUtil;
import com.example.Lecture.service.MemberAuthService;
import com.example.Lecture.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Log
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {
    @Autowired
    private MemberService service;

    @Autowired
    private MemberAuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource;

    @PostMapping("")
    public ResponseEntity<Member> register(@Validated @RequestBody Member member)
            throws Exception {
        log.info("member.getUserName(): " + member.getUserName());

        String inputPassword = member.getUserPw();
        member.setUserPw(passwordEncoder.encode(inputPassword));

        service.register(member);

        log.info("register member.getUserNo(): " + member.getUserNo());

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("")
    public ResponseEntity<List<Member>> list() throws Exception {
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{userNo}")
    public ResponseEntity<Member> read(@PathVariable("userNo") Long userNo) throws Exception {
        Member member = service.read(userNo);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{userNo}")
    public ResponseEntity<Void> remove(@PathVariable("userNo") Long userNo) throws Exception {
        service.remove(userNo);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{userNo}")
    public ResponseEntity<Member> modify(@PathVariable("userNo") Long userNo,
                                         @Validated @RequestBody Member member)
            throws Exception {
        log.info("modify - member.getUserName(): " + member.getUserName());
        log.info("modify - userNo: " + userNo);

        member.setUserNo(userNo);
        service.modify(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @RequestMapping(value = "/setup",
            method = RequestMethod.POST,
            produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> setupAdmin(@Validated @RequestBody Member member)
            throws Exception {
        log.info("setupAdmin: member.getUserName(): " + member.getUserName());
        log.info("setupAdmin: service.countAll(): " + service.countAll());


        String inputPassword = member.getUserPw();
        member.setUserPw(passwordEncoder.encode(inputPassword));

        member.setJob("Admin");

        service.setupAdmin(member);

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);


//        String message = messageSource.getMessage("common.cannotSetupAdmin",
//                null, Locale.KOREAN);
//
//        return new ResponseEntity<String>("Fail", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/myinfo")
    public ResponseEntity<MemberAuth> getMyInfo(
            @RequestHeader (name="Authorization") String header) throws Exception {
        Long userNo = AuthUtil.getUserNo(header);
        log.info("register userNo: " + userNo);

        MemberAuth auth = authService.read(userNo);
        log.info("auth: " + auth);

        return new ResponseEntity<>(auth, HttpStatus.OK);
    }

//    @PostMapping("/idcheck")
//    public ResponseEntity<Member> Idcheck(@Validated @RequestBody Member member)
//            throws Exception {
//        log.info("member.getUserName(): " + member.getUserName());
//
//        service.idcheck(member);
//
//        return new ResponseEntity<>(member, HttpStatus.OK);
//    }
}
