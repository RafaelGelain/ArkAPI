package br.ark.Service


import NotFoundException
import br.ark.DTOS.DinoDTO
import br.ark.DTOS.DinoResponseDTO
import br.ark.Model.Mob
import br.ark.Repository.DinoRepository
import br.ark.converters.DinoConverter
import org.springframework.stereotype.Service

@Service
class DinoService (private val repository: DinoRepository, private val converter: DinoConverter) {
    fun listar(): List<DinoResponseDTO>{
        return repository.findAll()
            .map(converter::toEventoResponseDTO)
    }
    fun buscarPorId(id: Long): DinoResponseDTO {
        val mob = repository.findAll().firstOrNull { it.id == id }
            ?: throw NotFoundException( "Não encontrado !!" )
        return converter.toEventoResponseDTO(mob)
    }
    // NÃO ALTERADO O ATUALIZAR // DANDO ERRO

    fun atualizar(id: Long, dto: DinoDTO): DinoResponseDTO {
        val mob = repository.findAll().firstOrNull { it.id == id }
            ?: throw NotFoundException( "Não encontrado !!" )
        val mobAtualizado = repository.update(mob , converter.toDino(dto))
        return converter.toEventoResponseDTO(mobAtualizado)
    }
    fun deletar(id: Long) {
        repository.deletar(id)
    }
    fun cadastrar(dto: DinoDTO): DinoResponseDTO {
        val Mob = repository.cadastrar(converter.toDino(dto))
        return converter.toEventoResponseDTO(Mob)
    }

}