package ru.VladTheMountain.LilyBukkit.util;

/**
 * An extended property manager
 */
public class LilyBukkitProperty {

    // Vanilla properties
    public static final String LEVEL_NAME = "level-name";
    public static final String MAX_PLAYERS = "max-players";
    /**
     * @deprecated in favor of 'difficulty'
     */
    @Deprecated
    public static final String MONSTERS = "monsters";
    public static final String SERVER_IP = "server-ip";
    public static final String ONLINE_MODE = "online-mode";
    public static final String SERVER_PORT = "server-port";

    // Bukkit properties
    public static final String DIFFICULTY = "difficulty";
    public static final String SERVER_NAME = "server-name";
    public static final String SERVER_ID = "server-id";
    public static final String WORLD_SEED = "world-seed";
}
