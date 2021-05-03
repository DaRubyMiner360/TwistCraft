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

public class CraftableBarrierBlocksCommand implements CommandExecutor {
    public static boolean enabled;
    public static ShapedRecipe barrierBlockRecipex1;
    public static ShapedRecipe barrierBlockRecipex2;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            // Add recipe
            barrierBlockRecipex1 = new ShapedRecipe(new NamespacedKey(TwistCraft.instance, "barrier_block"), new ItemStack(Material.BARRIER, 1));
            barrierBlockRecipex1.shape(
                    " G ",
                    "GDG",
                    " G "
            );
            barrierBlockRecipex1.setIngredient('G', Material.GLASS);
            barrierBlockRecipex1.setIngredient('D', Material.RED_DYE);
            Bukkit.getServer().addRecipe(barrierBlockRecipex1);

            barrierBlockRecipex2 = new ShapedRecipe(new NamespacedKey(TwistCraft.instance, "barrier_block_x2"), new ItemStack(Material.BARRIER, 2));
            barrierBlockRecipex2.shape(
                    "GGG",
                    "GDG",
                    "GGG"
            );
            barrierBlockRecipex2.setIngredient('G', Material.GLASS);
            barrierBlockRecipex2.setIngredient('D', Material.RED_DYE);
            Bukkit.getServer().addRecipe(barrierBlockRecipex2);

            TwistCraft.instance.messageServer("Craftable Barrier Blocks enabled!", p);
            enabled = true;
        }
        else {
            // Remove recipe
            Bukkit.getServer().removeRecipe(barrierBlockRecipex1.getKey());
            Bukkit.getServer().removeRecipe(barrierBlockRecipex2.getKey());

            TwistCraft.instance.messageServer("Craftable Barrier Blocks disabled!", p);
            enabled = false;
        }

        return true;
    }
}
