package ru.vladthemountain.lilybukkit.scheduler;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitWorker;

/**
 * @author VladTheMountain
 */
public class LBWorker implements BukkitWorker {

    private final int taskId;
    private final Plugin owner;
    private final Thread task;

    public LBWorker(int id, Plugin p, Thread t){
        this.taskId = id;
        this.owner = p;
        this.task = t;
    }
    /**
     * Returns the taskId for the task being executed by this worker
     *
     * @return Task id number
     */
    @Override
    public int getTaskId() {
        return this.taskId;
    }

    /**
     * Returns the Plugin that owns this task
     *
     * @return The Plugin that owns the task
     */
    @Override
    public Plugin getOwner() {
        return this.owner;
    }

    /**
     * Returns the thread for the worker
     *
     * @return The Thread object for the worker
     */
    @Override
    public Thread getThread() {
        return this.task;
    }
}
