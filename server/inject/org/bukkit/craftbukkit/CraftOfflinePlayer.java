package org.bukkit.craftbukkit;

import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import ru.vladthemountain.lilybukkit.LilyBukkit;

import java.util.Map;

public class CraftOfflinePlayer implements OfflinePlayer {
    private final String name;
    private final LilyBukkit server;

    public CraftOfflinePlayer(LilyBukkit server, String name) {
        this.server = server;
        this.name = name;
    }

    public boolean isOnline() {
        return false;
    }

    public String getName() {
        return name;
    }

    public Server getServer() {
        return server;
    }

    public boolean isOp() {
        return server.getHandle().isOp(getName().toLowerCase());
    }

    public void setOp(boolean value) {
        if (value == isOp()) return;

        if (value) {
            server.getHandle().opPlayer(getName().toLowerCase());
        } else {
            server.getHandle().deopPlayer(getName().toLowerCase());
        }
    }

    public boolean isBanned() {
        return server.getHandle().bannedPlayers.contains(name.toLowerCase());
    }

    public void setBanned(boolean value) {
        if (value) {
            server.getHandle().banPlayer(name.toLowerCase());
        } else {
            server.getHandle().pardonPlayer(name.toLowerCase());
        }
    }

    public boolean isWhitelisted() {
        return server.getHandle().whitelistedPlayers.contains(name.toLowerCase());
    }

    public void setWhitelisted(boolean value) {
        if (value) {
            server.getHandle().whitelistPlayer(name.toLowerCase());
        } else {
            server.getHandle().unwhitelistPlayer(name.toLowerCase());
        }
    }

    @Override
    public Player getPlayer() {
        return server.getPlayer(name);
    }

    @Override
    public Map<String, Object> serialize() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}