package com.example.externalapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class GenderDTO {

  private int count;
  private String gender;
  private String name;
  private double probability;
}
