package school.listecourses.exercicelistedecourses.application.discountType.commands.update;

import lombok.Getter;

@Getter
public class DiscountTypeUpdateCommand {
    private final long id;
    private final String newDescription;
    private final String newBackgroundColor;
    private final String newTextColor;

    public DiscountTypeUpdateCommand(long id, String newDescription, String newBackgroundColor, String newTextColor) {
        this.id = id;
        this.newDescription = newDescription;
        this.newBackgroundColor = newBackgroundColor;
        this.newTextColor = newTextColor;
    }
}
