package com.appstude.webservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appstude.entities.Etudiant;
import com.appstude.services.StudentService;



@RestController
@RequestMapping(value ="/studentsResource")
public class EtudiantResource {

	@Autowired
	private StudentService studentService;
	
	@Secured(value={"ROLE_ADMIN","ROLE_PROF"})
	@RequestMapping(value ="/students", method = RequestMethod.POST)
	public Object add(@RequestBody @Valid Etudiant e,BindingResult result){
		if(result.hasErrors()){
			
			Map<String, Object> errorsMap = new HashMap<>();
			errorsMap.put("hasErrors", true);
			for (FieldError fe  : result.getFieldErrors() ) {
				errorsMap.put(fe.getField(), fe.getDefaultMessage());
			}
			
			return errorsMap;
		}
		return studentService.add(e);
	}
	
	
	@RequestMapping(value ="/students/{id}", method = RequestMethod.DELETE)
	public void addTopic(@PathVariable Long id){
		studentService.delete(id);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_PROF"})
	@RequestMapping(value ="/students/{id}", method = RequestMethod.GET)
	public Etudiant getStudent(@PathVariable Long id){
	
		return studentService.getOne(id);
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value ="/students/{param1}/{param2}", method = RequestMethod.GET)
	public Page<Etudiant> getAllStudents(@PathVariable(name="param1") int page,@PathVariable(name="param2") int size){
		return studentService.getAllStudents(page, size);
	}
	
	
	
	@RequestMapping(value ="/getLogedUser", method = RequestMethod.GET)
	public Map<String,Object> getLogedUser(HttpServletRequest httpServletRequest){
		
		//get SecurityContext from session
		HttpSession session = httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		
		//read username from  SecurityContext 
		String username = securityContext.getAuthentication().getName();
		
		List<String> lisOfRoles = new ArrayList<>();
		//read list of roles  from  SecurityContext 
		for(GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()){
			lisOfRoles.add(ga.getAuthority());
		}
		
		Map<String,Object> params = new HashMap<>();
		
		params.put("username", username);
		params.put("roles", lisOfRoles);
		
		return params;
	}
}
