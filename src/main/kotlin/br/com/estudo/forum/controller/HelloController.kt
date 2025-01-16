package br.com.estudo.forum.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/teste")

class HelloController {
    @GetMapping
    fun hello(): String {
        return "teste"
    }
}