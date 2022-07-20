package org.bukkit.command.defaults;

import net.minecraft.server.MinecraftServer;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand extends VanillaCommand {
    public HomeCommand() {
        super("home");
        this.description = "Teleports you to home";
        this.usageMessage = "/home";
        this.setPermission("bukkit.command.home");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (!this.testPermission(commandSender)) {
            return true;
        } else {
            Player playerEntity = commandSender.getServer().getPlayer(commandSender.getName());
            if (playerEntity==null){
                commandSender.sendMessage("§cCan't find player "+commandSender.getName());
                return false;
            }
            MinecraftServer.logger.info(playerEntity.getName() + " returned home");
            playerEntity.teleport(playerEntity.getWorld().getSpawnLocation());
            return true;
        }
    }

    @Override
    public boolean matches(String s) {
        return s.equalsIgnoreCase("wood");
    }
}
