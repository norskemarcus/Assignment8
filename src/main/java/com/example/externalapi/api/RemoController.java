package com.example.externalapi.api;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class RemoController {

  //  3000 milliseconds or 3 seconds
  //  This value is used as the duration for which the thread will sleep in the slowEndpoint() method.
  private final int SLEEP_TIME = 1000*3;

  @GetMapping(value = "/random-string-slow")
  public String slowEndpoint() throws InterruptedException { // throw an InterruptedException,
    // which is a checked exception that can occur when a thread is interrupted while it is sleeping.

    // Thread.sleep(SLEEP_TIME);: This line of code pauses the execution of the thread for the duration
    // specified in SLEEP_TIME, which is 3 seconds in this case.
    // This simulates a slow operation that takes time to complete.
    Thread.sleep(SLEEP_TIME);

// After the thread sleeps for 3 seconds, this line of code generates a random alphanumeric string with a
// length of 10 characters using the RandomStringUtils.randomAlphanumeric() method from the Apache Commons
// Lang library.
    return RandomStringUtils.randomAlphanumeric(10);
  }

  /*
  * In summary, when a client sends an HTTP GET request to the "/random-string-slow" endpoint,
  * the thread handling the request will sleep for 3 seconds and then return a random alphanumeric string
  *  with a length of 10 characters. This simulates a slow operation that takes time to complete before
  *  generating the response.
  * */


}
