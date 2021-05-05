package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import ml.darubyminer360.twistcraft.util.CustomEnchants;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.*;

public class CustomEnchantsCommand implements CommandExecutor {
    public static boolean enabled;

    public static ShapelessRecipe opLootBookRecipe;
    public static ShapelessRecipe telepathyBookRecipe;
    public static ShapelessRecipe lifestealOneBookRecipe;
    public static ShapelessRecipe lifestealTwoBookRecipe;
    public static ShapelessRecipe lifestealThreeBookRecipe;
    public static ShapelessRecipe lifestealFourBookRecipe;
    public static ShapelessRecipe lifestealFiveBookRecipe;
    public static ShapelessRecipe infectionOneBookRecipe;
    public static ShapelessRecipe infectionTwoBookRecipe;
    public static ShapelessRecipe witheringOneBookRecipe;
    public static ShapelessRecipe witheringTwoBookRecipe;
    public static ShapelessRecipe heavinessOneBookRecipe;
    public static ShapelessRecipe heavinessTwoBookRecipe;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            // Add recipe
            ItemStack opLootEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta opLootEnchantedBookMeta = (EnchantmentStorageMeta) opLootEnchantedBook.getItemMeta();
            opLootEnchantedBookMeta.addStoredEnchant(CustomEnchants.OPLOOT, 1, true);
            opLootEnchantedBook.setItemMeta(opLootEnchantedBookMeta);

            ItemStack telepathyEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta telepathyEnchantedBookMeta = (EnchantmentStorageMeta) telepathyEnchantedBook.getItemMeta();
            telepathyEnchantedBookMeta.addStoredEnchant(CustomEnchants.TELEPATHY, 1, true);
            telepathyEnchantedBook.setItemMeta(telepathyEnchantedBookMeta);

