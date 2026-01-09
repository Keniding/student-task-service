package pe.keniding.student.task.core.business;

import pe.keniding.student.task.core.port.in.TaskInputPort;
import pe.keniding.student.task.core.port.in.TaskInputValue;
import pe.keniding.student.task.core.port.in.TaskReturnValue;
import pe.keniding.student.task.core.port.out.TaskData;
import pe.keniding.student.task.core.port.out.TaskOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TaskUseCase implements TaskInputPort {
    private static final Logger log = LoggerFactory.getLogger(TaskUseCase.class);
    private final TaskOutputPort taskOutputPort;

    public TaskUseCase(TaskOutputPort taskOutputPort) {
        this.taskOutputPort = taskOutputPort;
    }

    @Override
    public TaskReturnValue createTask(TaskInputValue input) {
        log.info("Creating task: {}", input.getTitle());

        TaskData taskData = new TaskData(
                null, input.getTitle(), input.getDescription(), input.getCategory(), TaskStatus.PENDING, input.getDueDate()
        );

        TaskData saved = taskOutputPort.save(taskData);

        return new TaskVo(
                saved.id(), saved.title(), saved.description(), saved.category(), saved.status(), saved.dueDate()
        );
    }

    @Override
    public TaskReturnValue getTask(Long id) {
        log.info("Getting task with id: {}", id);

        TaskData taskData = taskOutputPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        return mapToVo(taskData);
    }

    @Override
    public List<TaskReturnValue> getAllTasks() {
        log.info("Getting all tasks");
        return taskOutputPort.findAll().stream()
                .map(this::mapToVo)
                .toList();
    }

    @Override
    public TaskReturnValue updateTaskStatus(Long id, String status) {
        log.info("Updating task with id: {} to status: {}", id, status);

        TaskData task = taskOutputPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        TaskData update = new TaskData(
                task.id(), task.title(), task.description(), task.category(), TaskStatus.valueOf(status.toUpperCase()), task.dueDate()
        );

        TaskData saved = taskOutputPort.save(update);
        return mapToVo(saved);
    }

    @Override
    public void deleteTask(Long id) {
        log.info("Deleting task with id: {}", id);
        taskOutputPort.deleteById(id);
    }

    @Override
    public List<TaskReturnValue> getTasksByCategory(String category) {
        log.info("Getting task by category: {}", category);

        return taskOutputPort.findByCategory(category)
                .stream()
                .map(this::mapToVo)
                .toList();
    }

    private TaskReturnValue mapToVo(TaskData taskData) {
        return new TaskVo(
                taskData.id(), taskData.title(), taskData.description(), taskData.category(), taskData.status(), taskData.dueDate()
        );
    }
}
