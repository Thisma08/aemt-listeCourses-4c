package school.listecourses.exercicelistedecourses.application.shoppingList.commands.viewProducts;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductCategoryRepository;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductListRepository;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProduct;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProductCategory;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProductList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShoppingListViewProductsHandler {
    private final IProductListRepository productListRepository;
    private final IProductRepository productRepository;
    private final IProductCategoryRepository productCategoryRepository;

    public ShoppingListViewProductsHandler(IProductListRepository productListRepository, IProductRepository productRepository, IProductCategoryRepository productCategoryRepository) {
        this.productListRepository = productListRepository;
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductFlatOutput> handleFlat(long listId) {
        List<DbProductList> productListEntities = productListRepository.findByListId(listId);
        List<Long> productIds = productListEntities.stream()
                .map(pl -> pl.getId().getProductId())
                .collect(Collectors.toList());

        List<DbProduct> products = productRepository.findAllById(productIds);

        return products.stream()
                .map(p -> new ProductFlatOutput(p.getId(), p.getName(), p.getPrice()))
                .collect(Collectors.toList());
    }

    public List<ProductComplexOutput> handleComplex(long listId) {
        // Interroge productListRepository pour obtenir toutes les entités de type DbProductList associées au listId fourni
        List<DbProductList> productListEntities = productListRepository.findByListId(listId);

        // Utilisation d'un stream pour transformer la liste des entités DbProductList en une liste d'ID de produits.
        List<Long> productIds = productListEntities.stream()
                .map(pl -> pl.getId().getProductId())
                .collect(Collectors.toList());

        // Récupère toutes les entités DbProduct du productRepository en fonction de la liste des productIds obtenue à l’étape précédente
        List<DbProduct> products = productRepository.findAllById(productIds);

        // Liste des produits regroupée par CategoryId de chaque produit
        Map<Long, List<DbProduct>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(DbProduct::getCategoryId));

        System.out.println("Grouped Products by Category ID: " + groupedByCategory);

        // Liste des categoryIds uniques extraite des clés de la map groupedByCategory.
        List<Long> categoryIds = new ArrayList<>(groupedByCategory.keySet());

        // Ces ID sont utilisés pour récupérer les détails de la catégorie (DbProductCategory) dans le productCategoryRepository.
        List<DbProductCategory> categories = productCategoryRepository.findAllById(categoryIds);

        // Transformation de la liste des entités DbProductCategory en une Map<Long, String>, où La clé est l’ID de catégorie et la valeur est le nom de la catégorie.
        Map<Long, String> categoryNames = categories.stream()
                .collect(Collectors.toMap(DbProductCategory::getId, DbProductCategory::getName));

        System.out.println("Category Names: " + categoryNames);

        // Construction de l'output
        List<ProductComplexOutput> complexOutputs = new ArrayList<>();
        for(Map.Entry<Long, List<DbProduct>> entry : groupedByCategory.entrySet()) {
            Long categoryId = entry.getKey();
            String categoryName = categoryNames.get(categoryId);

            if(categoryName != null) {
                List<ProductFlatOutput> flatProducts = entry.getValue().stream()
                        .map(p -> new ProductFlatOutput(p.getId(), p.getName(), p.getPrice()))
                        .collect(Collectors.toList());

                System.out.println("Mapped Flat Products: " + flatProducts);

                complexOutputs.add(new ProductComplexOutput(categoryName, flatProducts));
            }
        }

        return complexOutputs;
    }
}
