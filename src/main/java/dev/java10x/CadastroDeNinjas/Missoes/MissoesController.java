package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // POST --- Mandar uma requisao para criar as missoes
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missoesService.criarMissao(missao);
    }

    // GET --- Mandar uma requisao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesDTO> listarMissao(){
        return missoesService.listarmissoes();
    }

    // GET --- Mandar uma requisao para mostrar a missão pelo ID
    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }

    // PUT --- Mandar uma requisao para alterar as missoes
    @PutMapping("/alterar/{id}")
    public MissoesDTO AlterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        return missoesService.atualizarMissao(id, missaoAtualizada);
    }

    // DELETE --- Mandar uma requisao para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }




}
