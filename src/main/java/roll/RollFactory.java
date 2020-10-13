package roll;

import roll.decorations.Fillings;
import roll.decorations.Sauces;
import roll.decorations.Toppings;
import roll.types.*;
import java.util.Random;

public class RollFactory {

    public Roll createRoll(String rollType) {

        Random rand = new Random();

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

        int numSauces = rand.nextInt(4);
        int numFillings = rand.nextInt(2);
        int numToppings = rand.nextInt(3);

        for(int i = 0; i < numSauces; i++) {
            roll = new Sauces(roll);
        }

        for(int i = 0; i < numFillings; i++) {
            roll = new Fillings(roll);
        }

        for(int i = 0; i < numToppings; i++) {
            roll = new Toppings(roll);
        }

        return roll;
    }
}
