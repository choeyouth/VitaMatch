package com.test.nutri.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nutri.api.MapAPI;
import com.test.nutri.model.MapDTO;
import com.test.nutri.service.MapService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MapController {

    private final MapAPI mapAPI;
    private final MapService mapService;

    @GetMapping("/map")
    public String map(Model model) {
        return mapAPI.getMap(model); 
    }

    @GetMapping("/pharmacy/search")
    @ResponseBody
    public List<MapDTO> getPharmacy(
        @RequestParam(name = "sido") String sido,
        @RequestParam(name = "gugun") String gugun,
        @RequestParam(name = "page", defaultValue = "1") int page,
        @RequestParam(name = "keyword", required = false) String keyword
    ) {
        String url = mapAPI.createPharmacyUrl(sido, gugun, page, keyword);
        return mapService.getPharmacyList(url);
    }
    

}
