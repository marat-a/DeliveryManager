import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
//Класс, содержащий позиции товаров
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}