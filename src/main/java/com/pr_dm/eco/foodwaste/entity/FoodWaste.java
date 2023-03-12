package com.pr_dm.eco.foodwaste.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class FoodWaste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wasteId;
    private String location;
    private Long amount;
    private Date date;
}
