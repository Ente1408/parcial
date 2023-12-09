package com.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Docente;
import com.example.services.DocenteService;

@RestController
@RequestMapping("/docente")
public class DocenteController {
	@Autowired
	private DocenteService docenteService;
	
	@PostMapping
	public ResponseEntity<Docente> save(@RequestBody Docente docente){
		return ResponseEntity.ok( docenteService.save(docente) );
	}
	@GetMapping
	public ResponseEntity<ArrayList<Docente>> getAll(){
		return ResponseEntity.ok(docenteService.getAll());
	}
	@PutMapping
	public ResponseEntity <Docente> update(@RequestBody Docente docente){
		return ResponseEntity.ok( docenteService.update(docente) );
	}
	@DeleteMapping ("/{id}")
	public ResponseEntity <String> delete(@PathVariable("id") Long id){
		docenteService.delete(id); 
		
		return ResponseEntity.ok("El profesor fue borrado correctamente");
	}
	

	
}
