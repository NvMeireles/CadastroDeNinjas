package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

private NinjaRepository ninjarepository;

    public NinjaService(NinjaRepository ninjarepository) {
        this.ninjarepository = ninjarepository;
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
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjarepository.save(ninja);
    }

    // Deletar um ninja - Tem que ser um metodo void
    public void deletarNinjaPorId(Long id){
        ninjarepository.deleteById(id);
    }
}
