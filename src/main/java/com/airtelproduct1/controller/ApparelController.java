package com.airtelproduct1.controller;

import com.airtelproduct1.model.Apparel;
import com.airtelproduct1.service.ApparelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApparelController {
    @Autowired
    private ApparelService apparelService;
    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Apparel apparel)
    {
        return apparelService.addProduct(apparel);
    }

}
