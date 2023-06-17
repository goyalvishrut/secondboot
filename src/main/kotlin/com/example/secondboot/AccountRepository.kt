package com.example.secondboot

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface AccountRepository : CrudRepository<Account, Long> {

    fun findByNameStartingWith(prefix: String): List<Account>

    @Query(
        "SELECT a FROM Account a WHERE a.name LIKE concat('%', :suffix)"
    )
    fun findByNameEndingWith(suffix: String): List<Account>
}