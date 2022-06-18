package ru.vtm.lilybukkit.entity;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.net.InetSocketAddress;
import java.util.Set;

public class LBPlayer extends LBLivingEntity implements Player {

    /**
     * Checks if this player is currently online
     *
     * @return true if they are online
     */
    @Override
    public boolean isOnline() {
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the "friendly" name to display of this player. This may include color.
     * <p>
     * Note that this name will not be displayed in game, only in chat and places
     * defined by plugins
     *
     * @param name
     */
    @Override
    public void setDisplayName(String name) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the target of the player's compass.
     *
     * @param loc
     */
    @Override
    public void setCompassTarget(Location loc) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the previously set compass target.
     *
     * @return location of the target
     */
    @Override
    public Location getCompassTarget() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the socket address of this player
     *
     * @return the player's address
     */
    @Override
    public InetSocketAddress getAddress() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sends this sender a message raw
     *
     * @param message Message to be displayed
     */
    @Override
    public void sendRawMessage(String message) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Kicks player with custom kick message.
     *
     * @param message kick message
     */
    @Override
    public void kickPlayer(String message) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Says a message (or runs a command).
     *
     * @param msg message to print
     */
    @Override
    public void chat(String msg) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Makes the player perform the given command
     *
     * @param command Command to perform
     * @return true if the command was successful, otherwise false
     */
    @Override
    public boolean performCommand(String command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns if the player is in sneak mode
     *
     * @return true if player is in sneak mode
     */
    @Override
    public boolean isSneaking() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the sneak mode the player
     *
     * @param sneak true if player should appear sneaking
     */
    @Override
    public void setSneaking(boolean sneak) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Saves the players current location, health, inventory, motion, and other information into the username.dat file, in the world/player folder
     */
    @Override
    public void saveData() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Loads the players current location, health, inventory, motion, and other information from the username.dat file, in the world/player folder
     * <p>
     * Note: This will overwrite the players current inventory, health, motion, etc, with the state from the saved dat file.
     */
    @Override
    public void loadData() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets whether the player is ignored as not sleeping. If everyone is
     * either sleeping or has this flag set, then time will advance to the
     * next day. If everyone has this flag set but no one is actually in bed,
     * then nothing will happen.
     *
     * @param isSleeping
     */
    @Override
    public void setSleepingIgnored(boolean isSleeping) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns whether the player is sleeping ignored.
     *
     * @return
     */
    @Override
    public boolean isSleepingIgnored() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Play a note for a player at a location. This requires a note block
     * at the particular location (as far as the client is concerned). This
     * will not work without a note block. This will not work with cake.
     *
     * @param loc
     * @param instrument
     * @param note
     */
    @Override
    public void playNote(Location loc, byte instrument, byte note) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Play a note for a player at a location. This requires a note block
     * at the particular location (as far as the client is concerned). This
     * will not work without a note block. This will not work with cake.
     *
     * @param loc
     * @param instrument
     * @param note
     */
    @Override
    public void playNote(Location loc, Instrument instrument, Note note) {
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Send a block change. This fakes a block change packet for a user at
     * a certain location. This will not actually change the world in any way.
     *
     * @param loc
     * @param material
     * @param data
     */
    @Override
    public void sendBlockChange(Location loc, Material material, byte data) {
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Send a block change. This fakes a block change packet for a user at
     * a certain location. This will not actually change the world in any way.
     *
     * @param loc
     * @param material
     * @param data
     */
    @Override
    public void sendBlockChange(Location loc, int material, byte data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Render a map and send it to the player in its entirety. This may be used
     * when streaming the map in the normal manner is not desirbale.
     *
     * @param map
     * @pram map The map to be sent
     */
    @Override
    public void sendMap(MapView map) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Forces an update of the player's entire inventory.
     *
     * @deprecated This method should not be relied upon as it is a temporary work-around for a larger, more complicated issue.
     */
    @Override
    public void updateInventory() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Awards this player the given achievement
     *
     * @param achievement Achievement to award
     */
    @Override
    public void awardAchievement(Achievement achievement) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Increments the given statistic for this player
     *
     * @param statistic Statistic to increment
     */
    @Override
    public void incrementStatistic(Statistic statistic) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Increments the given statistic for this player
     *
     * @param statistic Statistic to increment
     * @param amount    Amount to increment this statistic by
     */
    @Override
    public void incrementStatistic(Statistic statistic, int amount) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Increments the given statistic for this player for the given material
     *
     * @param statistic Statistic to increment
     * @param material  Material to offset the statistic with
     */
    @Override
    public void incrementStatistic(Statistic statistic, Material material) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Increments the given statistic for this player for the given material
     *
     * @param statistic Statistic to increment
     * @param material  Material to offset the statistic with
     * @param amount    Amount to increment this statistic by
     */
    @Override
    public void incrementStatistic(Statistic statistic, Material material, int amount) {
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the player's current timestamp.
     *
     * @return
     */
    @Override
    public long getPlayerTime() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the player's current time offset relative to server time, or the current player's fixed time
     * if the player's time is absolute.
     *
     * @return
     */
    @Override
    public long getPlayerTimeOffset() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns true if the player's time is relative to the server time, otherwise the player's time is absolute and
     * will not change its current time unless done so with setPlayerTime().
     *
     * @return true if the player's time is relative to the server time.
     */
    @Override
    public boolean isPlayerTimeRelative() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Restores the normal condition where the player's time is synchronized with the server time.
     * Equivalent to calling setPlayerTime(0, true).
     */
    @Override
    public void resetPlayerTime() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sends this sender a message
     *
     * @param message Message to be displayed
     */
    @Override
    public void sendMessage(String message) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the name of this player
     *
     * @return Player name
     */
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the player's inventory.
     *
     * @return The inventory of the player, this also contains the armor slots.
     */
    @Override
    public PlayerInventory getInventory() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the ItemStack currently in your hand, can be empty.
     *
     * @return The ItemStack of the item you are currently holding.
     */
    @Override
    public ItemStack getItemInHand() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the item to the given ItemStack, this will replace whatever the
     * user was holding.
     *
     * @param item The ItemStack which will end up in the hand
     * @return
     */
    @Override
    public void setItemInHand(ItemStack item) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns whether this player is slumbering.
     *
     * @return slumber state
     */
    @Override
    public boolean isSleeping() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the sleep ticks of the player. This value may be capped.
     *
     * @return slumber ticks
     */
    @Override
    public int getSleepTicks() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Checks if this object contains an override for the specified permission, by fully qualified name
     *
     * @param name Name of the permission
     * @return true if the permission is set, otherwise false
     */
    @Override
    public boolean isPermissionSet(String name) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Checks if this object contains an override for the specified {@link Permission}
     *
     * @param perm Permission to check
     * @return true if the permission is set, otherwise false
     */
    @Override
    public boolean isPermissionSet(Permission perm) {
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Adds a new empty {@link PermissionAttachment} to this object
     *
     * @param plugin Plugin responsible for this attachment, may not be null or disabled
     * @return The PermissionAttachment that was just created
     */
    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Removes the given {@link PermissionAttachment} from this object
     *
     * @param attachment Attachment to remove
     * @throws IllegalArgumentException Thrown when the specified attachment isn't part of this object
     */
    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Recalculates the permissions for this object, if the attachments have changed values.
     * <p>
     * This should very rarely need to be called from a plugin.
     */
    @Override
    public void recalculatePermissions() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets a set containing all of the permissions currently in effect by this object
     *
     * @return Set of currently effective permissions
     */
    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Checks if this object is a server operator
     *
     * @return true if this is an operator, otherwise false
     */
    @Override
    public boolean isOp() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the operator status of this object
     *
     * @param value New operator value
     */
    @Override
    public void setOp(boolean value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
