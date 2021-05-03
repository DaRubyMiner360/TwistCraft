package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.*;

public class AllowedFlightCommand implements CommandExecutor {
    public static boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.setAllowFlight(true);
            }

            TwistCraft.instance.messageServer("Allowed Flight enabled!", p);
            enabled = true;
        }
        else {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getGameMode() != GameMode.CREATIVE && player.getGameMode() != GameMode.SPECTATOR) {
                    player.setAllowFlight(false);
                }
            }

            TwistCraft.instance.messageServer("Allowed Flight disabled!", p);
            enabled = false;
        }

        return true;
    }
}
