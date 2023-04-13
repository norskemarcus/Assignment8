
package com.example.externalapi.api;

import com.example.externalapi.dto.GenderDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*
@Controller
public class RemoteApiTester implements CommandLineRunner {

  private Mono<String> callSlowEndpoint(){
    Mono<String> slowResponse = WebClient.create()
        .get()
        .uri("http://localhost:8080/random-string-slow")
        .retrieve()
        .bodyToMono(String.class)
        .doOnError(e-> System.out.println("UUUPS : "+e.getMessage()));
    return slowResponse;
  }

  public void callSlowEndpointBlocking(){
    long start = System.currentTimeMillis();
    List<String> ramdomStrings = new ArrayList<>();

    Mono<String> slowResponse = callSlowEndpoint();
    ramdomStrings.add(slowResponse.block()); //Three seconds spent

    slowResponse = callSlowEndpoint();
    ramdomStrings.add(slowResponse.block());//Three seconds spent

    slowResponse = callSlowEndpoint();
    ramdomStrings.add(slowResponse.block());//Three seconds spent
    long end = System.currentTimeMillis();
    ramdomStrings. add(0,"Time spent BLOCKING (ms): "+(end-start));

    System.out.println(ramdomStrings.stream().collect(Collectors.joining(",")));
    // Time spent BLOCKING (ms): 9033,25yQ40obDW,46QJRVcL67,YdCUlMhz0P
  }

  public void callSlowEndpointNonBlocking(){
    long start = System.currentTimeMillis();
    Mono<String> sr1 = callSlowEndpoint();
    Mono<String> sr2 = callSlowEndpoint();
    Mono<String> sr3 = callSlowEndpoint();
// The zip method used, merges the given monos into a new Mono that will be
// fulfilled when all of the given Monos have produced an item.
    var rs = Mono.zip(sr1,sr2,sr3).map(t-> {
      //  JavaScript is NON-blocking, so the line rs.block() is NOT similar to a JavaScript solution where you have used await in an async method
      // BUT very similar to JavaScript promises, which have an all(..) method that takes a list of Promises
      List<String> randomStrings = new ArrayList<>();
      randomStrings.add(t.getT1());
      randomStrings.add(t.getT2());
      randomStrings.add(t.getT3());
      long end = System.currentTimeMillis();
      randomStrings.add(0,"Time spent NON-BLOCKING (ms): "+(end-start));
      return randomStrings;
    });
    List<String> randoms = rs.block(); //We only block when all the three Mono's has fulfilled
    System.out.println(randoms.stream().collect(Collectors.joining(",")));
  }


  Mono<GenderDTO> getGenderForName(String name) {
    WebClient client = WebClient.create();
    Mono<GenderDTO> gender = client.get()
        .uri("https://api.genderize.io?name="+name)
        .retrieve()
        .bodyToMono(GenderDTO.class);
    return gender;
  }


  List<String> names = Arrays.asList("lars", "peter", "sanne", "kim", "david", "maja");

  public void getGendersBlocking() {
    long start = System.currentTimeMillis();
    List<GenderDTO> genderDTOS = names.stream().map(name -> getGenderForName(name).block()).toList();
    long end = System.currentTimeMillis();
    System.out.println("Time for six external requests, BLOCKING: "+ (end-start));
    // Time for six external requests, BLOCKING: 1632
  }

  public void getGendersNonBlocking() {
    long start = System.currentTimeMillis();
    var genders = names.stream().map(name -> getGenderForName(name)).toList();
    Flux<GenderDTO> flux = Flux.merge(Flux.concat(genders));

    // res bliver ikke brugt
    List<GenderDTO> res = flux.collectList().block();
    long end = System.currentTimeMillis();
    // Time for six external requests, NON-BLOCKING: 3449
    System.out.println("Time for six external requests, NON-BLOCKING: "+ (end-start));
    // Time for six external requests, NON-BLOCKING: 892
  }




  @Override
  public void run(String... args) throws Exception {
    //System.out.println(callSlowEndpoint().toString()); // MonoPeekTerminal
    */
/*
* In reactive programming, Mono is a type of publisher that represents a stream
* of zero or one element, and it is not resolved until you subscribe to it.
* Calling toString() on a Mono object will only print information about the
* Mono object itself, including its internal state, but not the actual value
* it may contain.
* *//*

   // String randomStr = callSlowEndpoint().block();
   // System.out.println(randomStr); // z2ZaZANiqB

   // callSlowEndpointBlocking(); // ca. 9 sek
    // Time spent BLOCKING (ms): 9056,AmVQ7NhjqF,vncKRt5VPt,PIjKt4To7G

   // callSlowEndpointNonBlocking(); // ca. 3 sek
    // Time spent NON-BLOCKING (ms): 3026,iOY2SzJLe6,9ea0Flja7n,Pe6gfCyz65

    GenderDTO gender = getGenderForName("Marion").block();
    System.out.println(gender.getGender());

    getGendersBlocking();
    getGendersNonBlocking();

    }
}

*/
