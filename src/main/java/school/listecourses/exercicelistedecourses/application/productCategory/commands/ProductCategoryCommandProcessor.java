package school.listecourses.exercicelistedecourses.application.productCategory.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.create.ProductCategoryCreateCommand;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.create.ProductCategoryCreateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class ProductCategoryCommandProcessor {
    private final ICommandHandler<ProductCategoryCreateCommand, ProductCategoryCreateOutput> createListeCoursesHandler;

    public ProductCategoryCommandProcessor(ICommandHandler<ProductCategoryCreateCommand, ProductCategoryCreateOutput> createListeCoursesHandler) {
        this.createListeCoursesHandler = createListeCoursesHandler;
    }

    public ProductCategoryCreateOutput create(ProductCategoryCreateCommand command) {
        return createListeCoursesHandler.handle(command);
    }
}
