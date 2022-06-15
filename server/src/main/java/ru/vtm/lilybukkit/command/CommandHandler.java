package ru.vtm.lilybukkit.command;

import net.minecraft.src.ServerCommand;
import org.bukkit.command.Command;

import java.util.List;

public class CommandHandler {

    //TODO: Rewrite so there are no static stuff

    static List<Command> commandsList;

    public CommandHandler() {

    }

    public void addCommand(ServerCommand command) {
        commandsList.add(command);
    }

    public static ServerCommand[] getCommandsList(){
        return commandsList.toArray(new ServerCommand[this.commandsList.size()]);
    }
}
