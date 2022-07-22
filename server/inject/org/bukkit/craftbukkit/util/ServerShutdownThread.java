package org.bukkit.craftbukkit.util;

import net.minecraft.server.MinecraftServer;

@Deprecated
public class ServerShutdownThread extends Thread {
    private final MinecraftServer server;

    public ServerShutdownThread(MinecraftServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        //server.lilyBukkit.shutdown();
        throw new UnsupportedOperationException("Deprecated server shutdown was called by one of the plugins. Preventing...");
    }
}