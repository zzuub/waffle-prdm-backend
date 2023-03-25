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

    @Column(name = "city_do_nm")
    private String cityDo;

    @Column(name = "city_gn_gu_nm")
    private String cityGu;

    //@Column(name = "dscamt")
    private Long amount;

    private Date date;
}
