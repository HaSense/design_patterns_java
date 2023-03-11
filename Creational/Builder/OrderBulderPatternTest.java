
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
        items.add("버거");
        items.add("소고기 패티");
        items.add("양상추");
        items.add("토마토 조각");

        Order order1 = new Order.OrderBuilder(1, "홍길동", "010-1234-5678")
                .setDeliveryAddress("서울시 종로구 8282")
                .setItems(items)
                .setPaid(true)
                .build();

        System.out.println("주문 ID : " + order1.getOrderId());
        System.out.println("고객 이름 : " + order1.getCustomerName());
        System.out.println("고객 주소 : " + order1.getDeliveryAddress());
        System.out.println("고객 전화번호 : " + order1.getCustomerPhone());
        System.out.println("주문 내용 : " + order1.getItems());
        System.out.println("결재 여부: " + order1.isPaid());

    }
}

/*
결과

주문 ID : 1
고객 이름 : 홍길동
고객 주소 : 서울시 종로구 8282
고객 전화번호 : 010-1234-5678
주문 내용 : [버거, 소고기 패티, 양상추, 토마토 조각]
결재 여부: true

*/





