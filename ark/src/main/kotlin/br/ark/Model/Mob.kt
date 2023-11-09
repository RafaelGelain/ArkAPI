package br.ark.Model

data class Mob(
    val id: Long? = null,
    val imagem: String,
    val nome: String,
    val comportamento: Comportamento,
    val tipo: Tipo,
    val comida: Comida
)
