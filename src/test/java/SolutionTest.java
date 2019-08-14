import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int input1;
    private int input2;
    private int expected;
    private Solution soln = new Solution2();

    public SolutionTest(int input1, int input2, int expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {4,3,1},
                {10,3,3},
                {7,-3,-2},
                {-2147483648, 2, -1073741824},
                {-2147483648, -3, 715827882},
                {1004958205, -2137325331, 0}
        });
    }

    @Test
    public void testDivide() {
        assertEquals(expected, soln.divide(input1,input2));
    }

}