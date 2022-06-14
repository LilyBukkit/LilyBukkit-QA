package ru.vtm.lilybukkit;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ICommandListener;
import net.minecraft.src.ServerCommand;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.*;

public class LilyBukkit {
    public static Command[] commandList = {
            new Command("help", "show all commands", "/help [command]", Collections.singletonList("?")) {
                @Override
                public boolean execute(CommandSender commandSender, String s, String[] strings) {
                    if (commandSender instanceof Server){
                        ICommandListener iCommandListener3 = ((ServerCommand) MinecraftServer.getCommands().remove(0)).commandListener;
                        iCommandListener3.addHelpCommandMessage("To run the server without a gui, start it like this:");
                        iCommandListener3.addHelpCommandMessage("   java -Xmx1024M -Xms1024M -jar minecraft_server.jar nogui");
                        iCommandListener3.addHelpCommandMessage("Console commands:");
                        iCommandListener3.addHelpCommandMessage("   help  or  ?               shows this message");
                        iCommandListener3.addHelpCommandMessage("   kick <player>             removes a player from the server");
                        iCommandListener3.addHelpCommandMessage("   ban <player>              bans a player from the server");
                        iCommandListener3.addHelpCommandMessage("   pardon <player>           pardons a banned player so that they can connect again");
                        iCommandListener3.addHelpCommandMessage("   ban-ip <ip>               bans an IP address from the server");
                        iCommandListener3.addHelpCommandMessage("   pardon-ip <ip>            pardons a banned IP address so that they can connect again");
                        iCommandListener3.addHelpCommandMessage("   op <player>               turns a player into an op");
                        iCommandListener3.addHelpCommandMessage("   deop <player>             removes op status from a player");
                        iCommandListener3.addHelpCommandMessage("   tp <player1> <player2>    moves one player to the same location as another player");
                        iCommandListener3.addHelpCommandMessage("   give <player> <id> [num]  gives a player a resource");
                        iCommandListener3.addHelpCommandMessage("   tell <player> <message>   sends a private message to a player");
                        iCommandListener3.addHelpCommandMessage("   stop                      gracefully stops the server");
                        iCommandListener3.addHelpCommandMessage("   save-all                  forces a server-wide level save");
                        iCommandListener3.addHelpCommandMessage("   save-off                  disables terrain saving (useful for backup scripts)");
                        iCommandListener3.addHelpCommandMessage("   save-on                   re-enables terrain saving");
                        iCommandListener3.addHelpCommandMessage("   list                      lists all currently connected players");
                        iCommandListener3.addHelpCommandMessage("   say <message>             broadcasts a message to all players");
                        iCommandListener3.addHelpCommandMessage("   whitelist                 manage server whitelist");
                    }
                    return true;
                }
            }
    };
}
