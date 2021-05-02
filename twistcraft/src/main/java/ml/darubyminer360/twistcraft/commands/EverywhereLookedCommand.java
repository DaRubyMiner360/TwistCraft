package ml.darubyminer360.twistcraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ShapedRecipe;

public class EverywhereLookedCommand implements CommandExecutor {
    public static EverywhereLookedMode mode = EverywhereLookedMode.Random;
    public static boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            if (args.length > 0 && (args[0].equalsIgnoreCase("random") || args[0].equalsIgnoreCase("bedrock") || args[0].equalsIgnoreCase("explodes") || args[0].equalsIgnoreCase("explode") || args[0].equalsIgnoreCase("explosion"))) {
                if (args[0].equalsIgnoreCase("random")) {
                    mode = EverywhereLookedMode.Random;
                }
                else if (args[0].equalsIgnoreCase("bedrock")) {
                    mode = EverywhereLookedMode.Bedrock;
                }
                else if (args[0].equalsIgnoreCase("explodes") || args[0].equalsIgnoreCase("explode") || args[0].equalsIgnoreCase("explosion")) {
                    mode = EverywhereLookedMode.Explodes;
                }
                p.sendMessage("Everywhere Looked enabled! '" + args[0] + "' is the selected mode!");
                enabled = true;
            }
            else {
                p.sendMessage("Add the mode as an argument!");
            }
        }
        else {
            p.sendMessage("Everywhere Looked disabled!");
            enabled = false;
        }

        return true;
    }

    public enum EverywhereLookedMode {
        Random,
        Bedrock,
        Explodes
    }
}
