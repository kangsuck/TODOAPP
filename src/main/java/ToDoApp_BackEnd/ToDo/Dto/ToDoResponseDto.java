package ToDoApp_BackEnd.ToDo.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ToDoResponseDto {
    private  int id;

    private String title;

    private int todoOrder;

    private boolean completed;
}
