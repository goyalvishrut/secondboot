package com.example.secondboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.swing.text.View

@RestController
@RequestMapping("accounts")
class AccountController(
    val accountRepository: AccountRepository
) {

    @GetMapping("/")
    fun getAll(): List<ViewAccount> = accountRepository.findAll().map { it.toView() }

    @PostMapping("/")
    fun createAccount(@RequestBody request: CreateAccount) =
        accountRepository.save(Account(name = request.name)).toView()

    @GetMapping("/nameStartingWith")
    fun getAllByNameStartingWith(): List<ViewAccount> =
        accountRepository.findByNameStartingWith("first").map { it.toView() }

    @GetMapping("/nameEndingWith")
    fun getAllByNameEndingWith(): List<ViewAccount> =
        accountRepository.findByNameEndingWith("fourth").map { it.toView() }
}