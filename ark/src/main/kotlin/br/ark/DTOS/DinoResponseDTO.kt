package br.ark.DTOS

import br.ark.Model.Comida
import br.ark.Model.Comportamento
import br.ark.Model.Tipo

data class DinoResponseDTO (
    val id: Long?,
    val imagem: String,
    val nome: String,
    val comportamento: Comportamento,
    val tipo: Tipo,
    val comida: Comida
)
