package dev.java10x.CadastroDeNinjas.Ninjas;

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
    public String criarNinja(){
        return "Ninja Criado";
    }
    // Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas()
    {
        return ninjaService.listarNinjas();
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping("/listarID")
    public String MostrarTodosOsNinjasPorId(){
        return "Mostrar Ninja por ID";
    }

    // Alterar dados dos Ninja (UPDATE)
    @PutMapping("/alterarID")
    public String AlterarNinjaPorId(){
        return "Alterar Ninja Por ID";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String DeletarNinjaPorId(){
        return "Deletar Ninja por ID";
    }


}
