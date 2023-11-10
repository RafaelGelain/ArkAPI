package br.ark.Repository

import br.ark.DTOS.DinoDTO
import br.ark.Model.Comida
import br.ark.Model.Comportamento
import br.ark.Model.Mob
import br.ark.Model.Tipo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DinoRepository: JpaRepository<Mob, Long> {
}
