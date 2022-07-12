package ru.vladthemountain.lilybukkit;

import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.SQLitePlatform;
import com.avaje.ebeaninternal.server.lib.sql.TransactionIsolation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayerMP;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.*;
import org.bukkit.craftbukkit.scheduler.CraftScheduler;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.SimpleServicesManager;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.config.Configuration;

import java.io.File;
import java.util.*;
import java.util.logging.Logger;

/**
 * {@link Server} implementation
 *
 * @author VladTheMountain
 */
public class LilyBukkit implements Server {

    final String MAX_PLAYERS = "max-players";
    final String SERVER_PORT = "server-port";
    final String VIEW_DISTANCE = "view-distance";
    final String SERVER_IP = "server-ip";
    final String WHITELIST_ENABLED = "whitelist";
    final String SPAWN_PROTECTION = "spawn-protection";
    final String ONLINE_MODE = "online-mode";
    final String ALLOW_FLIGHT = "allow-flight";
    final String SERVER_NAME = "server-name";
    final String SERVER_ID = "server-id";
    final String PVP_ENABLED = "pvp-enabled";

    private final MinecraftServer mc;
    private final PluginManager pluginMngr;
    private final BukkitScheduler scheduler;
    private final ServicesManager servicesMngr;
    private final List<LBWorld> worldList;
    private final List<Command> commandList;
    private final List<PluginCommand> pluginCommandList;
    private final List<Recipe> recipeManager;
    private final CommandMap commandMap;

    public LilyBukkit(MinecraftServer parent) {
        this.mc = parent;
        this.pluginMngr = new SimplePluginManager(Bukkit.getServer(), null /*TODO*/);
        this.scheduler = new CraftScheduler(this);
        this.servicesMngr = new SimpleServicesManager();
        this.worldList = new ArrayList<>();
        this.commandList = new ArrayList<>();
        this.pluginCommandList = new ArrayList<>();
        this.recipeManager = new ArrayList<>();
        this.commandMap = new SimpleCommandMap(this);
        MinecraftServer.logger.info("LilyBukkit initialized.");
    }

    /**
     * Gets the name of this server implementation
     *
     * @return name of this server implementation
     */
    @Override
    public String getName() {
        return "LilyBukkit";
    }

    /**
     * Gets the version string of this server implementation.
     *
     * @return version of this server implementation
     */
    @Override
    public String getVersion() {
        return "1.0.0";
    }

    /**
     * Gets a list of all currently logged in players
     *
     * @return An array of Players that are currently online
     */
    @Override
    public Player[] getOnlinePlayers() {
        List<Player> playerList = new ArrayList<>();
        for (Entity player : this.mc.worldMngr.playerEntities) {
            playerList.add(this.getPlayer(((EntityPlayerMP) player).username));
        }
        return playerList.toArray(new Player[]{});
    }

    /**
     * Get the maximum amount of players which can login to this server
     *
     * @return The amount of players this server allows
     */
    @Override
    public int getMaxPlayers() {
        return mc.propertyManagerObj.getIntProperty(MAX_PLAYERS, 20);
    }

    /**
     * Get the game port that the server runs on
     *
     * @return The port number of this server
     */
    @Override
    public int getPort() {
        return mc.propertyManagerObj.getIntProperty(SERVER_PORT, 25565);
    }

    /**
     * Get the view distance from this server.
     *
     * @return The view distance from this server.
     */
    @Override
    public int getViewDistance() {
        return mc.propertyManagerObj.getIntProperty(VIEW_DISTANCE, 8);
    }

    /**
     * Get the IP that this server is bound to or empty string if not specified
     *
     * @return The IP string that this server is bound to, otherwise empty string
     */
    @Override
    public String getIp() {
        return mc.propertyManagerObj.getStringProperty(SERVER_IP, "");
    }

    /**
     * Get the name of this server
     *
     * @return The name of this server
     */
    @Override
    public String getServerName() {
        return this.mc.propertyManagerObj.getStringProperty(SERVER_NAME, "Minecraft Server");
    }

