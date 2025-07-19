package com.cop.library_membership.controllers;

import com.cop.library_membership.dtos.MembershipResponseDto;
import com.cop.library_membership.dtos.RegisterMemberDto;
import com.cop.library_membership.services.MembershipService;
import com.cop.library_membership.dtos.AuthRequestDto;
import com.cop.library_shared.dtos.SuccessResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/member")
public class MembershipController {
    private MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessResponseDto<MembershipResponseDto>> getMembershipAuth(@RequestBody AuthRequestDto request) throws Exception {
        return ResponseEntity
                .ok()
                .body(new SuccessResponseDto<>(membershipService.authentication(request), "Authentication succeed"));
    }

    @PostMapping("/register")
    public ResponseEntity<SuccessResponseDto<MembershipResponseDto>> postRegisterMember(@RequestBody RegisterMemberDto request) {
        return ResponseEntity
                .ok()
                .body(new SuccessResponseDto<>(membershipService.addNewMember(request), "Register succeed"));
    }
}
