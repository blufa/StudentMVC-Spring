package sn.isi.studentcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.isi.studentcrud.dao.IStudent;
import sn.isi.studentcrud.model.Student;

@SpringBootApplication
public class StudentcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentcrudApplication.class, args);
	}


	@Autowired
	private IStudent studentdao;
/*
	@Bean
	protected CommandLineRunner commandLineRunner(){
		return args -> {
			studentdao.save(new Student(null,"Jean Claude","DAKAR","jeccam38@gmail.com","776361783"));
			studentdao.save(new Student(null,"Eric Manga","THIAROYE","manga@gmail.com","776361783"));
			studentdao.save(new Student(null,"Lucie Manga","COYAH","coyah8@gmail.com","776361783"));
			studentdao.save(new Student(null,"Fatoumata Manga","Coleyah","fa@gmail.com","776361783"));
			studentdao.save(new Student(null,"Fanta Sackho","Sangoyah","fanta@gmail.com","776361783"));
			studentdao.save(new Student(null,"Mohamed Soumah","Somayah","moh@gmail.com","776361783"));
			studentdao.save(new Student(null,"Toumany Diakité","Cuba","toumani@gmail.com","776361783"));
			studentdao.save(new Student(null,"Lamine Sangaré","KANKAN","admin@gmail.com","776361783"));
			studentdao.save(new Student(null,"Oury DIALLO","Sigon","sigon@gmail.com","776361783"));
			studentdao.save(new Student(null,"Djenabou Diallo","Timbi","djena@gmail.com","776361783"));
			studentdao.save(new Student(null,"Amadou Sall","HLM","sall@gmail.com","776361783"));

			studentdao.findAll().forEach(student -> {
				System.out.println(student.getName());
			});
		};
	}

 */

}
