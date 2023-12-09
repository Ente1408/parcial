package com.example.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Estudiante;
import com.example.repositories.EstuadianteRepository;

@Service
public class EstudianteService {
	
	@Autowired
	private EstuadianteRepository estudianteRepository;
	
	public Estudiante save(Estudiante estudiante) {
		
		return estudianteRepository.save(estudiante);
	}
	public ArrayList<Estudiante> getAll(){
		return (ArrayList<Estudiante>) estudianteRepository.findAll();
	}
	public Estudiante update(Estudiante estudiante) {
		//Validar que el estudiante exista
		if( estudianteRepository.existsById(estudiante.getId()))
		{
			return estudianteRepository.save(estudiante);
		}else
		{
			return null;
		}
		
		
	}

}
