package ru.vtm.lilybukkit.scheduler;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class LBTask implements BukkitTask {
    /**
     * Returns the taskId for the task
     *
     * @return Task id number
     */
    @Override
    public int getTaskId() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the Plugin that owns this task
     *
     * @return The Plugin that owns the task
     */
    @Override
    public Plugin getOwner() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns true if the Task is a sync task
     *
     * @return true if the task is run by main thread
     */
    @Override
    public boolean isSync() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
