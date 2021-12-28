package robot;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Robots {

    private List<Robot> robots;
    Logger logger = LogManager.getLogger("Robots");


    public Robots() {
        this.robots = new ArrayList<>();
        readAllBots();
    }

    private void readAllBots(){

        logger.info("Reading robots configuration file located inside the resources folder @robots.txt");



    }

    public void addRobot(Robot robot){
        //TODO -- need to add verification that the Robot doesn't already exist....
        this.robots.add(robot);
    }

    public Robot getRobot(int robotIndex){
        return this.robots.get(robotIndex);
    }

    public void removeRobot(int robotIndex){
        if (!(robotIndex>this.robots.size())){
            logger.info("Removing robot at index " + robotIndex);
            this.robots.remove(robotIndex);
        }else{
            logger.fatal("Robot index " + robotIndex + " could not be found!");
        }
    }

    //TODO -- would add more methods to get Robots objects either by ID / Robot name etc...


}

