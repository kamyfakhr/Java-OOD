/**
 * The Stockpile class is classified as a Fruit Actor hence it inherits the FruitActor class.
 *
 * @author Chuen Ley Low
 */

public class Stockpile extends FruitActor {

    /**
     * Takes in a position and a set image file to initialise Stockpile object.
     *
     * @param position Point object which contains x and y coordinates.
     */
    public Stockpile(Point position) {
        super(position, "./res/images/cherries.png", 0);
    }
}
