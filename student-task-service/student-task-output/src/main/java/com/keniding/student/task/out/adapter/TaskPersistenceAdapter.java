package com.keniding.student.task.out.adapter;

import com.keniding.student.task.core.business.TaskCategory;
import com.keniding.student.task.core.port.out.TaskData;
import com.keniding.student.task.core.port.out.TaskOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskPersistenceAdapter implements TaskOutputPort {
    private final TaskJpaRepository repository;
    private final TaskEntityMapper mapper = Mappers.getMapper(TaskEntityMapper.class);

    @Override
    public TaskData save(TaskData task) {
        log.info("Saving task: {}", task.title());
        TaskEntity entity = mapper.toEntry(task);
        TaskEntity savedEntity = repository.save(entity);
        return mapper.toData(savedEntity);
    }

    @Override
    public Optional<TaskData> findById(Long id) {
        log.info("Getting task with id: {}", id);
        return repository.findById(id)
                .map(mapper::toData);
    }

    @Override
    public List<TaskData> findAll() {
        log.info("Getting all tasks");
        return repository.findAll()
                .stream()
                .map(mapper::toData)
                .toList();
    }

    @Override
    public List<TaskData> findByCategory(String category) {
        log.info("Finding tasks by category: {}", category);
        TaskCategory taskCategory = TaskCategory.valueOf(category.toUpperCase());
        return repository.findByCategory(taskCategory).stream()
                .map(mapper::toData)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting task with id: {}", id);
        repository.deleteById(id);
    }
}
