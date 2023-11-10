package br.ark.Controller

import br.ark.DTOS.DinoDTO
import br.ark.DTOS.DinoResponseDTO
import br.ark.Model.Mob
import br.ark.Service.DinoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/dinossauro")

class DinoController(val service: DinoService) {

    @GetMapping
    fun listar(): List<DinoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): DinoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastra(@RequestBody @Valid dto: DinoDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<DinoResponseDTO> {
        val dinoResponse  = service.cadastrar(dto)
        val uri = uriBuilder.path("/dinossauro/${dinoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(dinoResponse)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: DinoDTO): DinoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}