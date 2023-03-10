
import java.util.ArrayList;
import java.util.List;

class Order
{
    private int orderId;
    private String customerName;
    private String customerPhone;
    private String deliveryAddress;
    private List<String> items;
    private boolean isPaid;

    //public OrderBuilder(int orderId, String customerName, String customerPhone, String deliveryAddress, List<String> items, boolean isPaid) {
    public Order(OrderBuilder builder) {
        this.orderId = builder.orderId;
        this.customerName = builder.customerName;
        this.customerPhone = builder.customerPhone;
        this.deliveryAddress = builder.deliveryAddress;
        this.items = builder.items;
        this.isPaid = builder.isPaid;
    }

    public static class OrderBuilder
    {
        private int orderId;
        private String customerName;
        private String customerPhone;
        private String deliveryAddress;
        private List<String> items;
        private boolean isPaid;

        public OrderBuilder(int orderId, String customerName, String customerPhone) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.customerPhone = customerPhone;
        }

        public OrderBuilder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public OrderBuilder setItems(List<String> items) {
            this.items = items;
            return this;
        }

        public OrderBuilder setPaid(boolean paid) {
            isPaid = paid;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }//end of OrderBuilder

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public List<String> getItems() {
        return items;
    }

    public boolean isPaid() {
        return isPaid;
    }
}

public class OrderBulderPatternTest {
    public static void main(String[] args) {
        List<String> items = new ArrayList<String>();
        items.add("??????");
        items.add("????????? ??????");
        items.add("?????????");
        items.add("????????? ??????");

        Order order1 = new Order.OrderBuilder(1, "?????????", "010-1234-5678")
                .setDeliveryAddress("????????? ????????? 8282")
                .setItems(items)
                .setPaid(true)
                .build();

        System.out.println("?????? ID : " + order1.getOrderId());
        System.out.println("?????? ?????? : " + order1.getCustomerName());
        System.out.println("?????? ?????? : " + order1.getDeliveryAddress());
        System.out.println("?????? ???????????? : " + order1.getCustomerPhone());
        System.out.println("?????? ?????? : " + order1.getItems());
        System.out.println("?????? ??????: " + order1.isPaid());

    }
}

/*
??????

?????? ID : 1
?????? ?????? : ?????????
?????? ?????? : ????????? ????????? 8282
?????? ???????????? : 010-1234-5678
?????? ?????? : [??????, ????????? ??????, ?????????, ????????? ??????]
?????? ??????: true

*/





