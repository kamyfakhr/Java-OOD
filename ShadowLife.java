import bagel.*;
import bagel.util.*;
//import bagel.Font;
import bagel.Image;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
//import java.util.Random;

public class ShadowLife extends AbstractGame {

    private final Image background;
    private static final String FILE_SOURCE = "res/test.csv";
   // private Tree tree;
    //private Font score;
    //private Gatherer gatherer;
     private double num_tick;
    //private double x_point;
    //private long startTime = System.currentTimeMillis();
    // private long currentTimeMillis;
    //private long timeInterval;
    //private double y_point;
    //public int num_tick = 0;
    //private double x;
    //private double y;
    //int numGatherer = 2;
    //int numTree = 4;
    //Tree[] treeArray = new Tree[numTree];
    //Gatherer[] gathererArray = new Gatherer[numGatherer];
    private ArrayList<Tree> treeArrayList;
    private ArrayList<Gatherer> gathererArrayList;
    private final long start = System.currentTimeMillis();
    //private Vector2 velocity;
    //private ArrayList<Object> List;



    //Random rand = new Random();

    // Generate random integers in range 0 to 499
    //private int x_ball = rand.nextInt(500);
    //private int y_ball = rand.nextInt(500);

    public ShadowLife() {
        super(1000, 800, "Shadow Life");
        background = new Image("res/background.png");
        treeArrayList = new ArrayList<>();
        gathererArrayList = new ArrayList<>();
        //tree = new Tree();
        //gatherer = new Gatherer();
        //score = new Font("res/conformable.otf", 100);

    }
    /*
    public static void add_element(int n, Object[] myArray, Object ele)
    {
        int i;

        Object[] newArray = new Object[n + 1];
        //copy original array into new array
        for (i = 0; i < n; i++)
            newArray[i] = myArray[i];

        //add element to the new array
        newArray[n] = ele;

        //return newArray;
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        ShadowLife game = new ShadowLife();
        game.run();


    }

    public void loadObjects(ArrayList<Tree> treeArraylist, ArrayList<Gatherer> gathererArraylist) {
        //String filename;
        try (BufferedReader br =
                     new BufferedReader(new FileReader(FILE_SOURCE))) {

            String text;

            // Read through the input line by line
            while ((text = br.readLine()) != null) {
                String[] cells = text.split(",");
                //System.out.println(cells[0]);

                String objectName = cells[0];
                int x = Integer.parseInt(cells[1]);
                int y = Integer.parseInt(cells[2]);
                Point position = new Point(x, y);


                //System.out.println(treeArraylist);
                if (objectName.equals("Tree")) {
                    Tree newTree = new Tree(position);
                   // add_element(treeArray.length, treeArray, newTree);
                    treeArraylist.add(new Tree(position));

                    //newTree.update();
                }
                if (objectName.equals("Gatherer")) {
                    Gatherer newGatherer = new Gatherer(position);
                    //add_element(gathererArray.length, gathererArray, newGatherer);
                    gathererArraylist.add(new Gatherer(position));
                    //newGatherer.update();


                }


            }
            //System.out.println(treeArraylist);
            //System.out.println(treeArray);
        } catch (Exception e) {
            e.printStackTrace();



        }



    }

    public void tick() {
        //moveGatherer();
        //timeInterval = System.currentTimeMillis() - startTime;
        //System.out.println(timeInterval);
        ++num_tick;
        //System.out.println(num_tick);
        //return num_tick;
    }


    /**
     * Performs a state update. This simple example shows an image that can be controlled with the arrow keys, and
     * allows the game to exit when the escape key is pressed.
     */
    @Override
    public void update(Input input) {
        tick();
        System.out.println(num_tick);
        //ShadowLife game = new ShadowLife();
        loadObjects(treeArrayList, gathererArrayList);
        background.drawFromTopLeft(0,0);
        for (Tree tree : treeArrayList) {

                tree.update();

        }
        if(num_tick == 1.0) {
            for (Gatherer gatherer : gathererArrayList) {
                //gatherer.moveGatherer();
                gatherer.update();
            }
        }

        if(num_tick % 50.0 == 0) {
            for (Gatherer gatherer : gathererArrayList) {
                gatherer.moveGatherer();
                gatherer.update();
            }
        }



        //tree.update();


    }


}

