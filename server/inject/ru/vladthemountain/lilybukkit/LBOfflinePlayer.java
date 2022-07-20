package ru.vladthemountain.lilybukkit;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public class LBOfflinePlayer implements OfflinePlayer {

    private final LilyBukkit server;
    private final String username;

    public LBOfflinePlayer(LilyBukkit s, String name) {
        this.server = s;
        this.username = name;
    }

    @Override
    public boolean isOnline() {
        return false;
    }

    @Override
    public String getName() {
        return this.username;
    }

    @Override
    public boolean isBanned() {
        return this.server.getConfigManager().bannedPlayers.contains(this.getName());
    }

    @Override
    public void setBanned(boolean b) {
        if (b) this.server.getConfigManager().banPlayer(this.getName());
        else this.server.getConfigManager().pardonPlayer(this.getName());
    }

    @Override
    public boolean isWhitelisted() {
        return this.server.getConfigManager().whitelistedPlayers.contains(this.getName());
    }

    @Override
    public void setWhitelisted(boolean b) {
        if (b) this.server.getConfigManager().whitelistPlayer(this.getName());
        else this.server.getConfigManager().unwhitelistPlayer(this.getName());
    }

    @Override
    public boolean isIPWhitelisted(){
        return this.server.getConfigManager().whitelistedIPs.contains(this.getName());
    }

    @Override
    public void setIPWhitelisted(boolean b) {
        if (b) this.server.getConfigManager().whitelistIP(this.getName());
        else this.server.getConfigManager().unwhitelistIP(this.getName());
    }


    @Override
    public boolean isOp() {
        return this.server.getConfigManager().ops.contains(this.getName());
    }

    @Override
    public void setOp(boolean b) {
        if (b) this.server.getConfigManager().opPlayer(this.getName());
        else this.server.getConfigManager().deopPlayer(this.getName());
    }

    @Override
    public Map<String, Object> serialize() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
