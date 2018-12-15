import lombok.extern.java.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log
public class ChronalCalibrationImpl implements ChronalCalibration
{

    public static String filePath = "src\\main\\resources\\input_day1";

    public static void main(String[] args)
    {
        ChronalCalibration chronalCalibration = new ChronalCalibrationImpl();
        try (Stream<String> stream = Files.lines(Paths.get(filePath)))
        {
            List<Integer> integers = stream.map(Integer::parseInt).collect(Collectors.toList());
            log.info("Sum of frequencies is: " + chronalCalibration.sumFrequency(integers).toString());
            log.info("Duplicate frequency is: " + chronalCalibration.duplicateFrequency(integers).toString());
        } catch (IOException e)
        {
            log.severe("IOException occurred when trying to access file: [" + filePath + "].");
            log.severe(e.getMessage());
        }
    }

    public Integer sumFrequency(List<Integer> integers)
    {
        return integers.stream().reduce(0, (sum, curr) -> sum + curr);
    }

    public Integer duplicateFrequency(List<Integer> integers)
    {
        Set<Integer> hitFrequencies = new HashSet<>();
        Integer currFreq = 0;
        int index = 0;
        while (hitFrequencies.add(currFreq))
        {
            currFreq += integers.get(index);
            index = (++index) % integers.size();
        }
        return currFreq;
    }


}
