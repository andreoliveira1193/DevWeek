package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.Regiao;
import com.dio_class.devweek.Repo.RegiaoRepo;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerRegiao {

    private final RegiaoRepo repository;

    public ControllerRegiao(RegiaoRepo repository){

        this.repository = repository;
    }

  @GetMapping("/regiao")
    public ResponseEntity<?> findAllRegioes(){

  try{
      List<Regiao> allRegioes = repository.findAll();
      System.out.println("Achou");
      if(allRegioes.isEmpty())
          System.out.println("Vazia");
      return new ResponseEntity<>(allRegioes, HttpStatus.OK);

  }catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }

    }
   @GetMapping("/regiao{id}")
    public ResponseEntity<?> getRegiaoByID(@PathVariable Long id){
       Optional<Regiao> regiaoEscolhidaOptional =  repository.findById(id);

       if (regiaoEscolhidaOptional.isPresent()){
         Regiao regiaoUnid = regiaoEscolhidaOptional.get();
         return new ResponseEntity<>(regiaoUnid, HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/regiao/novo")
    public void putRegiao(Regiao newRegiao){
        repository.save(newRegiao);
    }
}
