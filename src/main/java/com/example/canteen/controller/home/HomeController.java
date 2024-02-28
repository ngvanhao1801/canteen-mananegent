package com.example.canteen.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class HomeController {

  @GetMapping("/home")
  public String showHomeForm() {
    return "home";
  }

  @GetMapping("/chart.html")
  @ResponseBody
  public String getChartHTML() throws IOException {
    return new String(Files.readAllBytes(Paths.get("src/main/resources/templates/chart.html")));
  }

}
