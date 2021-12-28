package tasks;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import robot.Robots;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tasks {

    List<Task> tasks;
    Logger logger = LogManager.getLogger("Tasks");


    public Tasks() {
        this.tasks = new ArrayList<>();
        readAllTasks();
    }

    private void readAllTasks() {
        try {
            logger.info("Reading Tasks configuration file located inside the resources folder @tasks.txt");
            List<String> robotsTxt = FileUtils.readLines(new File(Robots.class.getResource("/tasks.txt").getFile()), "UTF-8");
            for (String str : robotsTxt) {
                String[] arr = str.split(",");
                this.tasks.add(new Task(arr[1], arr[2], Integer.parseInt(arr[0])));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public Task getTaskByIndex(int index){
        return tasks.get(index);
    }

    //TODO -- implement add/remove/size etc...

}