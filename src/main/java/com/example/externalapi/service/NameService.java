package com.example.externalapi.service;

import com.example.externalapi.dto.*;
import com.example.externalapi.entity.NameInfo;
import com.example.externalapi.repository.NameRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Service
public class NameService {

  private NameRepository nameRepository;

  public NameService(NameRepository nameRepository) {
    this.nameRepository = nameRepository;
  }

  Mono<GenderDTO> getGender(String name) {
    WebClient client = WebClient.create();
    Mono<GenderDTO> gender = client.get()
        .uri("https://api.genderize.io?name=" + name)
        .retrieve()
        .bodyToMono(GenderDTO.class)
        .doOnError(e-> System.out.println("Error: " +e.getMessage()));

    return gender;
  }

  Mono<AgeResponse> getAge(String name) {
    WebClient client = WebClient.create();
    Mono<AgeResponse> age = client.get()
        .uri("https://api.agify.io/?name=" + name)
        .retrieve()
        .bodyToMono(AgeResponse.class)
        .doOnError(e-> System.out.println("Error: " +e.getMessage()));
    return age;
  }

  Mono<NationalityResponse> getNationality(String name) {
    WebClient client = WebClient.create();
    Mono<NationalityResponse> nationality = client.get()
        .uri("https://api.nationalize.io/?name=" + name)
        .retrieve()
        .bodyToMono(NationalityResponse.class)
        .doOnError(e-> System.out.println("Error: " +e.getMessage()));
    return nationality;
  }


  // Method to retrieve cached CombinedResponseDTO based on name
  public NameInfoResponseDTO fetchNameDetails(String name) {

    // Fetch the NameInfo entity from the repository based on the name
    Optional<NameInfo> optionalNameInfo = nameRepository.findById(name);

    if (optionalNameInfo.isPresent()) {
      // If NameInfo entity exists, retrieve the CombinedResponseDTO from the entity
      NameInfoResponseDTO nameInfoResponseDTO = new NameInfoResponseDTO(optionalNameInfo.get());
      return nameInfoResponseDTO;

    } else {

      // If NameInfo entity does not exist, fetch details from APIs and combine using Mono.zip
      Mono<AgeResponse> age = getAge(name);
      Mono<GenderDTO> gender = getGender(name);
      Mono<NationalityResponse> nationality = getNationality(name);

      Mono<NameInfo> mono = Mono.zip(age, gender, nationality)
          .map(tuple -> new NameInfo(tuple.getT1(), tuple.getT2(), tuple.getT3()));

      NameInfo nameInfo = mono.block();
      nameRepository.save(nameInfo);

    return new NameInfoResponseDTO(nameInfo);
    }
  }
}
