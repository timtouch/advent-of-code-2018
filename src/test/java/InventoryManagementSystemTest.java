import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InventoryManagementSystemTest
{
    public static InventoryManagementSystem inventoryManagementSystem;

    @BeforeClass
    public static void init()
    {
        inventoryManagementSystem = new InventoryManagementSystemImpl();
    }

    @Test
    public void testChecksum()
    {
        List<String> boxIds = Arrays.asList("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab");
        Integer result = inventoryManagementSystem.checksum(boxIds);

        assertThat(result, is(12));
    }

    @Test
    public void testCommonIds()
    {
        List<String> boxIds = Arrays.asList("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz");
        String result = inventoryManagementSystem.commonIds(boxIds);

        assertThat(result, is("fgij"));
    }
}