package pe.keniding.student.task.out.adapter;

import pe.keniding.student.task.core.business.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskJpaRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByCategory(TaskCategory category);
}
