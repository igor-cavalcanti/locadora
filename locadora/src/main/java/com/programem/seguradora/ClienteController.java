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
public class ClienteController {
   
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping(path="/insere")
    public @ResponseBody String addNewCliente(@RequestParam String nome,
    @ResquestParam Integer idade,
    @RequestParam String endereco){

        Cliente c = new Cliente();
    c.setIdade(idade);
    c.setEndereco(endereco);
    c.setNome(nome);
    clienteRepository.save(c);
    return "Inserido";    
    }
    @GetMapping(path="/lista")
    public @ResponseBody Iterable<Cliente> getAllCliente() {
      // This returns a JSON or XML with the users
      return clienteRepository.findAll();
    }
  
}