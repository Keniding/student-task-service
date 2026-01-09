package pe.keniding.student.task.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.keniding.student.task.core.business.TaskUseCase;
import pe.keniding.student.task.core.port.in.TaskInputPort;
import pe.keniding.student.task.core.port.out.TaskOutputPort;

@Configuration
public class CoreConfig {

    @Bean
    public TaskInputPort taskInputPort(TaskOutputPort outputPort) {
        return new TaskUseCase(outputPort);
    }
}
