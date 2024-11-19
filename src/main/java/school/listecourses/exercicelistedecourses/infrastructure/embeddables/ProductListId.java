package school.listecourses.exercicelistedecourses.infrastructure.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class ProductListId implements Serializable {
    private Long productId;
    private Long listId;

    public ProductListId(Long productId, Long listId) {
        this.productId = productId;
        this.listId = listId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductListId that = (ProductListId) o;
        return Objects.equals(productId, that.productId) && Objects.equals(listId, that.listId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, listId);
    }
}
