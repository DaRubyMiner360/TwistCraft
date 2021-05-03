package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class CraftableEnchantedGoldenApplesCommand implements CommandExecutor {
    public static boolean enabled;
    public static ShapedRecipe enchantedGoldenAppleRecipe;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            // Add recipe
            enchantedGoldenAppleRecipe = new ShapedRecipe(new NamespacedKey(TwistCraft.instance, "enchanted_golden_apple"), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
            enchantedGoldenAppleRecipe.shape(
                    "GGG",
                    "GAG",
                    "GGG"
            );
            enchantedGoldenAppleRecipe.setIngredient('G', Material.GOLD_BLOCK);
            enchantedGoldenAppleRecipe.setIngredient('A', Material.APPLE);
            Bukkit.getServer().addRecipe(enchantedGoldenAppleRecipe);

            TwistCraft.instance.messageServer("Craftable Enchanted Golden Apples enabled!", p);
            enabled = true;
        }
        else {
            // Remove recipe
            Bukkit.getServer().removeRecipe(enchantedGoldenAppleRecipe.getKey());

            TwistCraft.instance.messageServer("Craftable Enchanted Golden Apples disabled!", p);
            enabled = false;
        }

        return true;
    }
}
