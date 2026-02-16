package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

private NinjaRepository ninjarepository;
private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjarepository, NinjaMapper ninjaMapper) {
        this.ninjarepository = ninjarepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os ninjas

    public List<NinjaModel> listarNinjas(){
        return ninjarepository.findAll();
    }

    // Listar ninjas por id
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjarepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjarepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deletar um ninja - Tem que ser um metodo void
    public void deletarNinjaPorId(Long id){
        ninjarepository.deleteById(id);
    }

    // Atualizar Ninja

    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if (ninjarepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjarepository.save(ninjaAtualizado);
        }
        return null;
    }
}
