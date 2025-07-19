package com.cop.library_rent.services.impl;

import com.cop.library_rent.dtos.RentRequestDto;
import com.cop.library_rent.dtos.RentResponseDto;
import com.cop.library_rent.entities.Rent;
import com.cop.library_rent.repositories.RentRepository;
import com.cop.library_rent.services.RentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentServiceImpl implements RentService {
    private final RentRepository rentRepository;

    public RentServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public List<RentResponseDto> getRentHistoryWithFilter(RentRequestDto request) {
        Pageable pageable = PageRequest.of(request.getOffset(), request.getLimit(),
                request.getSortBy().equalsIgnoreCase("ASC") ? Sort.by(request.getOrderBy()).ascending() : Sort.by(request.getOrderBy()).descending());

        Page<Rent> rentPage = rentRepository.getRentHistoryByUser(request.getUserId(), pageable);
        if (rentPage.hasContent()) {
            List<RentResponseDto> result = new ArrayList<>();
            rentPage
                    .getContent()
                    .forEach(d -> result.add(setEntityToDto(d)));

            return result;
        } else {
            return new ArrayList<>();
        }
    }

    private RentResponseDto setEntityToDto(Rent data) {
        RentResponseDto dto = new RentResponseDto();
        dto.setBookName(data.getBook().getBookName());
        dto.setCatalogName(data.getBook().getCatalog().getCatalogName());
        dto.setAmount(data.getAmount());

        return dto;
    }


}
