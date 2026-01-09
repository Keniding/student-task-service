package pe.keniding.student.task.core.port.in;

import pe.keniding.student.task.core.business.TaskCategory;
import pe.keniding.student.task.core.business.TaskStatus;

public interface TaskReturnValue {
    Long getId();
    String getTitle();
    String getDescription();
    TaskCategory getCategory();
    TaskStatus getStatus();
    String getDueDate();
}
