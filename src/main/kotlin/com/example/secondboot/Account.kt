package com.example.secondboot

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
/*
@Table(name = "account")
This annotation can be used to map this entity to a different table lets say table_2, so it will be like
@Table(name = "table_2")
 */
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String
)

data class ViewAccount(
    val id: Long,
    val name: String
)

fun Account.toView() = ViewAccount(id = this.id, name = this.name)

data class CreateAccount(
    val name: String
)