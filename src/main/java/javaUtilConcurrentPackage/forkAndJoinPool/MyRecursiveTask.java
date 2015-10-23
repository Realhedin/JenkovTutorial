package javaUtilConcurrentPackage.forkAndJoinPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Implementation of RecursiveTask.
 * We use forkAndJoin if workLoad > THRESHOLD'a.
 * If so, we create 2 subtasks from our main one.
 * (by dividing workload).
 *  Implementation of RecursiveTask returns Object.
 *  (in our case Long as workLoad after dividing).
 *
 * @author dkorolev
 *         Date: 23.10.15
 *         Time: 20:52
 */
public class MyRecursiveTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 16;

    private long workLoad = 0;


    public MyRecursiveTask(long workLoad) {
        this.workLoad = workLoad;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Long compute() {
        if (this.workLoad > THRESHOLD) {
            System.out.println("Splitting workLoad: " + this.workLoad);

            List<MyRecursiveTask> subtasks = new ArrayList<>();
            subtasks.addAll(createSubtasks());

            for (MyRecursiveTask subtask : subtasks) {
                subtask.fork();
            }

            long result = 0;
            for (MyRecursiveTask subtask : subtasks) {
                result += subtask.join();
            }
            return result;


        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
            return workLoad * 3;
        }
    }


    //divide task into 2 subtasks
    private List<MyRecursiveTask> createSubtasks() {
        List<MyRecursiveTask> subtasks = new ArrayList<>();

        MyRecursiveTask subtask1 = new MyRecursiveTask(this.workLoad / 2);
        MyRecursiveTask subtask2 = new MyRecursiveTask(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }
}
