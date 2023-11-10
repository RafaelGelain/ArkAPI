package br.ark.Model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Mob(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val imagem: String,
    val nome: String,
    val comportamento: Comportamento,
    val tipo: Tipo,
    val comida: Comida
)
