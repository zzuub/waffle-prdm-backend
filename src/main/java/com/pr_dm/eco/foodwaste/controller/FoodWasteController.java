package com.pr_dm.eco.foodwaste.controller;

import com.pr_dm.eco.foodwaste.dto.FoodWasteLocationResponseDto;
import com.pr_dm.eco.foodwaste.dto.FoodWasteResponseDto;
import com.pr_dm.eco.foodwaste.service.FoodWasteService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = "음식물 쓰레기")
public class FoodWasteController {

    private final FoodWasteService foodWasteService;

    // /api/v1/foodwaste?start=2021-01-01&end=2021-01-31
    @GetMapping("/api/v1/foodwaste")
    @ResponseBody
    public List<FoodWasteResponseDto> getFoodWaste(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end,
            @RequestParam String cityDo
            //@RequestParam String cityGu
    ) {
        return foodWasteService.getFoodWaste(start, end, cityDo);
    }

    @GetMapping("/api/v1/foodwaste/city")
    @ResponseBody
    public List<String> getCity() {
        return foodWasteService.getCity();
    }

    @GetMapping("/api/v1/foodwaste/city/{cityGu}")
    @ResponseBody
    public List<String> getDo(@PathVariable String cityGu) {
        return foodWasteService.getGu(cityGu);
    }
}
