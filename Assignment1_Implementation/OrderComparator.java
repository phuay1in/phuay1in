import java.util.Comparator;

public class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {

        if (o1.getDeadlineMinute() != o2.getDeadlineMinute())
            return o1.getDeadlineMinute() - o2.getDeadlineMinute();

        return o1.getArrivalMinute() - o2.getArrivalMinute();
    }
}