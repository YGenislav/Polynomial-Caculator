import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Math.*;
import Math.Integer;
public class MonomialTest {

    @Test
    void testAdd() {
        Monomial m1 = new Monomial(new Integer(2), 3);
        Monomial m2 = new Monomial(new Integer(3), 3);
        Monomial expected = new Monomial(new Integer(5), 3);
        assertEquals(expected.toString(), m1.add(m2).toString());

        Monomial m3 = new Monomial(new Integer(2), 3);
        Monomial m4 = new Monomial(new Integer(3), 4);
        assertNull(m3.add(m4));
    }

    @Test
    void testMul() {
        Monomial m1 = new Monomial(new Integer(2), 3);
        Monomial m2 = new Monomial(new Integer(3), 4);
        Monomial expected = new Monomial(new Integer(6), 7);
        assertEquals(expected.toString(), m1.mul(m2).toString());
    }

    @Test
    void testEvaluate() {
        Monomial m = new Monomial(new Integer(2), 3);
        Scalar s = new Rational(1, 2);
        Scalar expected = new Rational(1, 4);
        assertEquals(expected.toString(), m.evaluate(s).toString());
    }

    @Test
    void testDerivative() {
        Monomial m = new Monomial(new Integer(2), 3);
        Monomial expected = new Monomial(new Integer(6), 2);
        assertEquals(expected.toString(), m.derivative().toString());
    }

    @Test
    void testSign() {
        Monomial m = new Monomial(new Integer(-2), 3);
        assertEquals(-1, m.sign());

        Monomial m2 = new Monomial(new Integer(0), 3);
        assertEquals(0, m2.sign());

        Monomial m3 = new Monomial(new Integer(2), 3);
        assertEquals(1, m3.sign());
    }
}