            ItemStack lifestealOneEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta lifestealOneEnchantedBookMeta = (EnchantmentStorageMeta) lifestealOneEnchantedBook.getItemMeta();
            lifestealOneEnchantedBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 1, true);
            lifestealOneEnchantedBook.setItemMeta(lifestealOneEnchantedBookMeta);

            ItemStack lifestealTwoEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta lifestealTwoEnchantedBookMeta = (EnchantmentStorageMeta) lifestealTwoEnchantedBook.getItemMeta();
            lifestealTwoEnchantedBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 2, true);
            lifestealTwoEnchantedBook.setItemMeta(lifestealTwoEnchantedBookMeta);

            ItemStack lifestealThreeEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta lifestealThreeEnchantedBookMeta = (EnchantmentStorageMeta) lifestealThreeEnchantedBook.getItemMeta();
            lifestealThreeEnchantedBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 3, true);
            lifestealThreeEnchantedBook.setItemMeta(lifestealThreeEnchantedBookMeta);

            ItemStack lifestealFourEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta lifestealFourEnchantedBookMeta = (EnchantmentStorageMeta) lifestealFourEnchantedBook.getItemMeta();
            lifestealFourEnchantedBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 4, true);
            lifestealFourEnchantedBook.setItemMeta(lifestealFourEnchantedBookMeta);

            ItemStack lifestealFiveEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta lifestealFiveEnchantedBookMeta = (EnchantmentStorageMeta) lifestealFiveEnchantedBook.getItemMeta();
            lifestealFiveEnchantedBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 5, true);
            lifestealFiveEnchantedBook.setItemMeta(lifestealFiveEnchantedBookMeta);

            ItemStack infectionOneEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta infectionOneEnchantedBookMeta = (EnchantmentStorageMeta) infectionOneEnchantedBook.getItemMeta();
            infectionOneEnchantedBookMeta.addStoredEnchant(CustomEnchants.INFECTION, 1, true);
            infectionOneEnchantedBook.setItemMeta(infectionOneEnchantedBookMeta);

            ItemStack infectionTwoEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta infectionTwoEnchantedBookMeta = (EnchantmentStorageMeta) infectionTwoEnchantedBook.getItemMeta();
            infectionTwoEnchantedBookMeta.addStoredEnchant(CustomEnchants.INFECTION, 2, true);
            infectionTwoEnchantedBook.setItemMeta(infectionTwoEnchantedBookMeta);

            ItemStack witheringOneEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta witheringOneEnchantedBookMeta = (EnchantmentStorageMeta) witheringOneEnchantedBook.getItemMeta();
            witheringOneEnchantedBookMeta.addStoredEnchant(CustomEnchants.WITHERING, 1, true);
            witheringOneEnchantedBook.setItemMeta(witheringOneEnchantedBookMeta);

            ItemStack witheringTwoEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta witheringTwoEnchantedBookMeta = (EnchantmentStorageMeta) witheringTwoEnchantedBook.getItemMeta();
            witheringTwoEnchantedBookMeta.addStoredEnchant(CustomEnchants.WITHERING, 2, true);
            witheringTwoEnchantedBook.setItemMeta(witheringTwoEnchantedBookMeta);

            ItemStack heavinessOneEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta heavinessOneEnchantedBookMeta = (EnchantmentStorageMeta) heavinessOneEnchantedBook.getItemMeta();
            heavinessOneEnchantedBookMeta.addStoredEnchant(CustomEnchants.HEAVINESS, 1, true);
            heavinessOneEnchantedBook.setItemMeta(heavinessOneEnchantedBookMeta);

            ItemStack heavinessTwoEnchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta heavinessTwoEnchantedBookMeta = (EnchantmentStorageMeta) heavinessTwoEnchantedBook.getItemMeta();
            heavinessTwoEnchantedBookMeta.addStoredEnchant(CustomEnchants.HEAVINESS, 2, true);
            heavinessTwoEnchantedBook.setItemMeta(heavinessTwoEnchantedBookMeta);

            opLootBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "op_loot_enchanted_book"), opLootEnchantedBook);
            opLootBookRecipe.addIngredient(1, Material.BOOK);
            opLootBookRecipe.addIngredient(1, Material.IRON_INGOT);
            opLootBookRecipe.addIngredient(1, Material.GOLD_INGOT);
            opLootBookRecipe.addIngredient(1, Material.DIAMOND);
            Bukkit.getServer().addRecipe(opLootBookRecipe);

            telepathyBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "telepathy_enchanted_book"), telepathyEnchantedBook);
            telepathyBookRecipe.addIngredient(1, Material.BOOK);
            telepathyBookRecipe.addIngredient(1, Material.ENDER_PEARL);
            Bukkit.getServer().addRecipe(telepathyBookRecipe);

            lifestealOneEnchantedBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_one_enchanted_book"), lifestealOneEnchantedBook);
            lifestealOneEnchantedBookRecipe.addIngredient(1, Material.BOOK);
            lifestealOneEnchantedBookRecipe.addIngredient(1, Material.REDSTONE);
            Bukkit.getServer().addRecipe(lifestealOneEnchantedBookRecipe);

            lifestealTwoEnchantedBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_two_enchanted_book"), lifestealTwoEnchantedBook);
            lifestealTwoEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(lifestealOneEnchantedBook));
            lifestealTwoEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(lifestealOneEnchantedBook));
            Bukkit.getServer().addRecipe(lifestealTwoEnchantedBookRecipe);

            lifestealThreeEnchantedBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_three_enchanted_book"), lifestealThreeEnchantedBook);
            lifestealThreeEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(lifestealTwoEnchantedBook));
            lifestealThreeEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(lifestealTwoEnchantedBook));
            Bukkit.getServer().addRecipe(lifestealThreeEnchantedBookRecipe);

            lifestealFourEnchantedBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_four_enchanted_book"), lifestealFourEnchantedBook);
            lifestealFourEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(lifestealThreeEnchantedBook));
            lifestealFourEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(lifestealThreeEnchantedBook));
            Bukkit.getServer().addRecipe(lifestealFourEnchantedBookRecipe);

            lifestealFiveEnchantedBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_five_enchanted_book"), lifestealFiveEnchantedBook);
            lifestealFiveEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(lifestealFourEnchantedBook));
            lifestealFiveEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(lifestealFourEnchantedBook));
            Bukkit.getServer().addRecipe(lifestealFiveEnchantedBookRecipe);

            infectionOneEnchantedBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "infection_one_enchanted_book"), infectionOneEnchantedBook);
            infectionOneEnchantedBookRecipe.addIngredient(1, Material.BOOK);
            infectionOneEnchantedBookRecipe.addIngredient(1, Material.SPIDER_EYE);
            Bukkit.getServer().addRecipe(infectionOneEnchantedBookRecipe);

            infectionTwoEnchantedBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "infection_two_enchanted_book"), infectionTwoEnchantedBook);
            infectionTwoEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(infectionOneEnchantedBook));
            infectionTwoEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(infectionOneEnchantedBook));
            Bukkit.getServer().addRecipe(infectionTwoEnchantedBookRecipe);

            witheringOneEnchantedBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "withering_one_enchanted_book"), witheringOneEnchantedBook);
            witheringOneEnchantedBookRecipe.addIngredient(1, Material.BOOK);
            witheringOneEnchantedBookRecipe.addIngredient(1, Material.COAL);
            witheringOneEnchantedBookRecipe.addIngredient(1, Material.BONE);
            Bukkit.getServer().addRecipe(witheringOneEnchantedBookRecipe);

            witheringTwoEnchantedBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "withering_two_enchanted_book"), witheringTwoEnchantedBook);
            witheringTwoEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(witheringOneEnchantedBook));
            witheringTwoEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(witheringOneEnchantedBook));
            Bukkit.getServer().addRecipe(witheringTwoEnchantedBookRecipe);

            heavinessOneEnchantedBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "heaviness_one_enchanted_book"), heavinessOneEnchantedBook);
            heavinessOneEnchantedBookRecipe.addIngredient(1, Material.BOOK);
            heavinessOneEnchantedBookRecipe.addIngredient(1, Material.IRON_BLOCK);
            Bukkit.getServer().addRecipe(heavinessOneEnchantedBookRecipe);

            heavinessTwoEnchantedBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "heaviness_two_enchanted_book"), heavinessTwoEnchantedBook);
            heavinessTwoEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(heavinessOneEnchantedBook));
            heavinessTwoEnchantedBookRecipe.addIngredient(1, new RecipeChoice.ExactChoice(heavinessOneEnchantedBook));
            Bukkit.getServer().addRecipe(heavinessTwoEnchantedBookRecipe);
            
            TwistCraft.instance.messageServer("Custom Enchants enabled!", p);
            enabled = true;
        }
        else {
            // Remove recipe
            Bukkit.getServer().removeRecipe(opLootBookRecipe.getKey());

            TwistCraft.instance.messageServer("Custom Enchants disabled!", p);
            enabled = false;
        }

        return true;
    }
}
