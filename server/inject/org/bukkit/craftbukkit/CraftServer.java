package org.bukkit.craftbukkit;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ServerConfigurationManager;
import org.bukkit.plugin.PluginLoadOrder;
import ru.vladthemountain.lilybukkit.core.LilyBukkit;

@Deprecated
public class CraftServer extends LilyBukkit {

    public CraftServer(MinecraftServer console, ServerConfigurationManager server) {
        super(console);
    }

    public ServerConfigurationManager getHandle() {return this.getConfigManager();}

    public void loadConfig(){
        this.CRAFTBUKKIT_loadConfig();
    }

    public void loadPlugins(){
        this.CRAFTBUKKIT_loadPlugins();
    }

    public void enablePlugins(PluginLoadOrder order){
        this.enablePluginsInOrder(order);
    }

    public void loadCustomPermissions(){
        this.CRAFTBUKKIT_loadCustomPermissions();
    }
}
