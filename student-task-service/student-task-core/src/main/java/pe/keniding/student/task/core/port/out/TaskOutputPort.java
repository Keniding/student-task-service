package pe.keniding.student.task.core.port.out;

import java.util.List;
import java.util.Optional;

public interface TaskOutputPort {
    TaskData save(TaskData task);
    Optional<TaskData> findById(Long id);
    List<TaskData> findAll();
    List<TaskData> findByCategory(String category);
    void deleteById(Long id);
}
