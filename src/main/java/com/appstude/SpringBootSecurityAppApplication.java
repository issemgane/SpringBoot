package com.appstude;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.appstude.entities.Etudiant;
import com.appstude.repositories.EtudiantRepository;

@SpringBootApplication
public class SpringBootSecurityAppApplication {

	public static void main(String[] args) throws ParseException{
		ApplicationContext ctx = SpringApplication.run(SpringBootSecurityAppApplication.class, args);
		
		//getting object that implements this interface
		/*EtudiantRepository  etudiantRepository = ctx.getBean(EtudiantRepository.class);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
	
		etudiantRepository.save(new Etudiant("Issemgane","ali",df.parse("1964-05-01")));
		etudiantRepository.save(new Etudiant("kamal","wahbi",df.parse("1995-05-04")));
		

		etudiantRepository.save(new Etudiant("rachid","alii",df.parse("1980-10-01")));
		etudiantRepository.save(new Etudiant("fatima","wahbi",df.parse("1995-05-04")));
		etudiantRepository.save(new Etudiant("khadija","ali",df.parse("1981-10-01")));
		etudiantRepository.save(new Etudiant("malika","wahbi",df.parse("1995-05-04")));
		etudiantRepository.save(new Etudiant("rachid","ali",df.parse("1964-10-01")));
		etudiantRepository.save(new Etudiant("Ali","wahbi",df.parse("1995-05-04")));
		etudiantRepository.save(new Etudiant("rachida","ali",df.parse("1991-11-01")));
		etudiantRepository.save(new Etudiant("wafae","wahbi",df.parse("1995-05-04")));
		etudiantRepository.save(new Etudiant("manal","ali",df.parse("1988-12-01")));
		etudiantRepository.save(new Etudiant("sanae","wahbi",df.parse("1995-05-04")));
		etudiantRepository.save(new Etudiant("rim","ali",df.parse("1988-02-01")));
		etudiantRepository.save(new Etudiant("meryem","wahbi",df.parse("1995-05-04")));
		etudiantRepository.save(new Etudiant("fatiha","ali",df.parse("1988-05-01")));
		etudiantRepository.save(new Etudiant("driss","wahbi",df.parse("1995-05-04")));
		etudiantRepository.save(new Etudiant("issmail","ali",df.parse("1988-08-01")));
		etudiantRepository.save(new Etudiant("monim","wahbi",df.parse("1995-05-04")));
		etudiantRepository.save(new Etudiant("bachir","ali",df.parse("1983-07-01")));
		etudiantRepository.save(new Etudiant("youssef","wahbi",df.parse("1995-05-04")));*/
	}
}
