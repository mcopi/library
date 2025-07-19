package com.cop.library_rent.services;

import com.cop.library_rent.dtos.RentRequestDto;
import com.cop.library_rent.dtos.RentResponseDto;

import java.util.List;

public interface RentService {
    List<RentResponseDto> getRentHistoryWithFilter(RentRequestDto request);
}
