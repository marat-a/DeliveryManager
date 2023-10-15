import java.util.Date;
import java.util.List;
import lombok.Data;
//Класс, содержащий заказы

@Data
public class Order {
    private Long id;
    private Date date, time;
    private List<Product> items;
    private String courier;
    private Customer customer;
    private String comment;
}