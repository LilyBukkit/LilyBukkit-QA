package ru.vladthemountain.lilybukkit.scheduler;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

/**
 * @author VladTheMountain
 */
public class LBTask implements BukkitTask {

    private final int taskId;
    private final Plugin owner;
    private final boolean synced;
    private final long delayed;

    public LBTask(int id, Plugin p, Runnable code, boolean isSync, long delay){
        this.taskId = id;
        this.owner = p;
        this.synced = isSync;
        this.delayed = delay;
    }

    /**
     * Returns the taskId for the task
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
     * Returns true if the Task is a sync task
     *
     * @return true if the task is run by main thread
     */
    @Override
    public boolean isSync() {
        return this.synced;
    }
}
