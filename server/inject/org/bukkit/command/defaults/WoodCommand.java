package org.bukkit.command.defaults;

import net.minecraft.server.MinecraftServer;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WoodCommand extends VanillaCommand {
    public WoodCommand(){
        super("wood");
        this.description = "Gives you a sapling";
        this.usageMessage = "/wood";
        this.setPermission("bukkit.command.wood");
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
            if (MinecraftServer.playerList.containsKey(playerEntity.getName())) {
                MinecraftServer.logger.info(playerEntity.getName() + " failed to wood!");
                commandSender.sendMessage("§cYou can't /wood again so soon!");
                return true;
            }
            else {
                MinecraftServer.playerList.put(playerEntity.getName(), 6000);
                MinecraftServer.logger.info(playerEntity.getName() + " wooded!");
                for (int i3 = 0; i3 < 4; ++i3) {
                    playerEntity.getInventory().addItem(new ItemStack(Material.SAPLING, 1));
                }
                return true;
            }
        }
    }

    @Override
    public boolean matches(String s) {
        return s.equalsIgnoreCase("wood");
    }
}
