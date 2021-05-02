package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import ml.darubyminer360.twistcraft.util.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args[0].equalsIgnoreCase("broadcastmessages")) {
            if (args[1].equalsIgnoreCase("true")) {
                Config.get().set("BroadcastMessages", true);
                Config.save();
                Config.reload();

                TwistCraft.instance.messageServer("Broadcast Messages has been enabled!", (Player) sender);
            }
            else {
                Config.get().set("BroadcastMessages", false);
                Config.save();
                Config.reload();

                TwistCraft.instance.messageServer("Broadcast Messages has been disabled!", (Player) sender);
            }
        }

        return true;
    }
}
