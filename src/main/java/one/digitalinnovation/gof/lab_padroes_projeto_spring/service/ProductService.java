package one.digitalinnovation.gof.lab_padroes_projeto_spring.service;

import one.digitalinnovation.gof.lab_padroes_projeto_spring.model.Product;
import one.digitalinnovation.gof.lab_padroes_projeto_spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing products.
 * <p>
 * Classe de serviço para gerenciar produtos.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /**
     * Retrieves all products.
     * <p>
     * Recupera todos os produtos.
     *
     * @return a list of products
     */
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    /**
     * Retrieves a product by its ID.
     * <p>
     * Recupera um produto pelo seu ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID, or null if not found
     */
    public Product getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Saves a new product.
     * <p>
     * Salva um novo produto.
     *
     * @param product the product to save
     * @return the saved product
     */
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    /**
     * Deletes a product by its ID.
     * <p>
     * Exclui um produto pelo seu ID.
     *
     * @param id the ID of the product to delete
     * @return a message indicating the result
     */
    public String deleteProduct(Long id) {
        repository.deleteById(id);
        return "Product removed !! " + id;
    }

    /**
     * Updates an existing product.
     * <p>
     * Atualiza um produto existente.
     *
     * @param product the product to update
     * @return the updated product, or null if the product was not found
     */
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            return repository.save(existingProduct);
        } else {
            return null;
        }
    }

    /**
     * Retrieves products with a price greater than or equal to the specified minimum price.
     * <p>
     * Recupera produtos com preço maior ou igual ao preço mínimo especificado.
     *
     * @param minPrice the minimum price
     * @return a list of products with price greater than or equal to minPrice
     */
    public List<Product> getProductsByMinPrice(double minPrice) {
        return repository.findAll().stream()
                .filter(product -> product.getPrice() >= minPrice)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the names of all products.
     * <p>
     * Recupera os nomes de todos os produtos.
     *
     * @return a list of product names
     */
    public List<String> getProductNames() {
        return repository.findAll().stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    /**
     * Calculates the average price of all products.
     * <p>
     * Calcula o preço médio de todos os produtos.
     *
     * @return the average price of products
     */
    public double getAveragePrice() {
        return repository.findAll().stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
    }

    /**
     * Retrieves the product with the highest price.
     * <p>
     * Recupera o produto com o maior preço.
     *
     * @return the product with the highest price
     */
    public Product getProductWithHighestPrice() {
        return repository.findAll().stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
    }


}