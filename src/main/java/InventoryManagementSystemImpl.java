import lombok.extern.java.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log
public class InventoryManagementSystemImpl implements InventoryManagementSystem
{
    public static String filePath = "src\\main\\resources\\input_day2";

    public static void main(String[] args)
    {
        InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystemImpl();
        try (Stream<String> stream = Files.lines(Paths.get(filePath)))
        {
//            int result = inventoryManagementSystem.checksum(stream.collect(Collectors.toList()));
//            log.info("Checksum is: " + result);
            String commonIds = inventoryManagementSystem.commonIds(stream.collect(Collectors.toList()));
            log.info("CommonId is: " + commonIds);
        } catch (IOException e)
        {
            log.severe("IOException occurred when trying to access file: [" + filePath + "].");
            log.severe(e.getMessage());
        }
    }

    @Override
    public Integer checksum(List<String> boxIds)
    {
        int twoCount = 0;
        int threeCount = 0;
        for (String s : boxIds)
        {
            Map<Character, Integer> countMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if (!countMap.containsKey(c))
                {
                    countMap.put(c, 1);
                } else
                {
                    countMap.put(c, countMap.get(c) + 1);
                }
            }
            if (countMap.containsValue(3))
            {
                threeCount++;
            }
            if (countMap.containsValue(2))
            {
                twoCount++;
            }
        }
        return twoCount * threeCount;
    }

    @Override
    public String commonIds(List<String> boxIds)
    {
        StringBuilder commonLetters = new StringBuilder();
        String a = "";
        String b = "";

        for (int i = 0; i < boxIds.size(); i++)
        {
            for (int j = i + 1; j < boxIds.size(); j++)
            {
                if (numberOfDifferences(boxIds.get(i), boxIds.get(j)) == 1)
                {
                    a = boxIds.get(i);
                    b = boxIds.get(j);
                    break;
                }
            }
        }
        if (!a.isEmpty() && !b.isEmpty())
        {
            for (int i = 0; i < a.length(); i++)
            {
                if (a.charAt(i) == b.charAt(i))
                {
                    commonLetters.append(a.charAt(i));
                }
            }
        }
        return commonLetters.toString();
    }

    private int numberOfDifferences(String a, String b)
    {
        int num = 0;
        for (int i = 0; i < a.length(); i++)
        {
            if (a.charAt(i) != b.charAt(i))
            {
                num++;
            }
        }
        return num;
    }

}
