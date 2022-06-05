package com.promineotech.jeep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Comparator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jeep implements Comparable<Jeep> {
    private Long modelPK;
    private JeepModel modelId;
    private String trimLevel;
    private int numDoors;
    private int wheelSize;
    private BigDecimal basePrice;

    @JsonIgnore
    public Long getModelPK() {
        return modelPK;
    }


// this is for if i changed the order in the test it wont result in an error
    @Override
    public int compareTo(Jeep that) {
        return Comparator.comparing(Jeep::getModelPK)
                .thenComparing(Jeep::getTrimLevel)
                .thenComparing(Jeep::getNumDoors).compare(this,that);
    }
}