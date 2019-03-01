package cm;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Test;

public class RateTest {

    //*********
    //RATES CONSTRUCTOR TESTS
    //*********

    //Test Case #1
    //CarParkKind NULL test
    @Test(expected = IllegalArgumentException.class)
    public void testOne() throws IllegalArgumentException {

        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 2));
        normalPeriods.add(new Period(12, 13));


        Rate newRate = new Rate(null, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #2
    //normalRate NULL test
    @Test(expected = IllegalArgumentException.class)
    public void testTwo() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 2));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, null, reducedRate, reducedPeriods, normalPeriods);
    }

    //Test Case #3
    //reducedRate NULL test
    @Test(expected = IllegalArgumentException.class)
    public void testThree() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 2));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, normalRate, null, reducedPeriods, normalPeriods);

    }

    //Test Case #4
    //reducedPeriods NULL test
    @Test(expected = IllegalArgumentException.class)
    public void testFour() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal reducedRate = new BigDecimal(1);
        BigDecimal normalRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(1, 2));

        Rate newRate = new Rate(kind, normalRate, reducedRate, null, normalPeriods);

    }

    //Test Case #5
    //normalPeriods NULL test
    @Test(expected = IllegalArgumentException.class)
    public void testFive() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 2));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, null);

    }

    //Test Case #6
    //normalRate is < reducedRate
    @Test(expected = IllegalArgumentException.class)
    public void testSix() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 2));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #7
    //rate cannot be < 0
    @Test(expected = IllegalArgumentException.class)
    public void testSeven() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(-1);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 2));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #8
    //rate cannot be < 0
    @Test(expected = IllegalArgumentException.class)
    public void testEight() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(-1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 2));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #9
    //spec for project says rates may be equal if greater than 0
    @Test()
    public void testNine() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 2));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #10
    //Periods must not overlap
    @Test(expected = IllegalArgumentException.class)
    public void testTen() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(11, 13));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #11
    //Periods must not overlap test 2 with multiple periods
    @Test(expected = IllegalArgumentException.class)
    public void testEleven() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(11, 12));
        reducedPeriods.add(new Period(12, 13));
        reducedPeriods.add(new Period(1, 3));
        normalPeriods.add(new Period(12, 13));
        normalPeriods.add(new Period(4, 5));
        normalPeriods.add(new Period(4, 5));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #12
    //Periods must not overlap test 3 with multiple periods
    @Test(expected = IllegalArgumentException.class)
    public void testTwelve() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(11, 12));
        normalPeriods.add(new Period(12, 13));
        normalPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(12, 13));
        reducedPeriods.add(new Period(2, 3));
        reducedPeriods.add(new Period(4, 5));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #13
    //reducedPeriods.startHour cannot be = reducedPeriods.endHour
    @Test(expected = IllegalArgumentException.class)
    public void testThirteen() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 1));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #14
    //normalPeriods.startHour cannot be = normalPeriods.endHour
    @Test(expected = IllegalArgumentException.class)
    public void testFourteen() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 2));
        normalPeriods.add(new Period(12, 12));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #15
    //reducedPeriods.startHour cannot be > reducedPeriods.endHour
    @Test(expected = IllegalArgumentException.class)
    public void testFifteen() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(2, 1));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #16
    //reducedPeriods.endHour cannot be > 24
    @Test(expected = IllegalArgumentException.class)
    public void testSixteen() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(24, 25));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #17
    //reducedPeriods.starthour cannot be > 24
    @Test(expected = IllegalArgumentException.class)
    public void testSeventeen() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(25, 24));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #18
    //normalPeriods.startHour cannot be > normalPeriods.endHour
    @Test(expected = IllegalArgumentException.class)
    public void testEighteen() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 13));
        normalPeriods.add(new Period(2, 1));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #19
    //normalPeriods.endHour cannot be > 24
    @Test(expected = IllegalArgumentException.class)
    public void testNineteen() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 2));
        normalPeriods.add(new Period(24, 25));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //Test Case #20
    //normalPeriods.starthour cannot be > 24
    @Test(expected = IllegalArgumentException.class)
    public void testTwenty() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 2));
        normalPeriods.add(new Period(25, 24));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    //*********
    //calculate METHOD TESTS
    //*********

    //Test Case #21
    @Test
    public void testTwentyOne() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 5));
        reducedPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 13));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

        assertEquals(new BigDecimal((3)), newRate.calculate(new Period(11, 14)));

    }

    //Test Case #22
    @Test(expected = IllegalArgumentException.class)
    public void testTwentyTwo() {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(100);
        BigDecimal reducedRate = new BigDecimal(50);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 5));
        reducedPeriods.add(new Period(5, 7));
        reducedPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(12, 13));
        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(15, 16));
        normalPeriods.add(new Period(1, 5));

        Rate newRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

        assertEquals(new BigDecimal((0)), newRate.calculate(new Period(1, 5)));

    }
}

