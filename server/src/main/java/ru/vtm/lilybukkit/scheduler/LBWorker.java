package ru.vtm.lilybukkit.scheduler;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitWorker;

public class LBWorker implements BukkitWorker {
    /**
     * Returns the taskId for the task being executed by this worker
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
     * Returns the thread for the worker
     *
     * @return The Thread object for the worker
     */
    @Override
    public Thread getThread() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
