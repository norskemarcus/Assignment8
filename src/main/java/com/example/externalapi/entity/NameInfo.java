package com.example.externalapi.entity;

import com.example.externalapi.dto.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class NameInfo {
  @Id
  private String name;
  private String gender;
  private double genderProbability;
  private int age;
  private int ageCount;
  private String country;
  private double countryProbability;
  private boolean saved; // Boolean variable to indicate if the name is saved in the repository



  public NameInfo(AgeResponse ageResponse,
                  GenderDTO genderDTO, NationalityResponse nationalityResponse){
    this.name = genderDTO.getName();
    this.gender = genderDTO.getGender();
    this.genderProbability = genderDTO.getProbability();
    this.age = ageResponse.getAge();
    this.ageCount = ageResponse.getCount();
    // Creds to Tomas for this solution
    CountryResponse countryResponse = nationalityResponse.getCountry().get(0);
    this.country = countryResponse.getCountry_id();
    this.countryProbability = countryResponse.getProbability();
  }

}
