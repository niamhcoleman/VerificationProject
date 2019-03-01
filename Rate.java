import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.math.RoundingMode;

/**
 * Created by CM on 01/02/2018.
 */
public class Rate {
    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;
    private ArrayList<Period> reduced = new ArrayList<>();
    private ArrayList<Period> normal = new ArrayList<>();

    public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate, ArrayList<Period> reducedPeriods
            , ArrayList<Period> normalPeriods) {
        if (reducedPeriods == null || normalPeriods == null) {
            throw new IllegalArgumentException("periods cannot be null");
        }
        if (normalRate == null || reducedRate == null) {
            throw new IllegalArgumentException("The rates cannot be null");
        }
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A rate cannot be negative");
        }
        if (normalRate.compareTo(reducedRate) <= 0) {
            throw new IllegalArgumentException("The normal rate cannot be less or equal to the reduced rate");
        }
        if (!isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)) {
            throw new IllegalArgumentException("The periods are not valid individually");
        }
        if (!isValidPeriods(reducedPeriods, normalPeriods)) {
            throw new IllegalArgumentException("The periods overlaps");
        }
        this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;
    }

    /**
     * Checks if two collections of periods are valid together
     *
     * @param periods1
     * @param periods2
     * @return true if the two collections of periods are valid together
     */
    private boolean isValidPeriods(ArrayList<Period> periods1, ArrayList<Period> periods2) {
        Boolean isValid = true;
        int i = 0;
        while (i < periods1.size() && isValid) {
            isValid = isValidPeriod(periods1.get(i), periods2);
            i++;
        }
        return isValid;
    }

    /**
     * checks if a collection of periods is valid
     *
     * @param list the collection of periods to check
     * @return true if the periods do not overlap
     */
    private Boolean isValidPeriods(ArrayList<Period> list) {
        Boolean isValid = true;
        if (list.size() >= 2) {
            Period secondPeriod;
            int i = 0;
            int lastIndex = list.size() - 1;
            while (i < lastIndex && isValid) {
                isValid = isValidPeriod(list.get(i), ((List<Period>) list).subList(i + 1, lastIndex + 1));
                i++;
            }
        }
        return isValid;
    }

    /**
     * checks if a period is a valid addition to a collection of periods
     *
     * @param period the Period addition
     * @param list   the collection of periods to check
     * @return true if the period does not overlap in the collecton of periods
     */
    private Boolean isValidPeriod(Period period, List<Period> list) {
        Boolean isValid = true;
        int i = 0;
        while (i < list.size() && isValid) {
            isValid = !period.overlaps(list.get(i));
            i++;
        }
        return isValid;
    }

    /*
    this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;*/

    public BigDecimal calculate(Period periodStay) {

        int normalRateHours = periodStay.occurences(normal);
        int reducedRateHours = periodStay.occurences(reduced);

        BigDecimal total = (this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));

        //Visitor rates:
        if (kind == CarParkKind.VISITOR) {
            BigDecimal VisitorFreeUntil = new BigDecimal(8);

            //if total is > 8 OR total is equal to 8
            if ((total.compareTo(VisitorFreeUntil) == 1) || (total.compareTo(VisitorFreeUntil) == 0))
            {
                total = total.subtract(VisitorFreeUntil); //take away the free first 8 hours
                total = total.divide(new BigDecimal(2)); //divide the rest by 2 to get fify percent discount on remainder
            }
            else
            {
                total = new BigDecimal(0);
            }
        }

        //Management rates:
        if (kind == CarParkKind.MANAGEMENT)
        {
            BigDecimal ManagementMinCharge = new BigDecimal(3);

            //if total is less than min charge or equal to min charge, change total to min charge
            if ((total.compareTo(ManagementMinCharge) < 0) || (total.compareTo(ManagementMinCharge) == 0)) {
                total = new BigDecimal(3);
            }
        }

        //Student rates:
        if (kind == CarParkKind.STUDENT)
        {
            BigDecimal freeUntil = new BigDecimal(5.5);
            //if total is > 5.50, apply a 25% discount
            if(!(total.compareTo(freeUntil) < 0))
            {
                total = total.subtract(total.multiply(new BigDecimal(.25)));
            }
        }

        //Staff rates
        if (kind == CarParkKind.STAFF)
        {
            BigDecimal maxPayable = new BigDecimal(16); //max payable is 16 euro per day

            if (!(total.compareTo(maxPayable) < 0)) //if total is > 16
            {
                total = maxPayable;
            }

        }
        return total.setScale(0, RoundingMode.CEILING);
    }
}
