package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.Packet4UpdateTime;
import net.minecraft.src.Packet51MapChunk;
import net.minecraft.src.Packet53BlockChange;
import net.minecraft.src.Packet5PlayerInventory;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.PermissibleBase;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import ru.vladthemountain.lilybukkit.LBWorld;
import ru.vladthemountain.lilybukkit.LilyBukkit;
import ru.vladthemountain.lilybukkit.inventory.LBPlayerInventory;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;

/**
 * @author VladTheMountain
 */
public class LBPlayer extends LBLivingEntity implements Player {

    EntityPlayerMP entity;
    String displayName;
    Location spawnPoint;
    World world;
    LBPlayerInventory inventory;
    long playerTime;

    final PermissibleBase permissibleBase;

    public LBPlayer(World w, EntityPlayerMP p) {
        super(w, p);
        this.entity = p;
        this.world = w;
        this.displayName = p.username;
        this.spawnPoint = new Location(this.world, p.worldObj.spawnX, p.worldObj.spawnY, p.worldObj.spawnZ);
        this.inventory = new LBPlayerInventory(this.entity.inventory);
        this.playerTime = this.world.getTime();
        this.permissibleBase = new PermissibleBase(this);
    }

    /**
     * Checks if this player is currently online
     *
     * @return true if they are online
     */
    @Override
    public boolean isOnline() {
        for (Player p : this.getServer().getOnlinePlayers()) {
            if (p.equals(this)) return true;
        }
        return false;
    }

    /**
     * Gets the "friendly" name to display of this player. This may include color.
     * <p>
     * Note that this name will not be displayed in game, only in chat and places
     * defined by plugins
     *
     * @return the friendly name
     */
    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Sets the "friendly" name to display of this player. This may include color.
     * <p>
     * Note that this name will not be displayed in game, only in chat and places
     * defined by plugins
     */
    @Override
    public void setDisplayName(String name) {
        this.displayName = name;
    }

    @Override
    public String getPlayerListName() {
        return this.displayName;
    }

    @Override
    public void setPlayerListName(String s) {
        this.displayName = s;
    }

    /**
     * Set the target of the player's compass.
     */
    @Override
    public void setCompassTarget(Location loc) {
        this.spawnPoint = loc;
    }

    /**
     * Get the previously set compass target.
     *
     * @return location of the target
     */
    @Override
    public Location getCompassTarget() {
        return this.spawnPoint;
    }

    /**
     * Gets the socket address of this player
     *
     * @return the player's address
     */
    @Override
    public InetSocketAddress getAddress() {
        String fullAddress = this.entity.playerNetServerHandler.netManager.getRemoteAddress().toString();
        return new InetSocketAddress(fullAddress.substring(0, fullAddress.indexOf(':')), new Integer(fullAddress.substring(fullAddress.indexOf(':'))));
    }

    /**
     * Sends this sender a message raw
     *
     * @param message Message to be displayed
     */
    @Override
    public void sendRawMessage(String message) {
        this.entity.playerNetServerHandler.sendPacket(new Packet3Chat(message));
    }

    /**
     * Kicks player with custom kick message.
     *
     * @param message kick message
     */
    @Override
    public void kickPlayer(String message) {
        this.entity.playerNetServerHandler.kickPlayer(message);
    }

    /**
     * Says a message (or runs a command).
     *
     * @param msg message to print
     */
    @Override
    public void chat(String msg) {
        if (msg.startsWith("/")) {
            this.getServer().dispatchCommand(this, msg);
        } else {
            this.sendMessage(msg);
        }
    }

    /**
     * Makes the player perform the given command
     *
     * @param command Command to perform
     * @return true if the command was successful, otherwise false
     */
    @Override
    public boolean performCommand(String command) {
        this.getServer().getLogger().info("org.bukkit.Server.dispatchCommand(" + this.getName() + "," + command + ")");
        return this.getServer().dispatchCommand(this, command);
    }

    /**
     * Saves the players current location, health, inventory, motion, and other information into the username.dat file, in the world/player folder
     */
    @Override
    public void saveData() {
        this.world.save();
    }

    /**
     * Loads the players current location, health, inventory, motion, and other information from the username.dat file, in the world/player folder
     * <p>
     * Note: This will overwrite the players current inventory, health, motion, etc, with the state from the saved dat file.
     */
    @Override
    public void loadData() {
        new LBPlayer(this.world, this.entity);
    }

    /**
     * Plays an effect to just this player.
     *
     * @param loc    the player to play the effect for
     * @param effect the {@link Effect}
     * @param data   a data bit needed for the RECORD_PLAY, SMOKE, and STEP_SOUND sounds
     */
    @Override
    public void playEffect(Location loc, Effect effect, int data) {
        this.entity.mcServer.worldMngr.playSoundAtEntity(this.entity, effect.name(), 100, data); // minus ears
    }

