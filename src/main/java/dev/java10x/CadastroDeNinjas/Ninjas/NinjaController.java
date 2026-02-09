package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

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
    public String MostrarTodosOsNinjas(){
        return "Mostrar Ninja";
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
