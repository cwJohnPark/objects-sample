package appendixC;

public class Dragon extends Monster {

    public Dragon(int health) {
        super(health);
    }

    @Override
    public String getAttack() {
        return "용은 불을 내뿜는다.";
    }
}
