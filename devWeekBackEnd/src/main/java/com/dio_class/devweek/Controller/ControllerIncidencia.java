package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.Incidencia;
import com.dio_class.devweek.Repo.IncidenciaRepo;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class ControllerIncidencia {
   private final IncidenciaRepo icRepository;

   public ControllerIncidencia(IncidenciaRepo icRepository){
       this.icRepository = icRepository;
   }

   @GetMapping("/ocorrencias")
   public ResponseEntity<List<Incidencia>> findOcorrencias() {
       List<Incidencia> listaOcorrencia = icRepository.findAll();
       if (listaOcorrencia.isEmpty())
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       return new ResponseEntity<>(listaOcorrencia, HttpStatus.OK);
   }

   @GetMapping("/ocorrencia/{id}")
   public ResponseEntity<Incidencia> findOcorrenciasById(@PathVariable Long id){
           Optional<Incidencia>ocorrenciaOptional = icRepository.findById(id);
           if(ocorrenciaOptional.isPresent()){
               Incidencia ocorrenciaUnid = ocorrenciaOptional.get();
               return new ResponseEntity<>(ocorrenciaUnid, HttpStatus.OK);
           }
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }


    @PostMapping("/incidencia/novo")
    public Incidencia newIncidencia(@RequestBody Incidencia newIncidencia){
        return icRepository.save(newIncidencia);

    }


}
