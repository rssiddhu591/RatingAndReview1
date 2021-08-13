package com.airtelproduct1.service;

import com.airtelproduct1.model.Apparel;
import com.airtelproduct1.repository.ApparelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApparelService {
    @Autowired
    private ApparelRepository apparelRepository;

    public String addProduct(Apparel apparel) {
        apparel.setCount(0);
        apparel.setRating(0);
        apparelRepository.save(apparel);
        return "Product Added Successfully";
    }
}
