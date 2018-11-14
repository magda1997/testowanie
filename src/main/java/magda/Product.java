package magda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// HIBERNATE
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // autoincrement
    private Integer id;
    private String name;
    private BigDecimal price;
    private String category;
    private String countryOrigin;
    private LocalDate expiration_date;
    private String searchTags;
    private String description;

    public Product(String name, BigDecimal price, String category, String country, LocalDate expiration_date, String searchTags, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.countryOrigin = country;
        this.expiration_date = expiration_date;
        this.searchTags = searchTags;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getSearchTags() {
        return searchTags;
    }

    public void setSearchTags(String searchTags) {
        this.searchTags = searchTags;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
