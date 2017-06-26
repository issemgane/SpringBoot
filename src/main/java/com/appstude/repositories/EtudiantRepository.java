package com.appstude.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appstude.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	public List<Etudiant> findByNom(String nom);
	public Page<Etudiant> findByNom(String nom,Pageable pageable);
	@Query("select e from Etudiant e where e.nom like :x")
	public Page<Etudiant> searchStudentsByMc(@Param("x")String mc,Pageable pageable);
	@Query("select e from Etudiant e where e.dateNaissance > :x1 and e.dateNaissance < :x2")
	public List<Etudiant> listStudents(@Param("x1")Date d1,@Param("x2")Date d2);
}
