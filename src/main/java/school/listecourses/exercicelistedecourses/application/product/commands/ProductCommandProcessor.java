package school.listecourses.exercicelistedecourses.application.product.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.product.commands.create.ProductCreateCommand;
import school.listecourses.exercicelistedecourses.application.product.commands.create.ProductCreateOutput;
import school.listecourses.exercicelistedecourses.application.product.commands.update.ProductUpdateCommand;
import school.listecourses.exercicelistedecourses.application.product.commands.update.ProductUpdateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class ProductCommandProcessor {
    private final ICommandHandler<ProductCreateCommand, ProductCreateOutput> createProductHandler;
    private final ICommandHandler<ProductUpdateCommand, ProductUpdateOutput> updateProductHandler;


    public ProductCommandProcessor(ICommandHandler<ProductCreateCommand, ProductCreateOutput> createProductHandler, ICommandHandler<ProductUpdateCommand, ProductUpdateOutput> updateProductHandler) {
        this.createProductHandler = createProductHandler;
        this.updateProductHandler = updateProductHandler;
    }

    public ProductCreateOutput create(ProductCreateCommand command) {
        return createProductHandler.handle(command);
    }

    public ProductUpdateOutput update(ProductUpdateCommand command) {
        return updateProductHandler.handle(command);
    }
}
