package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
