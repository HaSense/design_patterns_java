import java.util.ArrayList;
import java.util.List;

//Subject와 Observer 정의
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
interface  Observer {
    void update(String message);
}

//구현체 만들기
class PushServer implements Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private String message;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(message);
        }
    }
    //추가 메서드
    public void sendMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}

class PushNotification implements Observer {
    private String name;

    public PushNotification(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println("Push notification sent to " + name + ": " + message);
    }
}
public class simplePushServerTest {
    public static void main(String[] args) {

        PushServer pushServer = new PushServer();

        PushNotification user1 = new PushNotification("User 1");
        PushNotification user2 = new PushNotification("User 2");
        PushNotification user3 = new PushNotification("User 3");

        pushServer.attach(user1);
        pushServer.attach(user2);
        pushServer.attach(user3);

        pushServer.sendMessage("v1.1.3으로 업데이트 되었음을 공지합니다.");

        pushServer.detach(user2);

        pushServer.sendMessage("v1.2.1으로 업데이트 되었음을 공지합니다.");
    }
}





