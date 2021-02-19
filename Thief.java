import java.util.ListIterator;

/**
 * The Gatherer Class is classified as a moving actor that can interact with other objects in the simulation.
 * Inherits the MovingActor class.
 *
 * @author Chuen Ley Low
 */

public class Thief extends MovingActor {

    private boolean consuming = false;

    /**
     * Constructs Gatherer object in a specific position.
     *
     * @param position Point object which contains x and y coordinates.
     */
    public Thief(Point position) {
        super(position, "./res/images/thief.png");
        super.directionIndex = 0;
        super.direction = POSSIBLE_DIRS[directionIndex];
    }

    /**
     * Takes in Actor object and performs specific set of actions depending on the type of the other actor.
     *
     * @param otherActor Actor object that is passed in if both are on the same position.
     */
    /* Action functionality for Thieves depending on other actor*/
    @Override
    public void action(Actor otherActor) {

        if (otherActor instanceof Gatherer) {
            rotate(270, true);
        } else if (otherActor instanceof Fence) {
            active = false;

            /* Move Thief to previous position in previous tick */
            super.rotate(180, true);
            super.move();
        } else if (otherActor instanceof Sign) {
            /* Change the direction of our thief to the sign's direction */
            String direction = ((Sign) otherActor).getType();
            super.directionIndex = findIndexOfPos(direction);
            super.direction = POSSIBLE_DIRS[directionIndex];
        } else if (otherActor instanceof Pad) {
            consuming = true;
        }a else if ((otherActor instanceof Tree || otherActor instanceof GoldenTree) && carrying == false) {

            /* If tree's number of fruits is one or more then decrease number of fruits and rotate thief by 180 */
            if (otherActor instanceof Tree) {
                Tree tree = (Tree) otherActor;
                if (tree.getNumFruits() >= 1) {
                    tree.decreaseNumFruits();
                    carrying = true;
                }
            } else {
                carrying = true;
            }
        } else if (otherActor instanceof Hoard) {
            Hoard hoard = (Hoard) otherActor;
            if (consuming == true) {
                consuming = false;
                if (carrying == false) {
                    /* If hoard has one or more fruits then decrease hoard fruit by one and set carrying to true */
                    if (hoard.getNumFruits() >= 1) {
                        carrying = true;
                        hoard.decreaseNumFruits();
                    } else {
                        rotate(90, true);
                    }
                }
            }

            /* If carrying is true then fruit gets placed in hoard and fruit count is increased, rotate by 90 clockwise */
            else if (carrying == true) {
                carrying = false;
                hoard.increaseNumFruits();
                rotate(90, true);
            }
        } else if (otherActor instanceof Stockpile) {
            if (carrying == false) {
                Stockpile stockpile = (Stockpile) otherActor;
                /* If Stockpile has one or more fruits, then set carrying to true, consuming to false, decrease
                   number of fruits by one and rotate by 90 clockwise */
                if (stockpile.getNumFruits() >= 1) {
                    carrying = true;
                    consuming = false;
                    stockpile.decreaseNumFruits();
                    rotate(90, true);
                }
            } else {
                rotate(90, true);
            }
        }
    }

    /**
     * Duplicates our moving actor when standing on top of Mitosis Pool.
     *
     * @param moveActorIter List Iterator of all Moving Actor objects in our simulation.
     * @param actorIter     List Iterator of all Actor objects in our simulation.
     */
    @Override
    public void duplicateMovingActor(ListIterator<MovingActor> moveActorIter, ListIterator<Actor> actorIter) {

        /* Add new Thief to ActorArray with current position and rotated 90 degrees counterclockwise */
        Thief newThief = this.cloneThief();
        newThief.rotate(90, false);
        newThief.move();
        actorIter.add(newThief);
        moveActorIter.add(newThief);

        /* Add new Thief to ActorArray with current position and rotated 90 degrees clockwise */
        Thief newThief2 = this.cloneThief();
        newThief2.move();
        actorIter.add(newThief2);
        moveActorIter.add(newThief2);

        /* "Destroy" our current thief */
        super.setToDraw(false);
        super.setStatus(false);
    }

    /* Returns a copy of our current Thief */
    private Thief cloneThief() {
        Thief newThief = new Thief(getPosition());
        newThief.setDirection(super.directionIndex);
        return newThief;
    }
}
