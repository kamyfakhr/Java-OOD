/**
 * The Hoard class inherits the Actor class as it does not perform any action upon a tick and can be considered static.
 *
 * @author Chuen Ley Low
 */

public class Hoard extends FruitActor {

    /**
     * Takes in a position and a set image file to initialise Hoard object.
     *
     * @param position Point object which contains x and y coordinates.
     */
    public Hoard(Point position) {
        super(position, "./res/images/hoard.png", 0);
    }
}
