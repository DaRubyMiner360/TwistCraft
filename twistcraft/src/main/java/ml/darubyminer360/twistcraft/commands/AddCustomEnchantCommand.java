package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.util.CustomEnchants;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AddCustomEnchantCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (CustomEnchantsCommand.enabled) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
                    if (args[0].equalsIgnoreCase("oploot")) {
                        player.getInventory().getItemInMainHand().addUnsafeEnchantment(CustomEnchants.OPLOOT, 1);
                    }
                    if (args[0].equalsIgnoreCase("telepathy")) {
                        player.getInventory().getItemInMainHand().addUnsafeEnchantment(CustomEnchants.TELEPATHY, 1);
                    }
                    if (args[0].equalsIgnoreCase("infection")) {
                        if (args.length > 1 && args[1] == "2") {
                            player.getInventory().getItemInMainHand().addUnsafeEnchantment(CustomEnchants.INFECTION, 2);
                        }
                        else {
                            player.getInventory().getItemInMainHand().addUnsafeEnchantment(CustomEnchants.INFECTION, 1);
                        }
                    }
                    if (args[0].equalsIgnoreCase("withering")) {
                        if (args.length > 1 && args[1] == "2") {
                            player.getInventory().getItemInMainHand().addUnsafeEnchantment(CustomEnchants.WITHERING, 2);
                        }
                        else {
                            player.getInventory().getItemInMainHand().addUnsafeEnchantment(CustomEnchants.WITHERING, 1);
                        }
                    }
                    if (args[0].equalsIgnoreCase("heaviness")) {
                        if (args.length > 1 && args[1] == "2") {
                            player.getInventory().getItemInMainHand().addUnsafeEnchantment(CustomEnchants.HEAVINESS, 2);
                        }
                        else {
                            player.getInventory().getItemInMainHand().addUnsafeEnchantment(CustomEnchants.HEAVINESS, 1);
                        }
                    }
                }
            }
        }

        return true;
    }
}
