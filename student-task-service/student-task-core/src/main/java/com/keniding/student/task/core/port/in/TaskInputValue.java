package com.keniding.student.task.core.port.in;

import com.keniding.student.task.core.business.TaskCategory;

public interface TaskInputValue {
    String getTitle();
    String getDescription();
    TaskCategory getCategory();
    String getDueDate();
}
