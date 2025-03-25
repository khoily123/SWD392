package com.example.swd392.service;

import com.example.swd392.dto.BrandDTO;
import com.example.swd392.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {
    List<BrandDTO> getAllBrands();

}