    /**
     * Get an ID of this server. The ID is a simple generally alphanumeric
     * ID that can be used for uniquely identifying this server.
     *
     * @return The ID of this server
     */
    @Override
    public String getServerId() {
        return mc.propertyManagerObj.getStringProperty(SERVER_ID, UUID.fromString(this.getName()).toString());
    }

    /**
     * Gets whether this server has a whitelist or not.
     *
     * @return Whether this server has a whitelist or not.
     */
    @Override
    public boolean hasWhitelist() {
        return mc.propertyManagerObj.getBooleanProperty(WHITELIST_ENABLED, false);
    }

    /**
     * Broadcast a message to all players.
     *
     * @param message the message
     * @return the number of players
     */
    @Override
    public int broadcastMessage(String message) {
        int c = 0;
        for (Player p : this.getOnlinePlayers()) {
            p.sendMessage(message);
            c++;
        }
        return c;
    }

    /**
     * Gets the name of the update folder. The update folder is used to safely update
     * plugins at the right moment on a plugin load.
     *
     * @return The name of the update folder
     */
    @Override
    public String getUpdateFolder() {
        return "pluginUpdate";
    }

    /**
     * Gets a player object by the given username
     * <p>
     * This method may not return objects for offline players
     *
     * @param name Name to look up
     * @return Player if it was found, otherwise null
     */
    @Override
    public Player getPlayer(String name) {
        for (Player p : this.getOnlinePlayers()) {
            if (p.getName().equals(name)) return p;
        }
        return null;
    }

    /**
     * Attempts to match any players with the given name, and returns a list
     * of all possibly matches
     * <p>
     * This list is not sorted in any particular order. If an exact match is found,
     * the returned list will only contain a single result.
     *
     * @param name Name to match
     * @return List of all possible players
     */
    @Override
    public List<Player> matchPlayer(String name) {
        List<Player> pl = new ArrayList<>();
        for (Player p : this.getOnlinePlayers()) {
            if (p.getName().equals(name)) {
                pl.add(p);
            }
        }
        return pl;
    }

    /**
     * Gets the PluginManager for interfacing with plugins
     *
     * @return PluginManager for this Server instance
     */
    @Override
    public PluginManager getPluginManager() {
        return this.pluginMngr;
    }

    /**
     * Gets the Scheduler for managing scheduled events
     *
     * @return Scheduler for this Server instance
     */
    @Override
    public BukkitScheduler getScheduler() {
        return this.scheduler;
    }

    /**
     * Gets a services manager
     *
     * @return Services manager
     */
    @Override
    public ServicesManager getServicesManager() {
        return this.servicesMngr;
    }

    /**
     * Gets a list of all worlds on this server
     *
     * @return A list of worlds
     */
    @Override
    public List<World> getWorlds() {
        return new ArrayList<>(this.worldList);
    }

    /**
     * Creates or loads a world with the given name.
     * If the world is already loaded, it will just return the equivalent of
     * getWorld(name)
     *
     * @param name        Name of the world to load
     * @param environment Environment type of the world
     * @return Newly created or loaded World
     */
    @Override
    public World createWorld(String name, World.Environment environment) {
        LBWorld newWorld = new LBWorld(name);
        this.worldList.add(newWorld);
        return newWorld;
    }

    /**
     * Creates or loads a world with the given name.
     * If the world is already loaded, it will just return the equivalent of
     * getWorld(name)
     *
     * @param name        Name of the world to load
     * @param environment Environment type of the world
     * @param seed        Seed value to create the world with
     * @return Newly created or loaded World
     */
    @Override
    public World createWorld(String name, World.Environment environment, long seed) {
        LBWorld newWorld = new LBWorld(name, seed);
        this.worldList.add(newWorld);
        return newWorld;
    }

