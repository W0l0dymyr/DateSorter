package sample;

import java.time.LocalDate;
import java.util.*;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
 * package sample;
 * <p>
 * import java.time.LocalDate;
 * import java.util.Collection;
 * import java.util.List;
 * <p>
 * /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        //separating months into 2 lists: with "r" and without "r"
        List<LocalDate> datesWithR = new ArrayList<>();
        List<LocalDate> datesWithoutR = new ArrayList<>();
        for (LocalDate date : unsortedDates) {
            if (date.getMonth().toString().contains("R")) {
                datesWithR.add(date);
            } else {
                datesWithoutR.add(date);
            }
        }

        //sorting months with 'r' in ascending order
        datesWithR.sort(Comparator.naturalOrder());
        //sorting months without 'r' in descending order
        datesWithoutR.sort(Comparator.reverseOrder());

        //merging lists into one
        Collection<LocalDate> sortedDates = new LinkedList<>(datesWithR);
        sortedDates.addAll(datesWithoutR);

        return sortedDates;
    }
}