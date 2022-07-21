package org.bukkit.craftbukkit;

import ru.vladthemountain.lilybukkit.LBOfflinePlayer;

@Deprecated
public class CraftOfflinePlayer extends LBOfflinePlayer {
    public CraftOfflinePlayer(CraftServer s, String name) {
        super(s, name);
    }
}
