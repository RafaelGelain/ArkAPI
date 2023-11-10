package br.ark.Repository

import br.ark.Model.Mob
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.domain.Pageable
@Repository
interface DinoRepository: JpaRepository<Mob, Long> {
    fun findByNome(nomeDino: String, paginacao: Pageable): Page<Mob>
}
