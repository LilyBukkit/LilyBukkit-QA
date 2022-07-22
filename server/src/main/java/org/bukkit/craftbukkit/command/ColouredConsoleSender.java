package org.bukkit.craftbukkit.command;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.CraftServer;

@Deprecated
public class ColouredConsoleSender extends ConsoleCommandSender {
    protected ColouredConsoleSender(CraftServer server) {
        super(server);
    }

    @Override
    public void sendMessage(String ignored) {
        throw new UnsupportedOperationException("One of the plugins called deprecated Command API to send the following message:\n" + ignored);
    }
}
