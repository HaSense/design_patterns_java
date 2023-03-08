/* 쇼핑몰 할인 정책을 전략패턴으로 작성 */

// 할인 전략 인터페이스 (Strategy)
interface DiscountStrategy{
    int applyDiscount(int totalPrice);
}

// 정액 할인 전략 클래스(ConcreteStrategy1)
class FlatDiscountStrategy implements DiscountStrategy {
    private int disccountAmount;

    public FlatDiscountStrategy(int disccountAmount) {
        this.disccountAmount = disccountAmount;
    }
    @Override
    public int applyDiscount(int totalPrice) {
        return totalPrice - disccountAmount;
    }
}

// 정률 할인 전략 클래스 (ConcreteStrategy2)
class PercentageDiscountStrategy implements DiscountStrategy {
    private double discountPercentage;

    public PercentageDiscountStrategy(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int applyDiscount(int totalPrice) {
        return (int)(totalPrice * (1 - discountPercentage));
    }
}

// 무료 배송 전략 클래스(ConcreteStrategy3)
class FreeShippingStrategy implements DiscountStrategy {
    @Override
    public int applyDiscount(int totalPrice) {
        return totalPrice;
    }
}

// 주문 클래스 (Context)
class Order {
    private int totalPrice;
    private DiscountStrategy discountStrategy;

    public Order(int totalPrice){
        this.totalPrice = totalPrice;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public int calculateTotalPrice() {
        if(discountStrategy == null) {
            return totalPrice;
        } else {
            return discountStrategy.applyDiscount(totalPrice);
        }
    }
}

//전략패턴을 이용한 할인 서비스 테스트 코드
public class ShowppingStrategyPatternTest {
    public static void main(String[] args) {
        Order order = new Order(30000);

        // 정액 할인 적용 (5000원 할인)
        order.setDiscountStrategy(new FlatDiscountStrategy(5000));
        int totalPrice = order.calculateTotalPrice();
        System.out.println("결재 금액 : " + totalPrice);
        // 출력 : 결재 금액 : 25000

        // 정률 할인 적용 (20% 할인)
        order.setDiscountStrategy(new PercentageDiscountStrategy(0.2));
        totalPrice = order.calculateTotalPrice();
        System.out.println("결재 금액 : " + totalPrice);
        // 출력 : 결재 금액 : 24000

        // 무료 배송 적용
        order.setDiscountStrategy(new FreeShippingStrategy());
        totalPrice = order.calculateTotalPrice();;
        System.out.println("결재 금액 : " + totalPrice);
        // 출력 : 결재 금액 : 30000
    }
}

