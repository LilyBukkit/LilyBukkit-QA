package org.bukkit.craftbukkit;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ServerConfigurationManager;
import ru.vladthemountain.lilybukkit.LilyBukkit;

@Deprecated
public class CraftServer extends LilyBukkit {

    ServerConfigurationManager server;

    public CraftServer(MinecraftServer console, ServerConfigurationManager server) {
        super(console);
        this.server = server;
    }

    public ServerConfigurationManager getHandle() {
        return server;
    }
}
