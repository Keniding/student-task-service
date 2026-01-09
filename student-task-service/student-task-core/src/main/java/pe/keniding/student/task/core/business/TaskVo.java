package pe.keniding.student.task.core.business;

import pe.keniding.student.task.core.port.in.TaskReturnValue;

public record TaskVo(
        Long id,
        String title,
        String description,
        TaskCategory category,
        TaskStatus status,
        String dueDate
) implements TaskReturnValue {

    @Override
    public Long getId() { return id; }

    @Override
    public String getTitle() { return title; }

    @Override
    public String getDescription() { return description; }

    @Override
    public TaskCategory getCategory() { return category; }

    @Override
    public TaskStatus getStatus() { return status; }

    @Override
    public String getDueDate() { return dueDate; }
}
