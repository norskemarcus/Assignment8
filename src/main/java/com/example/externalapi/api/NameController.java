package com.example.externalapi.api;

import com.example.externalapi.dto.*;
import com.example.externalapi.service.NameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
public class NameController {

private NameService nameService;

  public NameController(NameService nameService) {
    this.nameService = nameService;
  }

  @GetMapping()
  public NameInfoResponseDTO fetchNameDetailsFromService(@RequestParam String name) {
    return nameService.fetchNameDetails(name);
  }

}
