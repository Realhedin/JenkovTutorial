package javaUtilConcurrentPackage.forkAndJoinPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Implementation of RecursiveAction.
 * We use forkAndJoin if workLoad > THRESHOLD'a.
 * If so, we create 2 subtasks from our main one.
 * (by dividing workload).
 *  Implementation of RecursiveAction returns nothing.
 *
 * @author dkorolev
 *         Date: 23.10.15
 *         Time: 19:55
 */
public class MyRecursiveAction extends RecursiveAction {

    private static final int THRESHOLD = 16;

    private long workLoad = 0;

    public MyRecursiveAction(long workLoad) {
        this.workLoad = workLoad;
    }

    /**
     * The main computation performed by this task.
     */
    @Override
    protected void compute() {
        //if work is above threshold, break tasks up into smaller tasks
        if (this.workLoad > THRESHOLD) {
            System.out.println("Splitting workLoad: " + this.workLoad);

            List<MyRecursiveAction> subtasks = new ArrayList<>();

            //divide main task into subtasks
            subtasks.addAll(createSubtasks());

            //subtasks execution in the pool
            for (MyRecursiveAction subtask : subtasks) {
                subtask.fork();
            }
        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
        }
    }


    //divide task into 2 subtasks
    private List<MyRecursiveAction> createSubtasks() {
        List<MyRecursiveAction> subtasks = new ArrayList<>();

        MyRecursiveAction subtask1 = new MyRecursiveAction(this.workLoad / 2);
        MyRecursiveAction subtask2 = new MyRecursiveAction(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }

}
