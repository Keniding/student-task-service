package com.keniding.student.task.core.port.in;

import com.keniding.student.task.core.business.TaskCategory;
import com.keniding.student.task.core.business.TaskStatus;

public interface TaskReturnValue {
    Long getId();
    String getTitle();
    String getDescription();
    TaskCategory getCategory();
    TaskStatus getStatus();
    String getDueDate();
}
