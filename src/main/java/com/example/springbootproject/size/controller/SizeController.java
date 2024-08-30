package com.example.springbootproject.size.controller;

import com.example.springbootproject.size.domain.Size;
import com.example.springbootproject.size.service.SizeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/sizes")
@RequiredArgsConstructor
public class SizeController {

}
