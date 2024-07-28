package one.digitalinnovation.gof.lab_padroes_projeto_spring.controller;

import one.digitalinnovation.gof.lab_padroes_projeto_spring.model.Product;
import one.digitalinnovation.gof.lab_padroes_projeto_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing products.
 * <p>
 * Controlador REST para gerenciar produtos.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    /**
     * Retrieves all products.
     * <p>
     * Recupera todos os produtos.
     *
     * @return a list of products
     */
    @GetMapping
    public List<Product> findAll() {
        return service.getAllProducts();
    }

    /**
     * Retrieves a product by its ID.
     * <p>
     * Recupera um produto pelo seu ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID
     */
    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    /**
     * Creates a new product.
     * <p>
     * Cria um novo produto.
     *
     * @param product the product to create
     * @return the created product
     */
    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    /**
     * Updates an existing product.
     * <p>
     * Atualiza um produto existente.
     *
     * @param product the product to update
     * @return the updated product
     */
    @PutMapping
    public Product update(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    /**
     * Deletes a product by its ID.
     * <p>
     * Exclui um produto pelo seu ID.
     *
     * @param id the ID of the product
     * @return a message indicating the result
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteProduct(id);
    }

    /**
     * Retrieves products with a price greater than or equal to the specified minimum price.
     * <p>
     * Recupera produtos com preço maior ou igual ao preço mínimo especificado.
     *
     * @param minPrice the minimum price
     * @return a list of products with price greater than or equal to minPrice
     */
    @GetMapping("/price/{minPrice}")
    public List<Product> getProductsByMinPrice(@PathVariable double minPrice) {
        return service.getProductsByMinPrice(minPrice);
    }

    /**
     * Retrieves the names of all products.
     * <p>
     * Recupera os nomes de todos os produtos.
     *
     * @return a list of product names
     */
    @GetMapping("/names")
    public List<String> getProductNames() {
        return service.getProductNames();
    }

    /**
     * Calculates the average price of all products.
     * <p>
     * Calcula o preço médio de todos os produtos.
     *
     * @return the average price of products
     */
    @GetMapping("/average-price")
    public double getAveragePrice() {
        return service.getAveragePrice();
    }

    /**
     * Retrieves the product with the highest price.
     * <p>
     * Recupera o produto com o maior preço.
     *
     * @return the product with the highest price
     */
    @GetMapping("/highest-price")
    public Product getProductWithHighestPrice() {
        return service.getProductWithHighestPrice();
    }

}