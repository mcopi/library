package com.cop.library_membership.services.impl;

import com.cop.library_membership.dtos.AuthRequestDto;
import com.cop.library_membership.dtos.MembershipResponseDto;
import com.cop.library_membership.dtos.RegisterMemberDto;
import com.cop.library_membership.entities.User;
import com.cop.library_membership.services.MembershipService;
import com.cop.library_membership.repositories.RoleRepository;
import com.cop.library_membership.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.InvalidNameException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl implements MembershipService {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private static final String ROLE_MEMBER_NAME = "Member";


    @Override
    public MembershipResponseDto authentication(AuthRequestDto request) throws InvalidNameException {
        MembershipResponseDto response = new MembershipResponseDto();

        Optional<User> member = userRepository.findByUsernameAndRoleRoleName(request.getUsername(), ROLE_MEMBER_NAME);

        if (member.isPresent()) setResponse(member.get(), response);
        else throw new InvalidNameException("Username tidak tersedia"); // Tidak menggunakan spring-security

        return response;
    }

    private void setResponse(User user, MembershipResponseDto response) {
        response.setUsername(user.getUsername());
        response.setFullName(user.getFullName());
    }

    @Override
    public MembershipResponseDto addNewMember(RegisterMemberDto request) {
        userRepository.save(setEntity(request));

        return new MembershipResponseDto();
    }

    private User setEntity(RegisterMemberDto request) {
        User user = new User();
        user.setFullName(request.getFullName());
        user.setUsername(request.getUsername());
        user.setRole(roleRepository.findByRoleName(ROLE_MEMBER_NAME).orElse(null));
        user.setPassword(request.getPassword());

        return user;
    }
}
