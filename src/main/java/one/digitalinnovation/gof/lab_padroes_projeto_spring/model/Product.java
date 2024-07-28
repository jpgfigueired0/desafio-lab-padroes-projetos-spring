package one.digitalinnovation.gof.lab_padroes_projeto_spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * Represents a product with a name and price.
 * <p>
 * Representa um produto com um nome e preço.
 */
@Entity
public class Product implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String name;
    @Getter
    private double price;

    public Product() {}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Clones the product object.
     * <p>
     * Clona o objeto do produto.
     *
     * @return a clone of the product object
     * @throws CloneNotSupportedException if the object's class does not support the Cloneable interface
     */
    @Override
    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
