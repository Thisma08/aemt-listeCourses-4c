package school.listecourses.exercicelistedecourses.application.productCategory.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.create.ProductCategoryCreateCommand;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.create.ProductCategoryCreateOutput;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.delete.ProductCategoryDeleteCommand;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.delete.ProductCategoryDeleteOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class ProductCategoryCommandProcessor {
    private final ICommandHandler<ProductCategoryCreateCommand, ProductCategoryCreateOutput> createListeCoursesHandler;
    private final ICommandHandler<ProductCategoryDeleteCommand, ProductCategoryDeleteOutput> deleteListeCoursesHandler;

    public ProductCategoryCommandProcessor(ICommandHandler<ProductCategoryCreateCommand, ProductCategoryCreateOutput> createListeCoursesHandler, ICommandHandler<ProductCategoryDeleteCommand, ProductCategoryDeleteOutput> deleteListeCoursesHandler) {
        this.createListeCoursesHandler = createListeCoursesHandler;
        this.deleteListeCoursesHandler = deleteListeCoursesHandler;
    }

    public ProductCategoryCreateOutput create(ProductCategoryCreateCommand command) {
        return createListeCoursesHandler.handle(command);
    }

    public ProductCategoryDeleteOutput delete(ProductCategoryDeleteCommand command) {
        return deleteListeCoursesHandler.handle(command);
    }
}
