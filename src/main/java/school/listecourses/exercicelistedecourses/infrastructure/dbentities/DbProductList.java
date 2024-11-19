package school.listecourses.exercicelistedecourses.infrastructure.dbentities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.listecourses.exercicelistedecourses.infrastructure.embeddables.ProductListId;

@Entity
@Table(name = "products_lists")
@Data
@NoArgsConstructor
@Getter
@Setter
public class DbProductList {
    @EmbeddedId
    private ProductListId id;

    public DbProductList(long productId, long listId) {
        this.id = new ProductListId(productId, listId);
    }
}
