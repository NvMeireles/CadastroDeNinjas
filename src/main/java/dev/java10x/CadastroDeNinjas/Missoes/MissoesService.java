package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Listar todas as missoes

    public List<MissoesModel> listarmissoes(){
        return missoesRepository.findAll();
    }

    // Listar missao por id

    public MissoesModel listarMissaoPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    // Criar missao

    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    // Deletar missao

    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
}
}