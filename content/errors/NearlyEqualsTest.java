import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Demonstrates a good method for comparing floating-point values
 * using an epsilon. Run via JUnit 4
 *
 * From http://floating-point-gui.de
 *
 * @author Michael Borgwardt
 */
public class NearlyEqualsTest
{
    public static boolean nearlyEqual(float a, float b)
    {
        final float epsilon = 0.000001f;
        final float absA = Math.abs(a);
        final float absB = Math.abs(b);
        final float diff = Math.abs(a-b);

        if (a*b==0) { // a or b or both are zero
            // relative error is not meaningful here
            return diff < Float.MIN_VALUE / epsilon;
        } else { // use relative error
            return diff / (absA+absB) < epsilon;
        }
    }

    /** Regular large numbers - generally not problematic */
    @Test public void big()
    {
        assertTrue(nearlyEqual(1000000f, 1000001f));
        assertTrue(nearlyEqual(1000001f, 1000000f));
        assertFalse(nearlyEqual(10000f, 10001f));
        assertFalse(nearlyEqual(10001f, 10000f));
    }

    /** Negative large numbers */
    @Test public void bigNeg()
    {
        assertTrue(nearlyEqual(-1000000f, -1000001f));
        assertTrue(nearlyEqual(-1000001f, -1000000f));
        assertFalse(nearlyEqual(-10000f, -10001f));
        assertFalse(nearlyEqual(-10001f, -10000f));
    }

    /** Numbers around 1 */
    @Test public void mid()
    {
        assertTrue(nearlyEqual(1.0000001f, 1.0000002f));
        assertTrue(nearlyEqual(1.0000002f, 1.0000001f));
        assertFalse(nearlyEqual(1.0002f, 1.0001f));
        assertFalse(nearlyEqual(1.0001f, 1.0002f));
    }

    /** Numbers around -1 */
    @Test public void midNeg()
    {
        assertTrue(nearlyEqual(-1.000001f, -1.000002f));
        assertTrue(nearlyEqual(-1.000002f, -1.000001f));
        assertFalse(nearlyEqual(-1.0001f, -1.0002f));
        assertFalse(nearlyEqual(-1.0002f, -1.0001f));
    }

    /** Numbers between 1 and 0 */
    @Test public void small()
    {
        assertTrue(nearlyEqual(0.000000001000001f, 0.000000001000002f));
        assertTrue(nearlyEqual(0.000000001000002f, 0.000000001000001f));
        assertFalse(nearlyEqual(0.000000000001002f, 0.000000000001001f));
        assertFalse(nearlyEqual(0.000000000001001f, 0.000000000001002f));
    }

    /** Numbers between -1 and 0 */
    @Test public void smallNeg()
    {
        assertTrue(nearlyEqual(-0.000000001000001f, -0.000000001000002f));
        assertTrue(nearlyEqual(-0.000000001000002f, -0.000000001000001f));
        assertFalse(nearlyEqual(-0.000000000001002f, -0.000000000001001f));
        assertFalse(nearlyEqual(-0.000000000001001f, -0.000000000001002f));
    }

    /** Comparisons involving zero */
    @Test public void zero()
    {
        assertTrue(nearlyEqual(0.0f, 0.0f));
        assertFalse(nearlyEqual(0.00000001f, 0.0f));
        assertFalse(nearlyEqual(0.0f, 0.00000001f));
    }

    /** Comparisons of numbers on opposite sides of 0 */
    @Test public void opposite()
    {
        assertFalse(nearlyEqual(1.000000001f, -1.0f));
        assertFalse(nearlyEqual(-1.0f, 1.000000001f));
        assertFalse(nearlyEqual(-1.000000001f, 1.0f));
        assertFalse(nearlyEqual(1.0f, -1.000000001f));
        assertTrue(nearlyEqual(10000f*Float.MIN_VALUE, -10000f*Float.MIN_VALUE));
    }

    /**
     * The really tricky part - comparisons of numbers
     * very close to zero.
     */
    @Test public void ulp()
    {
        assertTrue(nearlyEqual(Float.MIN_VALUE, -Float.MIN_VALUE));
        assertTrue(nearlyEqual(-Float.MIN_VALUE, Float.MIN_VALUE));
        assertTrue(nearlyEqual(Float.MIN_VALUE, 0));
        assertTrue(nearlyEqual(0, Float.MIN_VALUE));
        assertTrue(nearlyEqual(-Float.MIN_VALUE, 0));
        assertTrue(nearlyEqual(0, -Float.MIN_VALUE));

        assertFalse(nearlyEqual(0.000000001f, -Float.MIN_VALUE));
        assertFalse(nearlyEqual(0.000000001f, Float.MIN_VALUE));
        assertFalse(nearlyEqual(Float.MIN_VALUE, 0.000000001f));
        assertFalse(nearlyEqual(-Float.MIN_VALUE, 0.000000001f));

        assertFalse(nearlyEqual(1e20f*Float.MIN_VALUE, 0.0f));
        assertFalse(nearlyEqual(0.0f, 1e20f*Float.MIN_VALUE));
        assertFalse(nearlyEqual(1e20f*Float.MIN_VALUE, -1e20f*Float.MIN_VALUE));
    }

}
