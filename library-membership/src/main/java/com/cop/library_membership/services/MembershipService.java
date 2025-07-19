package com.cop.library_membership.services;

import com.cop.library_membership.dtos.MembershipResponseDto;
import com.cop.library_membership.dtos.RegisterMemberDto;
import com.cop.library_membership.dtos.AuthRequestDto;

import javax.naming.InvalidNameException;

public interface MembershipService {
    MembershipResponseDto authentication(AuthRequestDto request) throws InvalidNameException;

    MembershipResponseDto addNewMember(RegisterMemberDto request);
}
