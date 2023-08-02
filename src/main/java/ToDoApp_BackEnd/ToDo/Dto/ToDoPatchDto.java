package ToDoApp_BackEnd.ToDo.Dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ToDoPatchDto {
    private int id;

    private String title;

    private int todoOrder;

    private boolean completed;
}
