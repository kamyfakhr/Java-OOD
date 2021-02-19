import bagel.Font;

/**
 * The FruitActor abstract class inherits the Actor abstract class, housing the fruit actors in our simulation.
 *
 * @author Chuen Ley Low
 */

public abstract class FruitActor extends Actor {

    private int numFruit;
    private final Font font = new Font("./res/VeraMono.ttf", 25);

    /**
     * Allows fruit child classes to initialise FruitActor object with necessary attributes.
     *
     * @param position  Point object, containing x and y coordinates.
     * @param imageFile image file associated with actor.
     * @param numFruit  Number of fruits that fruit actor starts with.
     */
    /* Allows subclasses to call this constructor method to initialise object */
    public FruitActor(Point position, String imageFile, int numFruit) {
        super(position, imageFile);
        this.numFruit = numFruit;
    }

    /**
     * Overridden Draw method from Actor Parent class. Draws Fruit Object with number of fruits on top left.
     */
    /* Draws our fruit object with the number of fruits on the top left of our fruit actor */
    @Override
    public void draw() {
        super.draw();
        font.drawString(Integer.toString(numFruit),
                super.getPosition().getX(), super.getPosition().getY());
    }

    /**
     * Getter for numFruits.
     *
     * @return The Number of Fruits of the FruitActor.
     */
    /* Returns number of fruits */
    public int getNumFruits() {
        return this.numFruit;
    }

    /**
     * Increases the number of fruits by one.
     */
    /* Increase number of fruits by one */
    public void increaseNumFruits() {
        this.numFruit++;
    }

    /**
     * Decreases the number of fruits by one.
     */
    /* Decrease number of fruits by one */
    public void decreaseNumFruits() {
        this.numFruit--;
    }

}
