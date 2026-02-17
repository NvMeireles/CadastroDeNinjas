package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Olá, mundo!";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja)
    {
        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com Sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas()
    {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id)
    {
       NinjaDTO ninjaPorId =  ninjaService.listarNinjasPorId(id);

       if (ninjaPorId != null){
           return ResponseEntity.ok(ninjaPorId);
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Ninja com o id: " + id + " não existe no registro");
       }
    }

    // Alterar dados dos Ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> AlterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){

        if (ninjaService.listarNinjasPorId(id) != null) {
            NinjaDTO ninjaNovo = ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Ninja com o ID " + id + " atualizado com Sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " + id + " não encontrado");
        }
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> DeletarNinjaPorId(@PathVariable Long id){

        if (ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com Sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " + id + " não encontrado");
        }

    }


}
