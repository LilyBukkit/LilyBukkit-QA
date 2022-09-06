package org.bukkit.craftbukkit;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Packet;

@Deprecated
public class ChunkCompressionThread implements Runnable {

    public static void startThread() {
        throw new UnsupportedOperationException("One of the plugins called a deprecated class ChunkCompressionThread.");
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        throw new UnsupportedOperationException("One of the plugins called a deprecated class ChunkCompressionThread.");
    }

    public static void sendPacket(EntityPlayer player, Packet packet){
        throw new UnsupportedOperationException("One of the plugins called a deprecated class ChunkCompressionThread.");
    }

    public static int getPlayerQueueSize(EntityPlayer player){
        throw new UnsupportedOperationException("One of the plugins called a deprecated class ChunkCompressionThread.");
    }
}
