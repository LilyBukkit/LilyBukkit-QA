package ru.vladthemountain.lilybukkit;

import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.SQLitePlatform;
import com.avaje.ebeaninternal.server.lib.sql.TransactionIsolation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.PropertyManager;
import net.minecraft.src.ServerConfigurationManager;
import net.minecraft.src.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.command.defaults.HomeCommand;
import org.bukkit.command.defaults.IronCommand;
import org.bukkit.command.defaults.WoodCommand;
import org.bukkit.craftbukkit.scheduler.CraftScheduler;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.Recipe;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.SimpleServicesManager;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitWorker;
import org.bukkit.util.config.Configuration;
import org.bukkit.util.config.ConfigurationNode;
import org.bukkit.util.permissions.DefaultPermissions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.error.MarkedYAMLException;
import ru.vladthemountain.lilybukkit.command.ColouredConsoleSender;
import ru.vladthemountain.lilybukkit.entity.LBPlayer;
import ru.vladthemountain.lilybukkit.util.UpdateChecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
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
    public final List<LBWorld> worldList;
    private final List<Recipe> recipeManager;
    private final SimpleCommandMap commandMap;
    private final Set<OfflinePlayer> offlinePlayers;
    Configuration configuration = new Configuration(new File("config" + File.separator + "lilybukkit.yml"));

    public LilyBukkit(MinecraftServer parent) {
        this.mc = parent;
        this.scheduler = new CraftScheduler(this);
        this.servicesMngr = new SimpleServicesManager();
        this.worldList = new ArrayList<>();
        this.recipeManager = new ArrayList<>();
        this.commandMap = new SimpleCommandMap(this);
        this.pluginMngr = new SimplePluginManager(this, this.commandMap);
        this.offlinePlayers = new HashSet<>();
        Bukkit.setServer(this);
        UpdateChecker.checkForUpdates();
        // Plugin handling
        this.CRAFTBUKKIT_loadConfig();
        this.CRAFTBUKKIT_loadPlugins();
        MinecraftServer.logger.info("Plugins loaded");
        enablePluginsInOrder(PluginLoadOrder.STARTUP);
        MinecraftServer.logger.info("Plugins enabled");
        // Command addition
        this.commandMap.register("minecraft", new HomeCommand());
        this.commandMap.register("minecraft", new IronCommand());
        this.commandMap.register("minecraft", new WoodCommand());
        //
        MinecraftServer.logger.info("LilyBukkit initialized.");
    }

    /**
     * Gets the name of this server implementation
     *
     * @return name of this server implementation
     */
    @Override
    public String getName() {
        return "§2LilyBukkit";
    }

    /**
     * Gets the version string of this server implementation.
     *
     * @return version of this server implementation
     */
    @Override
    public String getVersion() {
        return "Alpha 1.1.0.2";
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
            playerList.add(new LBPlayer((LBWorld) this.getWorld(this.mc.worldMngr.levelName), (EntityPlayerMP) player));
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
        return this.broadcast(message, Server.BROADCAST_CHANNEL_USERS);
    }

    /**
     * Gets the name of the update folder. The update folder is used to safely update
     * plugins at the right moment on a plugin load.
     *
     * @return The name of the update folder
     */
    @Override
    public String getUpdateFolder() {
        return this.configuration.getString("settings.update-folder", "update");
    }

    @Override
    public File getUpdateFolderFile() {
        return new File(this.getUpdateFolder());
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

    @Override
    public Player getPlayerExact(String s) {
        //CraftBukkit begin
        String lname = s.toLowerCase();

        for (Player player : getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(lname)) {
                return player;
            }
        }

        return null;
        //CraftBukkit end
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
        LBWorld newWorld = new LBWorld(new WorldServer(new File(name), name, true));
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
        WorldServer nw = new WorldServer(new File(name), name, true);
        nw.randomSeed = seed;
        LBWorld newWorld = new LBWorld(nw);
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
        LBWorld newWorld = new LBWorld(new WorldServer(new File(name), name, true), generator);
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
        WorldServer nw = new WorldServer(new File(name), name, true);
        nw.randomSeed = seed;
        LBWorld newWorld = new LBWorld(nw, generator);
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
        //Modified CraftBukkit implementation
        this.CRAFTBUKKIT_loadConfig();
        PropertyManager config = new PropertyManager(new File("server.properties"));

        this.mc.propertyManagerObj = config;

        this.mc.ULPPOnlineMode = config.getBooleanProperty("online-mode", this.mc.ULPPOnlineMode);
        this.mc.configManager.maxPlayers = config.getIntProperty("max-players", this.mc.configManager.maxPlayers);
        this.mc.configManager.whitelistEnabled = config.getBooleanProperty("whitelist", this.mc.configManager.whitelistEnabled);
        this.mc.configManager.enforceRosepad = config.getBooleanProperty("enforce-rosepad", this.mc.configManager.enforceRosepad);

        this.pluginMngr.clearPlugins();
        this.commandMap.clearCommands();

        int pollCount = 0;

        // Wait for at most 2.5 seconds for plugins to close their threads
        while (pollCount < 50 && this.getScheduler().getActiveWorkers().size() > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                this.getLogger().log(Level.SEVERE, "[CraftBukkit] " + e.getMessage());
                e.printStackTrace();
            }
            pollCount++;
        }

        List<BukkitWorker> overdueWorkers = this.getScheduler().getActiveWorkers();
        for (BukkitWorker worker : overdueWorkers) {
            Plugin plugin = worker.getOwner();
            String author = "[CraftBukkit] <NoAuthorGiven>";
            if (plugin.getDescription().getAuthors().size() > 0) {
                author = plugin.getDescription().getAuthors().get(0);
            }
            this.getLogger().log(Level.SEVERE, String.format(
                    "Nag author: '%s' of '%s' about the following: %s",
                    author,
                    plugin.getDescription().getName(),
                    "This plugin is not properly shutting down its async tasks when it is being reloaded.  This may cause conflicts with the newly loaded version of the plugin"
            ));
        }
        this.CRAFTBUKKIT_loadPlugins();
        this.enablePluginsInOrder(PluginLoadOrder.STARTUP);
        this.enablePluginsInOrder(PluginLoadOrder.POSTWORLD);
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
        if (this.commandMap.getCommand(name) instanceof PluginCommand)
            return (PluginCommand) this.commandMap.getCommand(name);
        else return null;
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
        if (this.commandMap.dispatch(sender, commandLine)) return true;
        sender.sendMessage("[LilyBukkit] Couldn't process the command. The valid commands are: /reload, /plugins, /version. Type \"help\" for vanilla commands.");
        return false;
    }

    /**
     * Populates a given {@link ServerConfig} with values attributes to this server
     *
     * @param config ServerConfig to populate
     */
    @Override
    public void configureDbConfig(ServerConfig config) {
        // THE FOLLOWING CODE IS TAKEN FROM CRAFTBUKKIT `54bcd1c1f36691a714234e5ca2f30a20b3ad2816`\\
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
        //CraftBukkit start
        ConfigurationNode node = configuration.getNode("aliases");
        Map<String, String[]> commandAliases = new LinkedHashMap<>();

        if (node != null) {
            for (String key : node.getKeys()) {
                List<String> commands = new ArrayList<>();

                if (node.getProperty(key) instanceof List) {
                    commands = node.getStringList(key, null);
                } else {
                    commands.add(node.getString(key));
                }

                commandAliases.put(key, commands.toArray(new String[0]));
            }
        }

        return commandAliases;
        //CraftBukkit end
    }

    /**
     * Gets the radius, in blocks, around each worlds spawn point to protect
     *
     * @return Spawn radius, or 0 if none
     */
    @Override
    public int getSpawnRadius() {
        return configuration.getInt("settings.spawn-radius", 16);
    }

    /**
     * Sets the radius, in blocks, around each worlds spawn point to protect
     *
     * @param value New spawn radius, or 0 if none
     */
    @Override
    public void setSpawnRadius(int value) {
        configuration.setProperty("settings.spawn-radius", value);
        configuration.save();
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

    @Override
    public void setWhitelist(boolean b) {
        if (b) this.mc.configManager.enableWhitelist();
        else this.mc.configManager.disableWhitelist();
    }

    @Override
    public Set<OfflinePlayer> getWhitelistedPlayers() {
        Set<OfflinePlayer> whitelisted = new HashSet<>();
        for (String username : this.mc.configManager.whitelistedPlayers) {
            whitelisted.add(new LBOfflinePlayer(this, username));
        }
        return whitelisted;
    }

    @Override
    public void reloadWhitelist() {
        this.mc.configManager.disableWhitelist();
        this.mc.configManager.enableWhitelist();
    }

    @Override
    public void shutdown() {
        this.mc.stopRunning();
    }

    @Override
    public int broadcast(String s, String s1) {
        //CraftBukkit start
        int c = 0;
        Set<Permissible> players = this.getPluginManager().getPermissionSubscriptions(s1);

        for (Permissible p : players) {
            if (p instanceof CommandSender) {
                ((CommandSender) p).sendMessage(s);
                c++;
            }
        }
        return c;
        //CraftBukkit end
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String s) {
        OfflinePlayer player = (OfflinePlayer) this.getPlayer(s);

        if (player == null) {
            player = new LBOfflinePlayer(this, s);
            this.offlinePlayers.add(player);
        }
        return player;
    }

    @Override
    public Set<String> getIPBans() {
        return this.mc.configManager.bannedIPs;
    }

    @Override
    public void banIP(String s) {
        this.mc.configManager.banIP(s);
    }

    @Override
    public void unbanIP(String s) {
        this.mc.configManager.pardonIP(s);
    }

    @Override
    public Set<OfflinePlayer> getBannedPlayers() {
        Set<OfflinePlayer> players = new HashSet<>();
        for (String username : this.mc.configManager.bannedPlayers) {
            players.add(new LBOfflinePlayer(this, username));
        }
        return players;
    }

    @Override
    public Set<OfflinePlayer> getOperators() {
        Set<OfflinePlayer> players = new HashSet<>();
        for (String username : this.mc.configManager.ops) {
            players.add(new LBOfflinePlayer(this, username));
        }
        return players;
    }

    @Override
    public ConsoleCommandSender getConsoleSender() {
        return new ColouredConsoleSender(this);
    }

    // Utility methods
    public void enablePluginsInOrder(PluginLoadOrder order) {
        for (Plugin p : this.pluginMngr.getPlugins()) {
            if (!p.isEnabled() && p.getDescription().getLoad().equals(order)) {
                this.pluginMngr.enablePlugin(p);
                for (Permission perm : p.getDescription().getPermissions()) {
                    this.pluginMngr.addPermission(perm);
                }
            }
        }
        MinecraftServer.logger.info("[LilyBukkit] Plugins enabled in order " + order.name());

        if (order.equals(PluginLoadOrder.POSTWORLD)) {
            //Loading custom permissions
            CRAFTBUKKIT_loadCustomPermissions();
            MinecraftServer.logger.info("[LilyBukkit] Custom permissions loaded");
            //Loading default permissions
            DefaultPermissions.registerCorePermissions();
            MinecraftServer.logger.info("[LilyBukkit] Default permissions loaded");
        }
    }

    private void CRAFTBUKKIT_loadCustomPermissions() {
        File file = new File(configuration.getString("settings.permissions-file"));
        FileInputStream stream = null;

        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                getLogger().log(Level.SEVERE, "[CraftBukkit] Couldn't create file " + file, e);
            }
        }

        Map<String, Map<String, Object>> perms;

        try {
            perms = (Map<String, Map<String, Object>>) new Yaml(new SafeConstructor()).load(stream);
        } catch (MarkedYAMLException ex) {
            getLogger().log(Level.WARNING, "[CraftBukkit] Server permissions file " + file + " is not valid YAML: " + ex.toString());
            return;
        } catch (Throwable ex) {
            getLogger().log(Level.WARNING, "[CraftBukkit] Server permissions file " + file + " is not valid YAML.", ex);
            return;
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                getLogger().log(Level.SEVERE, "[CraftBukkit] Couldn't close the InputStream from file " + file, ex);
            }
        }

        if (perms == null) {
            getLogger().log(Level.INFO, "[CraftBukkit] Server permissions file " + file + " is empty, ignoring it");
            return;
        }

        Set<String> keys = perms.keySet();

        for (String name : keys) {
            try {
                this.pluginMngr.addPermission(Permission.loadPermission(name, perms.get(name)));
            } catch (Throwable ex) {
                getLogger().log(Level.SEVERE, "[CraftBukkit] Permission node '" + name + "' in server config is invalid", ex);
            }
        }
    }

    public boolean isOp(String nickname) {
        return this.mc.configManager.isOp(nickname);
    }

    public void setOp(String name, boolean value) {
        if (value) {
            this.mc.configManager.opPlayer(name);
        } else {
            this.mc.configManager.deopPlayer(name);
        }
    }

    public boolean addExistingWorld(WorldServer w) {
        return this.worldList.add(new LBWorld(w));
    }

    public void CRAFTBUKKIT_loadPlugins() {
        this.pluginMngr.registerInterface(JavaPluginLoader.class);
        File pluginDir = new File("plugins");
        if (pluginDir.exists()) {
            for (Plugin plugin : this.pluginMngr.loadPlugins(pluginDir)) {
                plugin.onLoad();
            }
        } else {
            pluginDir.mkdir();
        }
    }

    private void CRAFTBUKKIT_loadConfig() {
        configuration.load();
        configuration.getString("database.url", "jdbc:sqlite:{DIR}{NAME}.db");
        configuration.getString("database.username", "bukkit");
        configuration.getString("database.password", "walrus");
        configuration.getString("database.driver", "org.sqlite.JDBC");
        configuration.getString("database.isolation", "SERIALIZABLE");

        configuration.getString("settings.update-folder", "update");
        configuration.getInt("settings.spawn-radius", 16);

        configuration.getString("settings.permissions-file", "permissions.yml");

        if (configuration.getNode("aliases") == null) {
            List<String> icanhasbukkit = new ArrayList<String>();
            icanhasbukkit.add("version");
            configuration.setProperty("aliases.icanhasbukkit", icanhasbukkit);
        }
        configuration.save();
    }

    public ServerConfigurationManager getConfigManager() {
        return this.mc.configManager;
    }

    public int[] getRosepadVersion() {
        int beginIndex = this.getVersion().indexOf(" ") + 1;
        String ver = this.getVersion().substring(beginIndex);
        String[] version = ver.split("\\.");
        int[] result = new int[version.length];
        for (int i = 0; i < version.length; i++) {
            result[i] = Integer.parseInt(version[i]);
        }
        return result;
    }

    public String getRosepadVersionTag() {
        return this.getVersion().substring(0, this.getVersion().indexOf(" ")).toLowerCase();
    }
}
