package pe.keniding.student.task.out.adapter;

import pe.keniding.student.task.core.port.out.TaskData;
import org.mapstruct.Mapper;

@Mapper
public interface TaskEntityMapper {
    TaskEntity toEntry(TaskData data);
    TaskData toData(TaskEntity entity);
}
