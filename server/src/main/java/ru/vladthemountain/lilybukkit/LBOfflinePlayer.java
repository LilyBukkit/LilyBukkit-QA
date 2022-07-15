package ru.vladthemountain.lilybukkit;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class LBOfflinePlayer implements OfflinePlayer {

    private final Player playerSnapshot;

    public LBOfflinePlayer(Player p) {
        this.playerSnapshot = p;
    }

    @Override
    public boolean isOnline() {
        return this.playerSnapshot.isOnline();
    }

    @Override
    public String getName() {
        return this.playerSnapshot.getName();
    }

    @Override
    public boolean isBanned() {
        return ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().bannedPlayers.contains(this.getName());
    }

    @Override
    public void setBanned(boolean b) {
        if (b) ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().banPlayer(this.getName());
        else ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().pardonPlayer(this.getName());
    }

    @Override
    public boolean isWhitelisted() {
        return ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().whitelistedPlayers.contains(this.getName());
    }

    @Override
    public void setWhitelisted(boolean b) {
        if (b) ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().whitelistPlayer(this.getName());
        else ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().unwhitelistPlayer(this.getName());
    }

    @Override
    public boolean isIPWhitelisted(){
        return ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().whitelistedIPs.contains(this.getName());
    }

    @Override
    public void setIPWhitelisted(boolean b) {
        if (b) ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().whitelistIP(this.getName());
        else ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().unwhitelistIP(this.getName());
    }

    @Override
    public Player getPlayer() {
        return this.playerSnapshot;
    }

    @Override
    public boolean isOp() {
        return ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().ops.contains(this.getName());
    }

    @Override
    public void setOp(boolean b) {
        if (b) ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().opPlayer(this.getName());
        else ((LilyBukkit) this.playerSnapshot.getServer()).getConfigManager().deopPlayer(this.getName());
    }
}
