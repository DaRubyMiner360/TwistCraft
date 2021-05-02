package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.util.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args[0].equalsIgnoreCase("broadcastmessages")) {
            if (args[1].equalsIgnoreCase("true")) {
                Config.get().set("BroadcastMessages", true);
                Config.save();
                Config.reload();
            }
            else {
                Config.get().set("BroadcastMessages", false);
                Config.save();
                Config.reload();
            }
        }

        return true;
    }
}
