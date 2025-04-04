package com.example.demo.controller;

import com.example.demo.service.FaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

    @Autowired
    private FaturaService faturaService;

    @PostMapping("/processar")
    public String processarFaturas() {
        faturaService.processarPlanilha();
        return "Processamento concluído!";
    }
}
