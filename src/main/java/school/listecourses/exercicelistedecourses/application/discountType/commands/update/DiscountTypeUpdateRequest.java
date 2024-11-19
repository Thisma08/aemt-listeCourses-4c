package school.listecourses.exercicelistedecourses.application.discountType.commands.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscountTypeUpdateRequest {
    private  String newDescription;
    private  String newBackgroundColor;
    private  String newTextColor;
}
