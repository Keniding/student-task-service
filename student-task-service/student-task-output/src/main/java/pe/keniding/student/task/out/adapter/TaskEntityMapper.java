package pe.keniding.student.task.out.adapter;

import pe.keniding.student.task.core.port.out.TaskData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskEntityMapper {

    TaskEntity toEntity(TaskData data);
    TaskData toData(TaskEntity entity);
}
