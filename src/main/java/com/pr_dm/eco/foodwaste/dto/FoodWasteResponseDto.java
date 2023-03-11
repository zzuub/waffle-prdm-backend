package com.pr_dm.eco.foodwaste.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class FoodWasteResponseDto {
    private Long wasteId;
    private String location;
    private Long amount;
    private Date date;
}