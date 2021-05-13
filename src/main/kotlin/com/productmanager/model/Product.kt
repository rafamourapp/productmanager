package com.productmanager.model

import com.sun.istack.NotNull
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
data class Product(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    @field:Size(max = 50, message = "Nome deve ter no máximo 50 caracteres")
    var name: String,

    @field:NotNull
    var type: String
)