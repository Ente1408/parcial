package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.models.Docente;

@Repository

public interface DocenteRepository extends JpaRepository<Docente,Long>{
	
	@Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM Docente d WHERE d.tipoDoc = ?1 AND d.numeroIdentificacion = ?2")
	public boolean findExistByTipoYDoc(String tipoDoc, String numeroIdentificacion);
			
	
	
}