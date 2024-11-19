package school.listecourses.exercicelistedecourses.application.discountType.commands.update;

import lombok.Getter;

@Getter
public class DiscountTypeUpdateOutput {
    private final boolean success;
    private final String message;

    public DiscountTypeUpdateOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
