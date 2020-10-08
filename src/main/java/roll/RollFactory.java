package roll;

import roll.types.*;

public class RollFactory {

    public Roll createRoll(String rollType) {
        Roll roll = null;
        switch (rollType) {
            case "sausage":
                roll = new SausageRoll();
                break;
            case "jelly":
                roll = new JellyRoll();
                break;
            case "egg":
                roll = new EggRoll();
                break;
            case "spring":
                roll = new SpringRoll();
                break;
            case "pastry":
                roll = new PastryRoll();
                break;
            default:
                roll = null;
        }
        return roll;
    }

}