    /**
     * Creates or loads a world with the given name.
     * If the world is already loaded, it will just return the equivalent of
     * getWorld(name)
     *
     * @param name        Name of the world to load
     * @param environment Environment type of the world
     * @param generator   ChunkGenerator to use in the construction of the new world
     * @return Newly created or loaded World
     */
    @Override
    public World createWorld(String name, World.Environment environment, ChunkGenerator generator) {
        LBWorld newWorld = new LBWorld(name, generator);
        this.worldList.add(newWorld);
        return newWorld;
    }

    /**
     * Creates or loads a world with the given name.
     * If the world is already loaded, it will just return the equivalent of
     * getWorld(name)
     *
     * @param name        Name of the world to load
     * @param environment Environment type of the world
     * @param seed        Seed value to create the world with
     * @param generator   ChunkGenerator to use in the construction of the new world
     * @return Newly created or loaded World
     */
    @Override
    public World createWorld(String name, World.Environment environment, long seed, ChunkGenerator generator) {
        LBWorld newWorld = new LBWorld(name, seed, generator);
        this.worldList.add(newWorld);
        return newWorld;
    }

    /**
     * Unloads a world with the given name.
     *
     * @param name Name of the world to unload
     * @param save Whether to save the chunks before unloading.
     * @return Whether the action was Successful
     */
    @Override
    public boolean unloadWorld(String name, boolean save) {
        return this.unloadWorld(this.getWorld(name), save);
    }

