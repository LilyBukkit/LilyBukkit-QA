package ru.VladTheMountain.LilyBukkit.event;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.HashMap;
import java.util.concurrent.*;

;

/**
 * A class that handles the events
 */
public class LilyBukkitEventScheduler implements BukkitScheduler {

    HashMap<Integer, Task> tasks = new HashMap<>();

    /**
     * Schedules a once off task to occur after a delay
     * This task will be executed by the main server thread
     *
     * @param plugin Plugin that owns the task
     * @param task   Task to be executed
     * @param delay  Delay in server ticks before executing task
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return !this.tasks.put(this.tasks.size(), new Task(plugin, task, delay, false)).equals(null) ? this.tasks.size() : -1;
    }

    /**
     * Schedules a once off task to occur as soon as possible
     * This task will be executed by the main server thread
     *
     * @param plugin Task to be executed
     * @param task   Plugin that owns the task
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
        return this.scheduleSyncDelayedTask(plugin, task, 0);
    }

    /**
     * Schedules a repeating task
     * This task will be executed by the main server thread
     *
     * @param plugin Plugin that owns the task
     * @param task   Task to be executed
     * @param delay  Delay in server ticks before executing first repeat
     * @param period Period in server ticks of the task
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return !this.tasks.put(this.tasks.size(), new Task(plugin, task, delay, period, false)).equals(null) ? this.tasks.size() : -1;
    }

    /**
     * Schedules a once off task to occur after a delay
     * This task will be executed by a thread managed by the scheduler
     *
     * @param plugin Plugin that owns the task
     * @param task   Task to be executed
     * @param delay  Delay in server ticks before executing task
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        //TODO
        return -1;
    }

    /**
     * Schedules a once off task to occur as soon as possible
     * This task will be executed by a thread managed by the scheduler
     *
     * @param plugin Plugin that owns the task
     * @param task   Task to be executed
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
        return this.scheduleAsyncDelayedTask(plugin, task, 0);
    }

    /**
     * Schedules a repeating task
     * This task will be executed by a thread managed by the scheduler
     *
     * @param plugin Plugin that owns the task
     * @param task   Task to be executed
     * @param delay  Delay in server ticks before executing first repeat
     * @param period Period in server ticks of the task
     * @return int Task id number (-1 if scheduling failed)
     */
    @Override
    public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        //TODO
        return -1;
    }

    /**
     * Calls a method on the main thread and returns a Future object
     * This task will be executed by the main server thread
     * <p>
     * Note:  The Future.get() methods must NOT be called from the main thread
     * Note2: There is at least an average of 10ms latency until the isDone() method returns true
     *
     * @param plugin Plugin that owns the task
     * @param task   Task to be executed
     * @return Future Future object related to the task
     */
    @Override
    public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
        return new Future<T>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                //TODO
                return false;
            }

            @Override
            public boolean isCancelled() {
                //TODO
                return false;
            }

            @Override
            public boolean isDone() {
                //TODO
                return false;
            }

            @Override
            public T get() throws InterruptedException, ExecutionException {
                try {
                    return task.call();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                try {
                    return task.call();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    /**
     * Removes task from scheduler
     *
     * @param taskId Id number of task to be removed
     */
    @Override
    public void cancelTask(int taskId) {
        this.tasks.replace(taskId, this.tasks.get(taskId), null);
    }

    /**
     * Removes all tasks associated with a particular plugin from the scheduler
     *
     * @param plugin Owner of tasks to be removed
     */
    @Override
    public void cancelTasks(Plugin plugin) {
        for (int id = 0; id < this.tasks.size(); id++) {
            if (this.tasks.get(id).owner.equals(plugin)) {
                this.tasks.replace(id, this.tasks.get(id), null);
            }
        }
    }

    /**
     * Removes all tasks from the scheduler
     */
    @Override
    public void cancelAllTasks() {
        this.tasks.clear();
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
        return this.tasks.get(taskId).isRunning;
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
        return !this.tasks.get(taskId).equals(null);
    }

    class Task {
        public Plugin owner;
        public Runnable task;
        public long delay;
        public boolean isRunning;
        public long period;
        public boolean isAsync;

        public Task(Plugin p, Runnable r, long d, long pe, boolean flag) {
            this.owner = p;
            this.task = r;
            this.delay = d;
            this.period = pe;
            this.isAsync = flag;
        }

        public Task(Plugin p, Runnable r, long d, boolean flag) {
            this(p, r, d, 0, flag);
        }

        public Task(Plugin p, Runnable r, boolean flag) {
            this(p, r, 0, flag);
        }
    }
}
