/**
 * The Sign class inherits the Actor class as it does not perform any action upon a tick and can be considered static.
 *
 * @author Chuen Ley Low
 */
public class Sign extends Actor {
    /* Our type of sign indicates direction we want moving actor to go to */
    private String type;

    /**
     * Takes in a position and a type to initialise Pad object.
     *
     * @param position Point object which contains x and y coordinates.
     * @param type     The type of sign. (Up, Down, Left, Right)
     */
    public Sign(Point position, String type) {
        super(position, "./res/images/" + type + ".png");
        this.type = type;
    }

    /**
     * Returns the type of sign.s
     *
     * @return A string indicating the type of sign.
     */
    /* Returns type of sign */
    public String getType() {
        return this.type;
    }
}
