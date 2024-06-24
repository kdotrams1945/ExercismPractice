package Armstrong;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongCheckTest {

    @Test
    public void testArmstrongCheck() {
        ArmstrongCheck armstrongCheck = new ArmstrongCheck();
        for (int i =0; i < 10; i++)
        {
            assertTrue(armstrongCheck.isArmstrong(i));
        }
    }
    @Test
    public void check9() {
        ArmstrongCheck armstrongCheck = new ArmstrongCheck();
        assertTrue(armstrongCheck.isArmstrong(9));
        assertFalse(armstrongCheck.isArmstrong(10));
    }

    @Test
    public void check153() {
        ArmstrongCheck armstrongCheck = new ArmstrongCheck();
        assertTrue(armstrongCheck.isArmstrong(153));
        assertFalse(armstrongCheck.isArmstrong(154));
    }
    @Test
    public void checkDigitSplit() {
        ArmstrongCheck armstrongCheck = new ArmstrongCheck();
        List<Integer> d1 = armstrongCheck.getDigitArray(1);
        assertEquals(1, d1.size());
        assertTrue(d1.contains(1));

    }
    @Test
    public void checkDigitSplit4() {
        ArmstrongCheck armstrongCheck = new ArmstrongCheck();
        List<Integer> d1 = armstrongCheck.getDigitArray(4591);
        assertEquals(4, d1.size());
        assertEquals(d1.get(0),4);
        assertEquals(d1.get(1),5);
        assertEquals(d1.get(2),9);
        assertEquals(d1.get(3),1);

    }
}