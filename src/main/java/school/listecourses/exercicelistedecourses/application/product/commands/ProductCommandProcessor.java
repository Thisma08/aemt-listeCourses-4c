package school.listecourses.exercicelistedecourses.application.product.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.product.commands.create.ProductCreateCommand;
import school.listecourses.exercicelistedecourses.application.product.commands.create.ProductCreateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class ProductCommandProcessor {
    private final ICommandHandler<ProductCreateCommand, ProductCreateOutput> createProductHandler;

    public ProductCommandProcessor(ICommandHandler<ProductCreateCommand, ProductCreateOutput> createProductHandler) {
        this.createProductHandler = createProductHandler;
    }

    public ProductCreateOutput create(ProductCreateCommand command) {
        return createProductHandler.handle(command);
    }
}
