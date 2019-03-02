import java.math.BigDecimal;
import java.math.RoundingMode;

interface NewCharge {

    BigDecimal calculate(BigDecimal rate);

}

class VisitorRate implements NewCharge {

    @Override
    public BigDecimal calculate(BigDecimal rate) {
        BigDecimal VisitorFreeUntil = new BigDecimal(8);

        //if rate is > 8 OR rate is equal to 8
        if ((rate.compareTo(VisitorFreeUntil) == 1) || (rate.compareTo(VisitorFreeUntil) == 0))
        {
            rate = rate.subtract(VisitorFreeUntil); //take away the free first 8 hours
            rate = rate.divide(new BigDecimal(2)); //divide the rest by 2 to get fify percent discount on remainder
        }
        else
        {
            rate = new BigDecimal(0);
        }
        return rate.setScale(0, RoundingMode.CEILING);
    }
}

class ManagementRate implements NewCharge {

    @Override
    public BigDecimal calculate(BigDecimal rate) {

        BigDecimal ManagementMinCharge = new BigDecimal(3);

        //if rate is less than min charge or equal to min charge, change total to min charge
        if ((rate.compareTo(ManagementMinCharge) < 0) || (rate.compareTo(ManagementMinCharge) == 0)) {
            rate = new BigDecimal(3);
        }


        return rate.setScale(0, RoundingMode.CEILING);
    }
}

class StudentRate implements NewCharge {

    @Override
    public BigDecimal calculate(BigDecimal rate) {

        BigDecimal freeUntil = new BigDecimal(5.5);
        //if total is > 5.50, apply a 25% discount
        if(!(rate.compareTo(freeUntil) < 0))
        {
            rate = rate.subtract(rate.multiply(new BigDecimal(.25)));
        }

        return rate.setScale(0, RoundingMode.CEILING);
    }
}

class StaffRate implements NewCharge {

    @Override
    public BigDecimal calculate(BigDecimal rate) {

        BigDecimal maxPayable = new BigDecimal(16); //max payable is 16 euro per day

        if (!(rate.compareTo(maxPayable) < 0)) //if total is > 16
        {
            rate = maxPayable;
        }

        return rate.setScale(0, RoundingMode.CEILING);
    }
}