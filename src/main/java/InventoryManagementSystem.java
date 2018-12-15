import java.util.List;

public interface InventoryManagementSystem {
    Integer checksum(List<String> boxIds);
    String commonIds(List<String> boxIds);
}
