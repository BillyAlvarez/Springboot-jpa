package cl.bja.springboot.jpa;

import cl.bja.springboot.jpa.entities.Person;
import cl.bja.springboot.jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //List<Person> persons = (List<Person>) personRepository.findAll();
        List<Person> persons = (List<Person>) personRepository.findByProgrammingLanguageAndName("java", "Josefa");

        persons.forEach(System.out::println);

        //persons.stream().forEach(person -> System.out.println(person));

    }
}
