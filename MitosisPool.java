s/**
 * The MitosisPool class inherits the Actor class as it does not perform any action upon a tick and can be considered static.
 *
 * @author Chuen Ley Low
 */

public class MitosisPool extends Actor {

    /**
     * Takes in a position and a set image file to initialise MitosisPool object.
     *
     * @param position Point object which contains x and y coordinates.
     */
    public MitosisPool(Point position) {
        super(position, "./res/images/pool.png");
    }
}
