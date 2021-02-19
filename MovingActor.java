import java.util.ListIterator;

/**
 * The MovingActor abstract class inherits the Actor abstract class, housing the moving actors in our simulation.
 *
 * @author Chuen Ley Low
 */

public abstract class MovingActor extends Actor {
    /**
     * The constant speed at which Moving Actors move in our simulation.
     */
    /* Speed at which Moving Actors move */
    public final static int SPEED = 64;

    /**
     * The number of degrees of one turn the Moving Actor makes.
     */
    /* Number of degrees for one turn */
    public final static int ONE_TURN = 90;

    /**a
     * The possible list of directions that the Moving Actor could be in.
     */
    /* Possible directions of our Moving Actor */
    public final static String[] POSSIBLE_DIRS = {"UP", "RIGHT", "DOWN", "LEFT"};

    /* Direction index indicating index in possible directions array, direction for string at index position */
    protected int directionIndex;
    protected String direction;

    /* Both Moving Actors start with an initial state of carrying = false and active = true */
    protected boolean carrying = false;
    protected boolean active = true;

    /**
     * Allows moving child classes to initialise FruitActor object with necessary attributes.
     *
     * @param position  Point object, containing x and y coordinates.
     * @param imageFile image file associated with actor.
     */
    public MovingActor(Point position, String imageFile) {
        super(position, imageFile);
    }

    /**
     * Action the Moving Actor does with regards to the other actor.
     *
     * @param otherActor Actor object that is passed in if both are on the same position.
     */
    /* Action moving actor does depending on other actor */
    public abstract void action(Actor otherActor);

    /**
     * Duplicates our Moving Actor Object.
     *
     * @param moveActorIter List Iterator of all Moving Actor objects in our simulation.
     * @param actorIter     List Iterator of all Actor objects in our simulation.
     */
    /* Duplicate our moving actor if standing on Mitosis Pool */
    public abstract void duplicateMovingActor(ListIterator<MovingActor> moveActorIter, ListIterator<Actor> actorIter);

    /**
     * Returns the status of our Moving Actor.
     *
     * @return Status boolean value.
     */
    /* Returns status of Moving Actor */
    public boolean getStatus() {
        return this.active;
    }

    /**
     * Sets the status of our Moving Actor.
     *
     * @param value Status boolean value.
     */
    /* Sets status of Moving Actor */
    public void setStatus(boolean value) {
        this.active = value;
    }

    /**
     * Sets the direction of our Moving Actor.
     *
     * @param directionIndex Number that represents our direction, in accordance to POSSIBLE_DIRS array.
     */
    /* Sets the direction of our Moving Actor. */
    public void setDirection(int directionIndex) {
        this.directionIndex = directionIndex;
        this.direction = POSSIBLE_DIRS[this.directionIndex];
    }

    /**
     * Moves our Moving Actor in the current direction.
     */
    /* Moves our Moving Actor in the current direction. */
    public void move() {

        int curr_X = super.getPosition().getX();
        int curr_Y = super.getPosition().getY();

        switch (direction) {
            case "UP":
                super.setPosition(new Point(curr_X, curr_Y - SPEED));
                break;
            case "DOWN":
                super.setPosition(new Point(curr_X, curr_Y + SPEED));
                break;
            case "RIGHT":
                super.setPosition(new Point(curr_X + SPEED, curr_Y));fS 
                break;
            case "LEFT":
                super.setPosition(new Point(curr_X - SPEED, curr_Y));
                break;
        }
    }

    /**
     * Rotates the Moving Actor.
     *
     * @param degrees   Number of degrees, although only limited to 90 degree turns.
     * @param clockwise Tells whether our rotation is clockwise or not.
     */
    /* Rotates our moving actor by the number of degrees specified (Only Multiples of 90 Degrees) */
    public void rotate(int degrees, boolean clockwise) {
        int turns = degrees / ONE_TURN;

        if (clockwise) {
            this.directionIndex += turns;
            this.directionIndex %= POSSIBLE_DIRS.length;
        } else {
            this.directionIndex -= turns;
            if (this.directionIndex < 0) {
                this.directionIndex = POSSIBLE_DIRS.length + this.directionIndex;
            }
        }

        this.direction = POSSIBLE_DIRS[this.directionIndex];
    }

    /* Given a direction, finds the index position in possible directions array */
    protected int findIndexOfPos(String direction) {

        for (int i = 0; i < POSSIBLE_DIRS.length; i++) {
            if (direction.equals(POSSIBLE_DIRS[i])) {
                return i;
            }
        }

        return 0;
    }

}
