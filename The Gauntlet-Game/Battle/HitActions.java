package Battle;

public class HitActions {

    private String[] actions = { " punched ", " kicked ", " eye gouged ", " choke slammed ", " bodied " };

    public String createHit() {

        int index = (int) (Math.random() * 5);

        return actions[index];

    }
}