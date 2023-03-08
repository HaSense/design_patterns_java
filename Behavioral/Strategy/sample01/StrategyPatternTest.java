
//Strategy
interface Weapon {
    void attack();
}
//ConcreteStrategy1
class Sword implements Weapon {
    public void attack() {
        System.out.println("검으로 공격합니다.");
    }
}
//ConcreteStrategy2
class Bow implements Weapon {
    public void attack() {
        System.out.println("활로 공격합니다.");
    }
}

//Context
class Hero {
    private Weapon weapon;

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void attack() {
        if(weapon == null){
            System.out.println("무기가 없습니다.");
        }else{
            weapon.attack();
        }
    }
}

//테스트 클래스
public class StrategyPatternTest {
    public static void main(String[] args){
        Hero darkKnight = new Hero();

        //검으로 공격
        darkKnight.setWeapon(new Sword());
        darkKnight.attack();

        //활로 공격
        darkKnight.setWeapon(new Bow());
        darkKnight.attack();
    }
}
