package com.example.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Docente;
import com.example.repositories.DocenteRepository;

@Service
public class DocenteService {

	@Autowired
	private DocenteRepository docenteRepository;
	
	public Docente save(Docente docente) {
		
		if(docenteRepository.findExistByTipoYDoc(docente.getTipoDoc(),docente.getNumeroIdentificacion()))
		{
			return null;
		}
		
		return docenteRepository.save(docente);
	}
	public ArrayList<Docente> getAll(){
		return (ArrayList<Docente>) docenteRepository.findAll();
	}
	
	public Docente update(Docente docente) {
		if( docenteRepository.existsById(docente.getId()))
		{
			return docenteRepository.save(docente);
		}else
		{
			return null;
		}
		
	}
	public void delete(Long id) {
		if( docenteRepository.existsById(id))
		{
			docenteRepository.deleteById(id);
		}
		
	}
	
}
