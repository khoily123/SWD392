package com.example.swd392.service;
import com.example.swd392.dto.BrandDTO;
import com.example.swd392.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImp implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImp(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getAllBrands() {
        return brandRepository.findAll().stream().map(p ->
                        new BrandDTO(p.getBrandId(), p.getBrandName(), p.getDescription()))
                .collect(Collectors.toList());
    }
}
