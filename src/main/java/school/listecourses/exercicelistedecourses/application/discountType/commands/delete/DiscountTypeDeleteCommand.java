package school.listecourses.exercicelistedecourses.application.discountType.commands.delete;

import lombok.Getter;

@Getter
public class DiscountTypeDeleteCommand {
    private final long id;

    public DiscountTypeDeleteCommand(long id) {
        this.id = id;
    }
}
