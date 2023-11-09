package br.ark.DTOS

import br.ark.Model.Comida
import br.ark.Model.Comportamento
import br.ark.Model.Tipo
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class DinoDTO(
    @field:NotEmpty(message = "O Campo precisa conter uma imagem" )
    val imagem: String,
    @field:NotEmpty(message = "O Campo precisa conter um nome" )
    val nome: String,
    val comportamento: Comportamento,
    val tipo: Tipo,
    val comida: Comida
)