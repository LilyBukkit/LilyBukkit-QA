package ru.VladTheMountain.LilyBukkit.util;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ServerConfigurationManager;
import ru.VladTheMountain.LilyBukkit.LilyBukkit;

/**
 * A class that defines a configuration manager for the LilyBukkit server
 */
public class LilyBukkitConfigurationManager extends ServerConfigurationManager {

    private ServerConfigurationManager configurationManager;

    /**
     * Create a new LilyBucketConfigurationManager with the specified {@link ServerConfigurationManager} as a base
     *
     * @param serverConfigurationManager
     */
    public LilyBukkitConfigurationManager(MinecraftServer server, ServerConfigurationManager serverConfigurationManager) {
        super(server);
        this.configurationManager = serverConfigurationManager;
        //TODO
    }
}
