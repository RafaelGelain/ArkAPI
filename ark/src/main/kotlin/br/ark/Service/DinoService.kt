package br.ark.Service


import NotFoundException
import br.ark.DTOS.DinoDTO
import br.ark.DTOS.DinoResponseDTO
import br.ark.Repository.DinoRepository
import br.ark.converters.DinoConverter
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable

private const val DINO_NOT_FOUND_MESSAGE = "Dinossauro não encontrado!"
@Service
class DinoService (private val repository: DinoRepository, private val converter: DinoConverter) {
    fun listar(
        nomeDino: String?,
        paginacao: Pageable): Page<DinoResponseDTO> {
        val mob = if (nomeDino == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeDino, paginacao)
        }
        return mob
            .map(converter::toEventoResponseDTO)
    }


    fun buscarPorId(id: Long): DinoResponseDTO {
        val Mob = repository.findById(id)
            .orElseThrow { NotFoundException(DINO_NOT_FOUND_MESSAGE) }
        return converter.toEventoResponseDTO(Mob)
    }

    fun atualizar(id: Long, dto: DinoDTO): DinoResponseDTO {
        val Mob = repository.findById(id)
            .orElseThrow { NotFoundException(DINO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                imagem  = dto.imagem,
                comportamento  = dto.comportamento,
                tipo  = dto.tipo,
                comida  = dto.comida
            )
        return converter.toEventoResponseDTO(repository.save(Mob))
    }
    fun deletar(id: Long) {
        repository.deleteById(id)
    }
    fun cadastrar(dto: DinoDTO): DinoResponseDTO {
        return converter.toEventoResponseDTO(
            repository.save(converter.toDino(dto)))
    }


}