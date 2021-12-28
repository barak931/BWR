package robot;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
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
        //Reading all bots from the robots.txt file -- able to dynamically add/remove bots
        //Would add a utils package and class to do all read files operation -- No Time issue
        try {
            logger.info("Reading robots configuration file located inside the resources folder @robots.txt");
            List<String>robotsTxt = FileUtils.readLines(new File(Robots.class.getResource("/robots.txt").getFile()),"UTF-8");
            for (String str:robotsTxt){
                String[] arr = str.split(",");
                this.robots.add(new Robot(arr[0],arr[1],Integer.parseInt(arr[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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

