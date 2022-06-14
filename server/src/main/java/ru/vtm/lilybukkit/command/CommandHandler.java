package ru.vtm.lilybukkit.command;

import org.bukkit.command.Command;

import java.util.List;

public class CommandHandler {

    List<Command> commandsList;

    public CommandHandler() {

    }

    public void addCommand(Command command) {
        commandsList.add(command);
    }
}
