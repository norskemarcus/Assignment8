package com.example.externalapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NationalityResponse {
  public List<CountryResponse> country;
  public String name;
}
