package school.listecourses.exercicelistedecourses.application.discountType.commands.delete;

import lombok.Getter;

@Getter
public class DiscountTypeDeleteOutput {
    private final boolean success;
    private final String message;

    public DiscountTypeDeleteOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
