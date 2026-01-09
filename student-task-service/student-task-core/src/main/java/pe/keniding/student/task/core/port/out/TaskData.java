package pe.keniding.student.task.core.port.out;

import pe.keniding.student.task.core.business.TaskCategory;
import pe.keniding.student.task.core.business.TaskStatus;

public record TaskData(
        Long id,
        String title,
        String description,
        TaskCategory category,
        TaskStatus status,
        String dueDate
) {}
