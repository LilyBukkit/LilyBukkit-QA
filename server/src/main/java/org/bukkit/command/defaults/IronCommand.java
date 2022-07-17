package org.bukkit.command.defaults;

import net.minecraft.server.MinecraftServer;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class IronCommand extends VanillaCommand {

    public IronCommand(){
        super("iron");
        this.description = "Gives you an iron ingot";
        this.usageMessage = "/iron";
        this.setPermission("bukkit.command.iron");
    }

    @Override
    public boolean matches(String s) {
        return s.equalsIgnoreCase("iron");
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
                MinecraftServer.logger.info(playerEntity.getName() + " failed to iron!");
                commandSender.sendMessage("§cYou can't /iron again so soon!");
                return true;
            }
            else {
                MinecraftServer.playerList.put(playerEntity.getName(), 6000);
                MinecraftServer.logger.info(playerEntity.getName() + " ironed!");
                for (int i3 = 0; i3 < 4; ++i3) {
                    playerEntity.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1));
                }
                return true;
            }
        }
    }
}
