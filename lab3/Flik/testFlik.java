import org.junit.Test;
import static org.junit.Assert.*;

public class testFlik {
    @Test
    public void testIsSameNumber(){
        assertTrue(Flik.isSameNumber(0,0));
        assertTrue(Flik.isSameNumber(5,5));
        assertTrue(Flik.isSameNumber(-10,-10));
        assertTrue(Flik.isSameNumber(200,200));
    }
}
