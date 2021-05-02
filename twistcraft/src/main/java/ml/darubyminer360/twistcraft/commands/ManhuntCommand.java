package ml.darubyminer360.twistcraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ShapedRecipe;

public class ManhuntCommand implements CommandExecutor {
    public static String hunted = "";
    public static boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            if (args.length > 0) {
                hunted = args[0];

                p.sendMessage("Manhunt enabled! " + args[0] + " is the speedrunner!");
                enabled = true;
            }
            else {
                p.sendMessage("Add the speedrunner as an argument!");
            }
        }
        else {
            p.sendMessage("Manhunt disabled!");
            enabled = false;
        }

        return true;
    }
}
