package com.appstude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.appstude.entities.Etudiant;
import com.appstude.repositories.EtudiantRepository;
@Service
public class StudentService {

	@Autowired
	EtudiantRepository etudiantRepository;
	
	public Etudiant add(Etudiant e){
		System.err.println("***** add from service Called*****");
		return etudiantRepository.save(e);
	}
	
	
	
	public Page<Etudiant> getAllStudents(int page,int size){
		Page<Etudiant> list = etudiantRepository.findAll(new PageRequest(page, size));
		return list;
	}
	
	public Page<Etudiant> getAllStudentsByKeyword(String keyword,int page,int size){
		Page<Etudiant> list = etudiantRepository.searchStudentsByMc(keyword,new PageRequest(page, size));
		return list;
	}
	
	public Etudiant saveStudent(Etudiant s){
		Etudiant e = etudiantRepository.save(s);
		return e;
	}
	
	public Etudiant getOne(Long id){
		Etudiant e = etudiantRepository.getOne(id);
		return e;
	}
	
	public void delete(Long id){
		etudiantRepository.delete(id);
	}
}
