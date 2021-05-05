package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.util.CustomEnchants;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;

public class GetCustomEnchantCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (CustomEnchantsCommand.enabled) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);

                if (args[0].equalsIgnoreCase("oploot")) {
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
                    meta.addStoredEnchant(CustomEnchants.OPLOOT, 1, true);
                    // item.addUnsafeEnchantment(CustomEnchants.OPLOOT, 1);
                    item.setItemMeta(meta);
                }
                if (args[0].equalsIgnoreCase("telepathy")) {
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
                    meta.addStoredEnchant(CustomEnchants.TELEPATHY, 1, true);
                    // item.addUnsafeEnchantment(CustomEnchants.TELEPATHY, 1);
                    item.setItemMeta(meta);
                }
                if (args[0].equalsIgnoreCase("lifesteal")) {
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
                    if (args.length > 1) {
                        if (args[1] == "2") {
                            meta.addStoredEnchant(CustomEnchants.LIFESTEAL, 2, true);
                            // item.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 2);
                        }
                        else if (args[1] == "3") {
                            meta.addStoredEnchant(CustomEnchants.LIFESTEAL, 3, true);
                            // item.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 3);
                        }
                        else if (args[1] == "4") {
                            meta.addStoredEnchant(CustomEnchants.LIFESTEAL, 4, true);
                            // item.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 4);
                        }
                        else if (args[1] == "5") {
                            meta.addStoredEnchant(CustomEnchants.LIFESTEAL, 5, true);
                            // item.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 5);
                        }
                        else {
                            meta.addStoredEnchant(CustomEnchants.LIFESTEAL, 1, true);
                            // item.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 1);
                        }
                    }
                    else {
                        meta.addStoredEnchant(CustomEnchants.LIFESTEAL, 1, true);
                        // item.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 1);
                    }
                    item.setItemMeta(meta);
                }
                if (args[0].equalsIgnoreCase("infection")) {
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
                    if (args.length > 1 && args[1] == "2") {
                        meta.addStoredEnchant(CustomEnchants.INFECTION, 2, true);
                        // item.addUnsafeEnchantment(CustomEnchants.INFECTION, 2);
                    }
                    else {
                        meta.addStoredEnchant(CustomEnchants.INFECTION, 1, true);
                        // item.addUnsafeEnchantment(CustomEnchants.INFECTION, 1);
                    }
                    item.setItemMeta(meta);
                }
                if (args[0].equalsIgnoreCase("withering")) {
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
                    if (args.length > 1 && args[1] == "2") {
                        meta.addStoredEnchant(CustomEnchants.WITHERING, 2, true);
                        // item.addUnsafeEnchantment(CustomEnchants.WITHERING, 2);
                    }
                    else {
                        meta.addStoredEnchant(CustomEnchants.WITHERING, 1, true);
                        // item.addUnsafeEnchantment(CustomEnchants.WITHERING, 1);
                    }
                    item.setItemMeta(meta);
                }
                if (args[0].equalsIgnoreCase("heaviness")) {
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
                    if (args.length > 1 && args[1] == "2") {
                        meta.addStoredEnchant(CustomEnchants.HEAVINESS, 2, true);
                        // item.addUnsafeEnchantment(CustomEnchants.HEAVINESS, 2);
                    }
                    else {
                        meta.addStoredEnchant(CustomEnchants.HEAVINESS, 1, true);
                        // item.addUnsafeEnchantment(CustomEnchants.HEAVINESS, 1);
                    }
                    item.setItemMeta(meta);
                }

                if (player.getInventory().firstEmpty() != -1) {
                    player.getInventory().addItem(item);
                }
                else {
                    player.getWorld().dropItem(player.getLocation(), item);
                }
            }
        }

        return true;
    }
}
