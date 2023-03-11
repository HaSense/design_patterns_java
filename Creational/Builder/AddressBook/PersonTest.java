
class Person {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class PersonBuilder {
        private String name;
        private int age;
        private String address;
        private String phoneNumber;

        public PersonBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }//end of PersonBuilder

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder("홍길동", 22)
                .setAddress("서울 종로구 8282")
                .setPhoneNumber("010-1234-5678")
                .build();

        System.out.println("이름: " + person.getName());
        System.out.println("나이: " + person.getAge());
        System.out.println("주소: " + person.getAddress());
        System.out.println("전화번호: " + person.getPhoneNumber());
    }
}
