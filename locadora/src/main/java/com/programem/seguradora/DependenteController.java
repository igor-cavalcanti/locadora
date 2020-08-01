package com.programem.seguradora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seguradora")
public class DependenteController {
   
    @Autowired
    private DependenteRepository DependenteRepository;

    @PostMapping(path="/insere2")
    public @ResponseBody String addNewDependente(@RequestParam String nome,
    @ResquestParam Integer idade,
    @RequestParam String endereco){

        Dependente c = new Dependente();
    c.setIdade(idade);
    c.setEndereco(endereco);
    c.setNome(nome);
    DependenteRepository.save(c);
    return "Inserido2";    
    }
    @GetMapping(path="/lista2")
    public @ResponseBody Iterable<Dependente> getAllDependente() {
      // This returns a JSON or XML with the users
      return DependenteRepository.findAll();
    }
  
}