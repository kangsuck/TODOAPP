package ToDoApp_BackEnd.ToDo.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class ToDoPostDto {
    @NotBlank
    private String title;
    @NotBlank
    private int todoOrder;
    @NotBlank
    private boolean completed;

}
