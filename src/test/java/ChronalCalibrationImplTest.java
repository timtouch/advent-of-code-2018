import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChronalCalibrationImplTest
{

    private static ChronalCalibration chronalCalibration;

    @BeforeClass
    public static void init()
    {
        chronalCalibration = new ChronalCalibrationImpl();
    }

    @Test
    public void testDuplicateFrequencies1()
    {
        Integer result = chronalCalibration.duplicateFrequency(new ArrayList<>(Arrays.asList(1, -1)));
        assertThat(result, is(0));
    }

    @Test
    public void testDuplicateFrequencies2()
    {
        Integer result = chronalCalibration.duplicateFrequency(new ArrayList<>(Arrays.asList(3, 3, 4, -2, -4)));
        assertThat(result, is(10));
    }

    @Test
    public void testDuplicateFrequencies3()
    {
        Integer result = chronalCalibration.duplicateFrequency(new ArrayList<>(Arrays.asList(-6, 3, 8, 5, -6)));
        assertThat(result, is(5));
    }

    @Test
    public void testDuplicateFrequencies4()
    {
        Integer result = chronalCalibration.duplicateFrequency(new ArrayList<>(Arrays.asList(7, 7, -2, -7, -4)));
        assertThat(result, is(14));
    }


}