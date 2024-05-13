package br.org.serratec.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.biblioteca.entities.Perfil;
import br.org.serratec.biblioteca.services.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	PerfilService perfilService;
	
	@GetMapping
	public ResponseEntity<List<Perfil>> findAll() {
		return new ResponseEntity<>(perfilService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}") //deve ser o msmo nome do parametro de findById(id) abaixo
	public ResponseEntity <Perfil> findById(@PathVariable Integer id) { //pathVariable estabelece que a variavel a frente "Integer id" esta sendo passada no path ("/{id}")  
		Perfil perfil = perfilService.findById(id);
		
		if(perfil == null)	
			return new ResponseEntity<>(perfil, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(perfil, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Perfil> save(@RequestBody Perfil perfil) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.save(perfil));
    }
	
	@PutMapping
	public ResponseEntity<Perfil> update(@RequestBody Perfil perfil) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.update(perfil));
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Perfil> delete(@PathVariable Integer id) {
        Perfil perfil = perfilService.findById(id);
        
        if(perfil == null) {	
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
			perfilService.delete(id);
			return new ResponseEntity<>(perfil, HttpStatus.OK);
        }
    }
	
}
