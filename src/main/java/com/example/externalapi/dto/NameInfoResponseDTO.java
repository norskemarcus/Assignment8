package com.example.externalapi.dto;

import com.example.externalapi.entity.NameInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NameInfoResponseDTO {

  private String name;
  private String gender;
  private double genderProbability;
  private int age;
  private int ageCount;
  private String country;
  private double countryProbability;



  // gender, age, nationality
  public NameInfoResponseDTO(AgeResponse ageResponse, GenderDTO genderDTO, NationalityResponse nationalityResponse ){
     this.name = genderDTO.getName();
     this.gender = genderDTO.getGender();
     this.genderProbability = genderDTO.getProbability();
     this.age = ageResponse.getAge();
     this.ageCount = ageResponse.getCount();

    // Creds til Tomas for at hente et country på denne måde
     CountryResponse countryResponse = nationalityResponse.getCountry().get(0);
     this.country = countryResponse.getCountry_id();
     this.countryProbability = countryResponse.getProbability();
    }


  public NameInfoResponseDTO(NameInfo nameInfo){
    this.name = nameInfo.getName();
    this.gender = nameInfo.getGender();
    this.genderProbability = nameInfo.getGenderProbability();
    this.age = nameInfo.getAge();
    this.ageCount = nameInfo.getAgeCount();
    this.country = nameInfo.getCountry();
    this.countryProbability = nameInfo.getCountryProbability();
  }

/*
  public CombinedResponseDTO(String name, String gender, double genderProbability, int age,
                             int ageCount, String country, double countryProbability) {
    this.name = name;
    this.gender = gender;
    this.genderProbability = genderProbability;
    this.age = age;
    this.ageCount = ageCount;

    // Creds til Tomas for at hente et country på denne måde
   // CountryResponse countryResponse = nationalityResponse.getCountry().get(0);
    this.country = country;
    this.countryProbability = countryProbability;
  }*/
}



