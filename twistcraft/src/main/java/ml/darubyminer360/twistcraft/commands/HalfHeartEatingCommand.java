package ml.darubyminer360.twistcraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HalfHeartEatingCommand implements CommandExecutor {
    public static boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            p.sendMessage("Half Heart Eating enabled!");
            enabled = true;
        }
        else {
            p.sendMessage("Half Heart Eating disabled!");
            enabled = false;
        }

        return true;
    }
}

