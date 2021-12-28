package rest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomUtils;
import robot.Robot;
import tasks.Task;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class RequestBodyEditor {

    //Not the best of doing this but quick and dirty but working

    //Hashmap key = taskId
    //value = request json as string
    private static HashMap<Integer,String> requests = new HashMap<>();

    public static String editAssignCommand(Robot robot, Task task){
        String requestBody="";
        if (requests.containsKey(task.getTaskId())){
            requestBody = requests.get(task.getTaskId());
        }else{
            try {
                requestBody = FileUtils.readFileToString(new File(RequestBodyEditor.class.getResource("/requests/assignCommand.json").getFile()),"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return requestBody.replace("{requestId}",randomGenerateId()).replace("{taskId}",task.getTaskId()+"").replace("{robotId}",robot.getRobotId()+"");
    }

    private static CharSequence randomGenerateId() {
        return RandomUtils.nextInt()+"";
    }


}
