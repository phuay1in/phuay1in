public class WarehouseSimulation implements SimulationInterface {

    private MyPriorityQueue<Order> queue;
    private MyStack<Order> returnsStack;

    private Order[] orders;
    private int releaseIndex;

    private int currentMinute;
    private int totalArrived;
    private int totalShipped;
    private int totalLate;

    public WarehouseSimulation(Order[] orders) {
        if (orders == null)
            throw new IllegalArgumentException();

        this.orders = orders;
        this.queue = new MyPriorityQueue<>(new OrderComparator());
        this.returnsStack = new MyStack<>();
        this.releaseIndex = 0;
        this.currentMinute = 0;
    }

    @Override
    public void tick() {

        if (releaseIndex < orders.length) {
            Order order = orders[releaseIndex];
            order.setArrivalMinute(currentMinute);
            queue.enqueue(order);
            releaseIndex++;
            totalArrived++;
        }

        if (!queue.isEmpty()) {
            Order shipped = queue.dequeue();
            totalShipped++;

            if (currentMinute > shipped.getDeadlineMinute()) {
                returnsStack.push(shipped);
                totalLate++;
            }
        }

        currentMinute++;
    }

    @Override
    public boolean isFinished() {
        return releaseIndex >= orders.length && queue.isEmpty();
    }

    @Override
    public int getCurrentMinute() {
        return currentMinute;
    }

    @Override
    public int getTotalArrived() {
        return totalArrived;
    }

    @Override
    public int getTotalShipped() {
        return totalShipped;
    }

    @Override
    public int getTotalLate() {
        return totalLate;
    }
}