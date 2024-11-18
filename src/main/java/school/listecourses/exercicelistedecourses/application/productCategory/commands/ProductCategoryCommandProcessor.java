package school.listecourses.exercicelistedecourses.application.productCategory.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.create.ProductCategoryCreateCommand;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.create.ProductCategoryCreateOutput;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.delete.ProductCategoryDeleteCommand;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.delete.ProductCategoryDeleteOutput;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.update.ProductCategoryUpdateCommand;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.update.ProductCategoryUpdateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class ProductCategoryCommandProcessor {
    private final ICommandHandler<ProductCategoryCreateCommand, ProductCategoryCreateOutput> createProductCategoryHandler;
    private final ICommandHandler<ProductCategoryUpdateCommand, ProductCategoryUpdateOutput> updateProductCategoryHandler;
    private final ICommandHandler<ProductCategoryDeleteCommand, ProductCategoryDeleteOutput> deleteProductCategoryHandler;

    public ProductCategoryCommandProcessor(ICommandHandler<ProductCategoryCreateCommand, ProductCategoryCreateOutput> createProductCategoryHandler, ICommandHandler<ProductCategoryUpdateCommand, ProductCategoryUpdateOutput> updateProductCategoryHandler, ICommandHandler<ProductCategoryDeleteCommand, ProductCategoryDeleteOutput> deleteProductCategoryHandler) {
        this.createProductCategoryHandler = createProductCategoryHandler;
        this.updateProductCategoryHandler = updateProductCategoryHandler;
        this.deleteProductCategoryHandler = deleteProductCategoryHandler;
    }

    public ProductCategoryCreateOutput create(ProductCategoryCreateCommand command) {
        return createProductCategoryHandler.handle(command);
    }

    public ProductCategoryUpdateOutput update(ProductCategoryUpdateCommand command) {
        return updateProductCategoryHandler.handle(command);
    }

    public ProductCategoryDeleteOutput delete(ProductCategoryDeleteCommand command) {
        return deleteProductCategoryHandler.handle(command);
    }
}
