import java.util.List;
import lombok.Data;

//Класс, содержащий покупателей
@Data
public class Customer {
    private Long id;
    private String name;
    private String phone, address;
    private List<Order> orders;
}