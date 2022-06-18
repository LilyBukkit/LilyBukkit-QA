package ru.vtm.lilybukkit.scheduler;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class LBScheduler implements BukkitScheduler {
    /**
     * Schedules a once off task to occur after a delay
     * This task will be executed by the main server thread
     *
     * @param plugin
     * @param task
     * @param delay
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Schedules a once off task to occur as soon as possible
     * This task will be executed by the main server thread
     *
     * @param plugin
     * @param task
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Schedules a repeating task
     * This task will be executed by the main server thread
     *
     * @param plugin
     * @param task
     * @param delay
     * @param period
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Schedules a once off task to occur after a delay
     * This task will be executed by a thread managed by the scheduler
     *
     * @param plugin
     * @param task
     * @param delay
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Schedules a once off task to occur as soon as possible
     * This task will be executed by a thread managed by the scheduler
     *
     * @param plugin
     * @param task
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Schedules a repeating task
     * This task will be executed by a thread managed by the scheduler
     *
     * @param plugin
     * @param task
     * @param delay
     * @param period
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Calls a method on the main thread and returns a Future object
     * This task will be executed by the main server thread
     * <p>
     * Note:  The Future.get() methods must NOT be called from the main thread
     * Note2: There is at least an average of 10ms latency until the isDone() method returns true
     *
     * @param plugin
     * @param task
     * @return Future Future object related to the task
     */
    @Override
    public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Removes task from scheduler
     *
     * @param taskId
     */
    @Override
    public void cancelTask(int taskId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Removes all tasks associated with a particular plugin from the scheduler
     *
     * @param plugin
     */
    @Override
    public void cancelTasks(Plugin plugin) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Removes all tasks from the scheduler
     */
    @Override
    public void cancelAllTasks() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Check if the task currently running.
     * <p>
     * A repeating task might not be running currently, but will be running in the future.
     * A task that has finished, and does not repeat, will not be running ever again.
     * <p>
     * Explicitly, a task is running if there exists a thread for it, and that thread is alive.
     *
     * @param taskId The task to check.
     * @return If the task is currently running.
     */
    @Override
    public boolean isCurrentlyRunning(int taskId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Check if the task queued to be run later.
     * <p>
     * If a repeating task is currently running, it might not be queued now but could be in the future.
     * A task that is not queued, and not running, will not be queued again.
     *
     * @param taskId The task to check.
     * @return If the task is queued to be run.
     */
    @Override
    public boolean isQueued(int taskId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns a list of all active workers.
     * <p>
     * This list contains asynch tasks that are being executed by separate threads.
     *
     * @return Active workers
     */
    @Override
    public List<BukkitWorker> getActiveWorkers() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns a list of all pending tasks.  The ordering of the tasks is not related to their order of execution.
     *
     * @return Active workers
     */
    @Override
    public List<BukkitTask> getPendingTasks() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
