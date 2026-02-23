public class Order {

    private String orderId;
    private int arrivalMinute;
    private int deadlineMinute;

    public Order(String orderId, int deadlineMinute) {
        if (orderId == null)
            throw new IllegalArgumentException("Illegal Argument");
        this.orderId = orderId;
        this.deadlineMinute = deadlineMinute;
    }

    public String getId() {
        return orderId;
    }

    public int getArrivalMinute() {
        return arrivalMinute;
    }

    public void setArrivalMinute(int arrivalMinute) {
        this.arrivalMinute = arrivalMinute;
    }

    public int getDeadlineMinute() {
        return deadlineMinute;
    }
}