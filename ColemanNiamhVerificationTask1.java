import org.junit.Test;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RateTest {

    //***********
    //RATES CONSTRUCTOR TESTS
    //***********

    //Test Case #1
    //Testing an invalid carParkKind
    @Test(expected = IllegalArgumentException.class)
    public void testOne() throws IllegalArgumentException {
        CarParkKind kind = WRONGTYPE;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(12,1));
        reducedPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #2
    //normalRate must not be < 0
    @Test(expected = IllegalArgumentException.class)
    public void testTwo() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(-1);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(12,1));
        reducedPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #3
    //normalRate must not be < reducedRate
    @Test(expected = IllegalArgumentException.class)
    public void testThree() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(0);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(12,1));
        reducedPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #4
    //reducedRate must not be < 0
    @Test(expected = IllegalArgumentException.class)
    public void testFour() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(-1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(12,1));
        reducedPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #5
    //reducedRate must not be > normalRate
    @Test(expected = IllegalArgumentException.class)
    public void testFive() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(12,1));
        reducedPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #6
    //reducedPeriods.startHour must be < reducedPeriods.endHour
    @Test(expected = IllegalArgumentException.class)
    public void testSix() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(3,2));
        reducedPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #7
    //reducedPeriods must not overlap with normalPeriods
    @Test(expected = IllegalArgumentException.class)
    public void testSeven() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12,2));
        normalPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #8
    //reducedPeriods.startHour must be >= 0
    @Test(expected = IllegalArgumentException.class)
    public void testEight() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(-1,2));
        normalPeriods.add(new Period(3,4));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #9
    //reducedPeriods.endHour must be >= 0
    @Test(expected = IllegalArgumentException.class)
    public void testNine() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(2,-1));
        normalPeriods.add(new Period(3,4));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #10
    //reducedPeriods.startHour is > 24 && reducedPeriods.startHour is > reducedPeriods.endHour
    @Test(expected = IllegalArgumentException.class)
    public void testTen() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(25,24));
        normalPeriods.add(new Period(3,4));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #11
    //normalPeriods.startHour is > normalPeriods.endHour
    @Test(expected = IllegalArgumentException.class)
    public void testEleven() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1,2));
        normalPeriods.add(new Period(3,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #12
    //There must be no overlap between normalPeriods and reducedPeriods
    @Test(expected = IllegalArgumentException.class)
    public void testTwelve() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1,2));
        normalPeriods.add(new Period(12,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #13
    //normalPeriods.startHour must be >= 0
    @Test(expected = IllegalArgumentException.class)
    public void testThirteen() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(3,4));
        normalPeriods.add(new Period(-1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #14
    //normalPeriods.startHour must be >= 0 && normalPeriods.startHour must be >= 24
    @Test(expected = IllegalArgumentException.class)
    public void testFourteen() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(3,4));
        normalPeriods.add(new Period(25,24));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #15
    //normalPeriods.startHour must be < normalPeriods.endHour && normalPeriods.endHour must be >= 0
    @Test(expected = IllegalArgumentException.class)
    public void testFifteen() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(3,4));
        normalPeriods.add(new Period(2, -1));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #16
    //carParkKind is NULL
    @Test(expected = IllegalArgumentException.class)
    public void testSixteen() throws IllegalArgumentException {
        CarParkKind kind = null;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12,1));
        normalPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #17
    //normalRate is NULL
    @Test(expected = IllegalArgumentException.class)
    public void testSeventeen() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = null;
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12,1));
        normalPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #18
    //reducedRate is NULL
    @Test(expected = IllegalArgumentException.class)
    public void testEighteen() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = null;
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12,1));
        normalPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #19
    //reducedPeriods is NULL
    @Test(expected = IllegalArgumentException.class)
    public void testNineteen() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(null));
        normalPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //Test Case #20
    //normalPeriods is NULL
    @Test(expected = IllegalArgumentException.class)
    public void testTwenty() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1,2));
        normalPeriods.add(new Period(null));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
    }

    //***********
    //CALCULATE METHOD TESTS
    //***********

    //Test Case #21
    @Test
    public void testTwentyOne() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(0);
        BigDecimal reducedRate = new BigDecimal(0);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12,1));
        normalPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
        calc_result = newRate.Calculate(12,3);

        assertEquals((new BigDecimal(0)),calc_result);
    }

    //Test Case #22
    @Test
    public void testTwentyTwo() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(0);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12,1));
        normalPeriods.add(new Period(1,2));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
        calc_result = newRate.Calculate(12,3);

        assertEquals((new BigDecimal(1)),calc_result);
    }

    //Test Case #23
    @Test
    public void testTwentyThree() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(24,0));
        normalPeriods.add(new Period(3,4));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
        calc_result = newRate.Calculate(12,3);

        assertEquals((new BigDecimal(0)),calc_result);
    }

    //Test Case #24
    @Test
    public void testTwentyFour() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1,2));
        normalPeriods.add(new Period(12,1));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
        calc_result = newRate.Calculate(12,3);

        assertEquals((new BigDecimal(3)),calc_result);
    }

    //Test Case #25
    @Test
    public void testTwentyFive() throws IllegalArgumentException {
        CarParkKind kind = STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(3,4));
        normalPeriods.add(new Period(24,0));

        Rate newRate = new Rate(kind, normalRate, reducedRate,normalPeriods, reducedPeriods);
        calc_result = newRate.Calculate(12,3);

        assertEquals((new BigDecimal(0)),calc_result);
    }



}
