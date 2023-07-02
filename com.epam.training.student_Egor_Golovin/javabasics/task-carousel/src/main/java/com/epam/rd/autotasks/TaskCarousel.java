package com.epam.rd.autotasks;

import java.util.ArrayList;

public class TaskCarousel {
    private final int capacity;
    private int taskNum;
    private int position;
    ArrayList<Task> tasks = new ArrayList<>();

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
    }

    public boolean addTask(Task task) {
        if (!task.isFinished() && !isFull()) {
            tasks.add(task);
            taskNum++;
            return true;
        } else return false;
    }

    public boolean execute() {
        if (taskNum > 0) {
            tasks.get(position).execute();
            if (tasks.get(position).isFinished()) {
                tasks.remove(position--);
                taskNum--;
            }
            if (position < taskNum - 1) {
                position++;
            } else position = 0;
            return true;
        } else return false;
    }

    public boolean isFull() {
        return taskNum == capacity;
    }

    public boolean isEmpty() {
        for (Task task :tasks) {
            if (!task.isFinished()) {
                return false;
            }
        } return true;
    }
}
