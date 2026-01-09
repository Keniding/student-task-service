package pe.keniding.student.task.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "pe.keniding.student.task.app",
        "pe.keniding.student.task.in.adapter",
        "pe.keniding.student.task.out.adapter"
})
public class StudentTaskAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentTaskAppApplication.class, args);
    }

}