    /**
     * Unloads the given world.
     *
     * @param world The world to unload
     * @param save  Whether to save the chunks before unloading.
     * @return Whether the action was Successful
     */
    @Override
    public boolean unloadWorld(World world, boolean save) {
        for (Chunk chunk : world.getLoadedChunks()) {
            if (!chunk.unload(save)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets the world with the given name
     *
     * @param name Name of the world to retrieve
     * @return World with the given name, or null if none exists
     */
    @Override
    public World getWorld(String name) {
        for (LBWorld world : this.worldList) {
            if (world.getName().equals(name)) return world;
        }
        return null;
    }

    /**
     * Gets the world from the given Unique ID
     *
     * @param uid Unique ID of the world to retrieve.
     * @return World with the given Unique ID, or null if none exists.
     */
    @Override
    public World getWorld(UUID uid) {
        for (LBWorld world : this.worldList) {
            if (world.getUID().equals(uid)) return world;
        }
        return null;
    }

    /**
     * Reloads the server, refreshing settings and plugin information
     */
    @Override
    public void reload() {
        Bukkit.setServer(new LilyBukkit(mc));
    }

    /**
     * Returns the primary logger associated with this server instance
     *
     * @return Logger associated with this server
     */
    @Override
    public Logger getLogger() {
        return Logger.getLogger("Minecraft");
    }

    /**
     * Gets a {@link PluginCommand} with the given name or alias
     *
     * @param name Name of the command to retrieve
     * @return PluginCommand if found, otherwise null
     */
    @Override
    public PluginCommand getPluginCommand(String name) {
        for (PluginCommand pluginCmd :
                this.pluginCommandList) {
            if (pluginCmd.getName().equals(name)) return pluginCmd;
        }
        return null;
    }

    /**
     * Writes loaded players to disk
     */
    @Override
    public void savePlayers() {
        for (Player player : this.getOnlinePlayers()) player.saveData();
    }

    /**
     * Dispatches a command on the server, and executes it if found.
     *
     * @param sender      {@link CommandSender} that executed the command
     * @param commandLine the command itself (with arguments)
     * @return targetFound returns false if no target is found.
     * @throws CommandException Thrown when the executor for the given command fails with an unhandled exception
     */
    @Override
    public boolean dispatchCommand(CommandSender sender, String commandLine) {
        return this.commandMap.dispatch(sender, commandLine);
    }

    /**
     * Populates a given {@link ServerConfig} with values attributes to this server
     *
     * @param config ServerConfig to populate
     */
    @Override
    public void configureDbConfig(ServerConfig config) {
        // THE FOLLOWING CODE IS TAKEN FROM CRAFTBUKKIT `54bcd1c1f36691a714234e5ca2f30a20b3ad2816`\\

        // CraftServer
        Configuration configuration = new Configuration(new File("lilybukkit.cfg"));

        // loadConfig
        configuration.load();
        configuration.getString("database.url", "jdbc:sqlite:{DIR}{NAME}.db");
        configuration.getString("database.username", "bukkit");
        configuration.getString("database.password", "walrus");
        configuration.getString("database.driver", "org.sqlite.JDBC");
        configuration.getString("database.isolation", "SERIALIZABLE");

        configuration.getString("settings.update-folder", this.getUpdateFolder());
        configuration.getInt("settings.spawn-radius", this.getSpawnRadius());

        configuration.getString("settings.permissions-file", "permissions.yml");

        if (configuration.getNode("aliases") == null) {
            List<String> icanhasbukkit = new ArrayList<String>();
            icanhasbukkit.add("version");
            configuration.setProperty("aliases.icanhasbukkit", icanhasbukkit);
        }
        configuration.save();

        // configureDbConfig
        DataSourceConfig ds = new DataSourceConfig();
        ds.setDriver(configuration.getString("database.driver"));
        ds.setUrl(configuration.getString("database.url"));
        ds.setUsername(configuration.getString("database.username"));
        ds.setPassword(configuration.getString("database.password"));
        ds.setIsolationLevel(TransactionIsolation.getLevel(configuration.getString("database.isolation")));

        if (ds.getDriver().contains("sqlite")) {
            config.setDatabasePlatform(new SQLitePlatform());
            config.getDatabasePlatform().getDbDdlSyntax().setIdentity("");
        }

        config.setDataSourceConfig(ds);
        // END OF CRAFTBUKKIT CODE \\
    }

    /**
     * Adds a recipe to the crafting manager.
     *
     * @param recipe The recipe to add.
     * @return True to indicate that the recipe was added.
     */
    @Override
    public boolean addRecipe(Recipe recipe) {
        return this.recipeManager.add(recipe);
    }

    /**
     * Gets a list of command aliases defined in the server properties.
     *
     * @return Map of aliases to command names
     */
    @Override
    public Map<String, String[]> getCommandAliases() {
        Map<String, String[]> commandAliases = new HashMap<>();
        for (Command command : this.commandList) {
            commandAliases.put(command.getName(), command.getAliases().toArray(new String[]{}));
        }
        return commandAliases;
    }

    /**
     * Gets the radius, in blocks, around each worlds spawn point to protect
     *
     * @return Spawn radius, or 0 if none
     */
    @Override
    public int getSpawnRadius() {
        return this.mc.propertyManagerObj.getIntProperty(SPAWN_PROTECTION, 0);
    }

    /**
     * Sets the radius, in blocks, around each worlds spawn point to protect
     *
     * @param value New spawn radius, or 0 if none
     */
    @Override
    public void setSpawnRadius(int value) {
        this.mc.propertyManagerObj.getIntProperty(SPAWN_PROTECTION, value);
    }

    /**
     * Gets whether the Server is in online mode or not.
     *
     * @return Whether the server is in online mode.
     */
    @Override
    public boolean getOnlineMode() {
        return this.mc.propertyManagerObj.getBooleanProperty(ONLINE_MODE, true);
    }

    /**
     * Gets whether this server allows flying or not.
     *
     * @return Whether this server allows flying or not.
     */
    @Override
    public boolean getAllowFlight() {
        return this.mc.propertyManagerObj.getBooleanProperty(ALLOW_FLIGHT, false);
    }

    /**
     * I don't remember if it existed.<br>
     * Gets whether this server allows PVP or not.
     *
     * @return whether this server allows PVP or not
     */
    @Override
    public boolean getPVPEnabled() {
        return this.mc.propertyManagerObj.getBooleanProperty(PVP_ENABLED, false);
    }
}
