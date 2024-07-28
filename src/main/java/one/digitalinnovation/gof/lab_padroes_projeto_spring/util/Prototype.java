package one.digitalinnovation.gof.lab_padroes_projeto_spring.util;

import one.digitalinnovation.gof.lab_padroes_projeto_spring.model.Product;

/**
 * Prototype pattern implementation for Product cloning.
 * <p>
 * Implementação do padrão Prototype para clonagem de Product.
 */
public class Prototype {

    /**
     * Clones the given product.
     * <p>
     * Clona o produto fornecido.
     *
     * @param product the product to clone
     * @return the cloned product, or null if cloning is not supported
     */
    public static Product cloneProduct(Product product) {
        try {
            return product.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
