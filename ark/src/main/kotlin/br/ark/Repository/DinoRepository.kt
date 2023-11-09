package br.ark.Repository

import br.ark.DTOS.DinoDTO
import br.ark.Model.Comida
import br.ark.Model.Comportamento
import br.ark.Model.Mob
import br.ark.Model.Tipo
import org.springframework.stereotype.Repository

@Repository
class DinoRepository(private var mobs: MutableList<Mob>) {
    private var idCont = 4L

    fun update(mob: Mob, mobAtualizado: Mob): Mob {
        mobs.remove(mob)
        val mobAtualizadoComId = Mob(
            id = mob.id,
            imagem = mobAtualizado.imagem,
            nome = mobAtualizado.nome,
            comportamento = mobAtualizado.comportamento,
            tipo = mobAtualizado.tipo,
            comida = mobAtualizado.comida
        )
        mobs.add(mobAtualizadoComId)
        return mobAtualizadoComId
    }

    fun deletar(id: Long) {
        val Mob = mobs.first { it.id == id }
        mobs.remove(Mob)
    }

    fun cadastrar(mob: Mob): Mob {
        val mobComId = mob.copy(id = idCont++)
        mobs.add(mobComId)
        return mobComId
    }

    init{
        val mob1 = Mob(
            id = 1,
            imagem = "1",
            nome = "Basilo",
            comportamento = Comportamento.Agressivo,
            tipo = Tipo.Aquatico,
            comida = Comida.Carnivoro
        )
        val mob2 = Mob(
            id = 2,
            imagem = "1",
            nome = "Carno",
            comportamento = Comportamento.Agressivo,
            tipo = Tipo.Terrestre,
            comida = Comida.Carnivoro
        )
        val mob3 = Mob(
            id = 3,
            imagem = "1",
            nome = "Dodo",
            comportamento = Comportamento.Passifico,
            tipo = Tipo.Terrestre,
            comida = Comida.Herbivoro
        )
        mobs = mutableListOf(mob1, mob2, mob3)
    }
    fun findAll() = mobs
}