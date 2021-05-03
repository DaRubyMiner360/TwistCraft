package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.*;

public class SneakInvisibilityCommand implements CommandExecutor {
    public static boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            TwistCraft.instance.messageServer("Sneak Invisibility enabled!", p);
            enabled = true;
        }
        else {
            TwistCraft.instance.messageServer("Sneak Invisibility disabled!", p);
            enabled = false;
        }

        return true;
    }
}
