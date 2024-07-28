package one.digitalinnovation.gof.lab_padroes_projeto_spring.util;

import one.digitalinnovation.gof.lab_padroes_projeto_spring.model.Product;

/**
 * Factory method for creating Product instances.
 * <p>
 * Método de fábrica para criar instâncias de Product.
 */
public class FactoryMethod {

    /**
     * Creates a new product with the specified name and price.
     * <p>
     * Cria um novo produto com o nome e preço especificados.
     *
     * @param name  the name of the product
     * @param price the price of the product
     * @return the created product
     */
    public static Product createProduct(String name, double price) {
        return new Product(name, price);
    }
}