    /**
     * Send a block change. This fakes a block change packet for a user at
     * a certain location. This will not actually change the world in any way.
     */
    @Override
    public void sendBlockChange(Location loc, Material material, byte data) {
        this.sendBlockChange(loc, material.getId(), data);
    }

    /**
     * Send a chunk change. This fakes a chunk change packet for a user at
     * a certain location. The updated cuboid must be entirely within a single
     * chunk.  This will not actually change the world in any way.
     * <p>
     * At least one of the dimensions of the cuboid must be even. The size of the
     * data buffer must be 2.5*sx*sy*sz and formatted in accordance with the Packet51
     * format.
     *
     * @param loc  The location of the cuboid
     * @param sx   The x size of the cuboid
     * @param sy   The y size of the cuboid
     * @param sz   The z size of the cuboid
     * @param data The data to be sent
     * @return true if the chunk change packet was sent
     */
    @Override
    public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) {
        Packet51MapChunk packet = new Packet51MapChunk(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), sx, sy, sz, this.entity.mcServer.worldMngr);
        packet.chunkData = data;
        this.entity.playerNetServerHandler.handleMapChunk(packet);
        return true;
    }

    /**
     * Send a block change. This fakes a block change packet for a user at
     * a certain location. This will not actually change the world in any way.
     */
    @Override
    public void sendBlockChange(Location loc, int material, byte data) {
        Packet53BlockChange packet = new Packet53BlockChange(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), this.entity.mcServer.worldMngr);
        packet.type = material;
        packet.metadata = data;
        this.entity.playerNetServerHandler.handleBlockChange(packet);
    }

    /**
     * Forces an update of the player's entire inventory.
     *
     * @deprecated This method should not be relied upon as it is a temporary work-around for a larger, more complicated issue.
     */
    @Override
    public void updateInventory() {
        this.entity.playerNetServerHandler.handlePlayerInventory(new Packet5PlayerInventory());
    }

    /**
     * Sets the current time on the player's client. When relative is true the player's time
     * will be kept synchronized to its world time with the specified offset.
     * <p>
     * When using non relative time the player's time will stay fixed at the specified time parameter. It's up to
     * the caller to continue updating the player's time. To restore player time to normal use resetPlayerTime().
     *
     * @param time     The current player's perceived time or the player's time offset from the server time.
     * @param relative When true the player time is kept relative to its world time.
     */
    @Override
    public void setPlayerTime(long time, boolean relative) {
        if (relative) {
            this.entity.playerNetServerHandler.handleUpdateTime(new Packet4UpdateTime(this.world.getTime() + time));
            playerTime = this.world.getTime() + time;
        } else {
            playerTime = time;
        }
    }

    /**
     * Returns the player's current timestamp.
     */
    @Override
    public long getPlayerTime() {
        return this.playerTime;
    }

    /**
     * Returns the player's current time offset relative to server time, or the current player's fixed time
     * if the player's time is absolute.
     */
    @Override
    public long getPlayerTimeOffset() {
        return this.world.getTime() - this.playerTime;
    }

    /**
     * Returns true if the player's time is relative to the server time, otherwise the player's time is absolute and
     * will not change its current time unless done so with setPlayerTime().
     *
     * @return true if the player's time is relative to the server time.
     */
    @Override
    public boolean isPlayerTimeRelative() {
        return this.world.getTime() == this.playerTime;
    }

    /**
     * Restores the normal condition where the player's time is synchronized with the server time.
     * Equivalent to calling setPlayerTime(0, true).
     */
    @Override
    public void resetPlayerTime() {
        this.setPlayerTime(0, true);
    }

    /**
     * Sends this sender a message
     *
     * @param message Message to be displayed
     */
    @Override
    public void sendMessage(String message) {
        this.sendRawMessage(message);
    }

    /**
     * Returns the name of this player
     *
     * @return Player name
     */
    @Override
    public String getName() {
        return this.entity.username;
    }

    @Override
    public boolean isBanned() {
        return ((LilyBukkit) this.getServer()).getConfigManager().bannedPlayers.contains(this.getName());
    }

    @Override
    public void setBanned(boolean b) {
        if (b) ((LilyBukkit) this.getServer()).getConfigManager().banPlayer(this.getName());
        else ((LilyBukkit) this.getServer()).getConfigManager().pardonPlayer(this.getName());
    }

    @Override
    public boolean isWhitelisted() {
        return ((LilyBukkit) this.getServer()).getConfigManager().whitelistedPlayers.contains(this.getName());
    }

    @Override
    public void setWhitelisted(boolean b) {
        if (b) ((LilyBukkit) this.getServer()).getConfigManager().whitelistPlayer(this.getName());
        else ((LilyBukkit) this.getServer()).getConfigManager().unwhitelistPlayer(this.getName());
    }

    @Override
    public boolean isIPWhitelisted() {
        return ((LilyBukkit) this.getServer()).getConfigManager().whitelistedIPs.contains(this.getName());
    }

    @Override
    public void setIPWhitelisted(boolean b) {
        if (b) ((LilyBukkit) this.getServer()).getConfigManager().whitelistIP(this.getName());
        else ((LilyBukkit) this.getServer()).getConfigManager().unwhitelistIP(this.getName());
    }

    /**
     * Get the player's inventory.
     *
     * @return The inventory of the player, this also contains the armor slots.
     */
    @Override
    public PlayerInventory getInventory() {
        return this.inventory;
    }

    /**
     * Returns the ItemStack currently in your hand, can be empty.
     *
     * @return The ItemStack of the item you are currently holding.
     */
    @Override
    public ItemStack getItemInHand() {
        return this.inventory.getItemInHand();
    }

    /**
     * Sets the item to the given ItemStack, this will replace whatever the
     * user was holding.
     *
     * @param item The ItemStack which will end up in the hand
     */
    @Override
    public void setItemInHand(ItemStack item) {
        this.inventory.setItemInHand(item);
    }

    /**
     * Checks if this object contains an override for the specified permission, by fully qualified name
     *
     * @param name Name of the permission
     * @return true if the permission is set, otherwise false
     */
    @Override
    public boolean isPermissionSet(String name) {
        return this.permissibleBase.isPermissionSet(name);
    }

    /**
     * Checks if this object contains an override for the specified {@link Permission}
     *
     * @param perm Permission to check
     * @return true if the permission is set, otherwise false
     */
    @Override
    public boolean isPermissionSet(Permission perm) {
        return this.permissibleBase.isPermissionSet(perm);
    }

    /**
     * Gets the value of the specified permission, if set.
     * <p>
     * If a permission override is not set on this object, the default value of the permission will be returned.
     *
     * @param name Name of the permission
     * @return Value of the permission
     */
    @Override
    public boolean hasPermission(String name) {
        return this.permissibleBase.hasPermission(name);
    }

    /**
     * Gets the value of the specified permission, if set.
     * <p>
     * If a permission override is not set on this object, the default value of the permission will be returned
     *
     * @param perm Permission to get
     * @return Value of the permission
     */
    @Override
    public boolean hasPermission(Permission perm) {
        return this.permissibleBase.hasPermission(perm);
    }

    /**
     * Adds a new {@link PermissionAttachment} with a single permission by name and value
     *
     * @param plugin Plugin responsible for this attachment, may not be null or disabled
     * @param name   Name of the permission to attach
     * @param value  Value of the permission
     * @return The PermissionAttachment that was just created
     */
    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return this.permissibleBase.addAttachment(plugin, name, value);
    }

    /**
     * Adds a new empty {@link PermissionAttachment} to this object
     *
     * @param plugin Plugin responsible for this attachment, may not be null or disabled
     * @return The PermissionAttachment that was just created
     */
    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return this.permissibleBase.addAttachment(plugin);
    }

    /**
     * Temporarily adds a new {@link PermissionAttachment} with a single permission by name and value
     *
     * @param plugin Plugin responsible for this attachment, may not be null or disabled
     * @param name   Name of the permission to attach
     * @param value  Value of the permission
     * @param ticks  Amount of ticks to automatically remove this attachment after
     * @return The PermissionAttachment that was just created
     */
    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return this.permissibleBase.addAttachment(plugin, name, value, ticks);
    }

    /**
     * Temporarily adds a new empty {@link PermissionAttachment} to this object
     *
     * @param plugin Plugin responsible for this attachment, may not be null or disabled
     * @param ticks  Amount of ticks to automatically remove this attachment after
     * @return The PermissionAttachment that was just created
     */
    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return this.permissibleBase.addAttachment(plugin, ticks);
    }

    /**
     * Removes the given {@link PermissionAttachment} from this object
     *
     * @param attachment Attachment to remove
     * @throws IllegalArgumentException Thrown when the specified attachment isn't part of this object
     */
    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        this.permissibleBase.removeAttachment(attachment);
    }

    /**
     * Recalculates the permissions for this object, if the attachments have changed values.
     * <p>
     * This should very rarely need to be called from a plugin.
     */
    @Override
    public void recalculatePermissions() {
        this.permissibleBase.recalculatePermissions();
    }

    /**
     * Gets a set containing all of the permissions currently in effect by this object
     *
     * @return Set of currently effective permissions
     */
    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return this.permissibleBase.getEffectivePermissions();
    }

    /**
     * Checks if this object is a server operator
     *
     * @return true if this is an operator, otherwise false
     */
    @Override
    public boolean isOp() {
        return ((LilyBukkit) this.getServer()).isOp(this.getName());
    }

    /**
     * Sets the operator status of this object
     *
     * @param value New operator value
     */
    @Override
    public void setOp(boolean value) {
        if (value == this.isOp()) return;
        ((LilyBukkit) this.getServer()).setOp(this.getName(), value);
        this.recalculatePermissions();
    }

    // Attempts at fixing stuff
    public boolean isPlayer() {
        return true;
    }
}
