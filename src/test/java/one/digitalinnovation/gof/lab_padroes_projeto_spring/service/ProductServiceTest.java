package one.digitalinnovation.gof.lab_padroes_projeto_spring.service;

import one.digitalinnovation.gof.lab_padroes_projeto_spring.model.Product;
import one.digitalinnovation.gof.lab_padroes_projeto_spring.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        product1 = new Product("Product 1", 50.0);
        product2 = new Product("Product 2", 100.0);
        product3 = new Product("Product 3", 150.0);
    }

    @Test
    public void testGetProductsByMinPrice() {
        when(repository.findAll()).thenReturn(Arrays.asList(product1, product2, product3));

        List<Product> result = service.getProductsByMinPrice(100.0);

        assertEquals(2, result.size());
        assertEquals("Product 2", result.get(0).getName());
        assertEquals("Product 3", result.get(1).getName());
    }

    @Test
    public void testGetProductNames() {
        when(repository.findAll()).thenReturn(Arrays.asList(product1, product2, product3));

        List<String> result = service.getProductNames();

        assertEquals(3, result.size());
        assertEquals("Product 1", result.get(0));
        assertEquals("Product 2", result.get(1));
        assertEquals("Product 3", result.get(2));
    }

    @Test
    public void testGetAveragePrice() {
        when(repository.findAll()).thenReturn(Arrays.asList(product1, product2, product3));

        double result = service.getAveragePrice();

        assertEquals(100.0, result);
    }

    @Test
    public void testGetProductWithHighestPrice() {
        when(repository.findAll()).thenReturn(Arrays.asList(product1, product2, product3));

        Product result = service.getProductWithHighestPrice();

        assertEquals("Product 3", result.getName());
        assertEquals(150.0, result.getPrice());
    }
}
