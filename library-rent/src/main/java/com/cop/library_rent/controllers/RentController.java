package com.cop.library_rent.controllers;

import com.cop.library_rent.dtos.RentRequestDto;
import com.cop.library_rent.dtos.RentResponseDto;
import com.cop.library_rent.services.RentService;
import com.cop.library_shared.dtos.SuccessResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rent")
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("getAllBooks")
    public ResponseEntity<SuccessResponseDto<List<RentResponseDto>>> getAllBooksWithFilter(@RequestBody RentRequestDto request) {
        return ResponseEntity
                .ok()
                .body(new SuccessResponseDto<>(rentService.getRentHistoryWithFilter(request), "Succeed"));
    }
}
