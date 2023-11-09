package br.ark.converters

import br.ark.DTOS.DinoDTO
import br.ark.DTOS.DinoResponseDTO
import br.ark.Model.Comida
import br.ark.Model.Comportamento
import br.ark.Model.Mob
import br.ark.Model.Tipo
import org.springframework.stereotype.Component

@Component
class DinoConverter {
        fun toDino(dto: DinoDTO): Mob{
            return Mob(
        imagem = dto.imagem,
        nome = dto.nome,
        comportamento = dto.comportamento,
        tipo = dto.tipo,
        comida = dto.comida
            )
        }
    fun toEventoResponseDTO(mob: Mob): DinoResponseDTO {
        return DinoResponseDTO(
            id = mob.id,
            imagem = mob.imagem,
            nome = mob.nome,
            comportamento = mob.comportamento,
            tipo = mob.tipo,
            comida = mob.comida
        )
    }
}