package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private boolean executed;
    private boolean completed;

    @Override
    public void execute() {
        if (completed) {
          executed = true;
        }
    }

    @Override
    public boolean isFinished() {
        return completed && executed;
    }

    public void complete() {
       completed = true;
    }
}
