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
            // Add recipes
            ItemStack opLootBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta opLootBookMeta = (EnchantmentStorageMeta) opLootBook.getItemMeta();
            // opLootBookMeta.addStoredEnchant(CustomEnchants.OPLOOT, 1, true);
            opLootBook.addUnsafeEnchantment(CustomEnchants.OPLOOT, 1);
            opLootBook.setItemMeta(opLootBookMeta);

            ItemStack telepathyBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta telepathyBookMeta = (EnchantmentStorageMeta) telepathyBook.getItemMeta();
            // telepathyBookMeta.addStoredEnchant(CustomEnchants.TELEPATHY, 1, true);
            telepathyBook.addUnsafeEnchantment(CustomEnchants.TELEPATHY, 1);
            telepathyBook.setItemMeta(telepathyBookMeta);

            ItemStack lifestealOneBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta lifestealOneBookMeta = (EnchantmentStorageMeta) lifestealOneBook.getItemMeta();
            // lifestealOneBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 1, true);
            lifestealOneBook.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 1);
            lifestealOneBook.setItemMeta(lifestealOneBookMeta);

            ItemStack lifestealTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta lifestealTwoBookMeta = (EnchantmentStorageMeta) lifestealTwoBook.getItemMeta();
            // lifestealTwoBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 2, true);
            lifestealTwoBook.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 2);
            lifestealTwoBook.setItemMeta(lifestealTwoBookMeta);

            ItemStack lifestealThreeBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta lifestealThreeBookMeta = (EnchantmentStorageMeta) lifestealThreeBook.getItemMeta();
            // lifestealThreeBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 3, true);
            lifestealThreeBook.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 3);
            lifestealThreeBook.setItemMeta(lifestealThreeBookMeta);

            ItemStack lifestealFourBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta lifestealFourBookMeta = (EnchantmentStorageMeta) lifestealFourBook.getItemMeta();
            // lifestealFourBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 4, true);
            lifestealFourBook.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 4);
            lifestealFourBook.setItemMeta(lifestealFourBookMeta);

            ItemStack lifestealFiveBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta lifestealFiveBookMeta = (EnchantmentStorageMeta) lifestealFiveBook.getItemMeta();
            // lifestealFiveBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 5, true);
            lifestealFiveBook.addUnsafeEnchantment(CustomEnchants.LIFESTEAL, 5);
            lifestealFiveBook.setItemMeta(lifestealFiveBookMeta);

            ItemStack infectionOneBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta infectionOneBookMeta = (EnchantmentStorageMeta) infectionOneBook.getItemMeta();
            // infectionOneBookMeta.addStoredEnchant(CustomEnchants.INFECTION, 1, true);
            infectionOneBook.addUnsafeEnchantment(CustomEnchants.INFECTION, 1);
            infectionOneBook.setItemMeta(infectionOneBookMeta);

            ItemStack infectionTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta infectionTwoBookMeta = (EnchantmentStorageMeta) infectionTwoBook.getItemMeta();
            // infectionTwoBookMeta.addStoredEnchant(CustomEnchants.INFECTION, 2, true);
            infectionTwoBook.addUnsafeEnchantment(CustomEnchants.INFECTION, 2);
            infectionTwoBook.setItemMeta(infectionTwoBookMeta);

            ItemStack witheringOneBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta witheringOneBookMeta = (EnchantmentStorageMeta) witheringOneBook.getItemMeta();
            // witheringOneBookMeta.addStoredEnchant(CustomEnchants.WITHERING, 1, true);
            witheringOneBook.addUnsafeEnchantment(CustomEnchants.WITHERING, 1);
            witheringOneBook.setItemMeta(witheringOneBookMeta);

            ItemStack witheringTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta witheringTwoBookMeta = (EnchantmentStorageMeta) witheringTwoBook.getItemMeta();
            // witheringTwoBookMeta.addStoredEnchant(CustomEnchants.WITHERING, 2, true);
            witheringTwoBook.addUnsafeEnchantment(CustomEnchants.WITHERING, 2);
            witheringTwoBook.setItemMeta(witheringTwoBookMeta);

            ItemStack heavinessOneBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta heavinessOneBookMeta = (EnchantmentStorageMeta) heavinessOneBook.getItemMeta();
            // heavinessOneBookMeta.addStoredEnchant(CustomEnchants.HEAVINESS, 1, true);
            heavinessOneBook.addUnsafeEnchantment(CustomEnchants.HEAVINESS, 1);
            heavinessOneBook.setItemMeta(heavinessOneBookMeta);

            ItemStack heavinessTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta heavinessTwoBookMeta = (EnchantmentStorageMeta) heavinessTwoBook.getItemMeta();
            // heavinessTwoBookMeta.addStoredEnchant(CustomEnchants.HEAVINESS, 2, true);
            heavinessTwoBook.addUnsafeEnchantment(CustomEnchants.HEAVINESS, 2);
            heavinessTwoBook.setItemMeta(heavinessTwoBookMeta);

            opLootBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "op_loot_enchanted_book"), opLootBook);
            opLootBookRecipe.addIngredient(1, Material.BOOK);
            opLootBookRecipe.addIngredient(1, Material.IRON_INGOT);
            opLootBookRecipe.addIngredient(1, Material.GOLD_INGOT);
            opLootBookRecipe.addIngredient(1, Material.DIAMOND);
            Bukkit.getServer().addRecipe(opLootBookRecipe);

            telepathyBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "telepathy_enchanted_book"), telepathyBook);
            telepathyBookRecipe.addIngredient(1, Material.BOOK);
            telepathyBookRecipe.addIngredient(1, Material.ENDER_PEARL);
            Bukkit.getServer().addRecipe(telepathyBookRecipe);

            lifestealOneBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_one_enchanted_book"), lifestealOneBook);
            lifestealOneBookRecipe.addIngredient(1, Material.BOOK);
            lifestealOneBookRecipe.addIngredient(1, Material.REDSTONE);
            Bukkit.getServer().addRecipe(lifestealOneBookRecipe);

            lifestealTwoBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_two_enchanted_book"), lifestealTwoBook);
            lifestealTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealOneBook));
            lifestealTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealOneBook));
            Bukkit.getServer().addRecipe(lifestealTwoBookRecipe);

            lifestealThreeBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_three_enchanted_book"), lifestealThreeBook);
            lifestealThreeBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealTwoBook));
            lifestealThreeBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealTwoBook));
            Bukkit.getServer().addRecipe(lifestealThreeBookRecipe);

            lifestealFourBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_four_enchanted_book"), lifestealFourBook);
            lifestealFourBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealThreeBook));
            lifestealFourBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealThreeBook));
            Bukkit.getServer().addRecipe(lifestealFourBookRecipe);

            lifestealFiveBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_five_enchanted_book"), lifestealFiveBook);
            lifestealFiveBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealFourBook));
            lifestealFiveBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealFourBook));
            Bukkit.getServer().addRecipe(lifestealFiveBookRecipe);

            infectionOneBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "infection_one_enchanted_book"), infectionOneBook);
            infectionOneBookRecipe.addIngredient(1, Material.BOOK);
            infectionOneBookRecipe.addIngredient(1, Material.SPIDER_EYE);
            Bukkit.getServer().addRecipe(infectionOneBookRecipe);

            infectionTwoBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "infection_two_enchanted_book"), infectionTwoBook);
            infectionTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(infectionOneBook));
            infectionTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(infectionOneBook));
            Bukkit.getServer().addRecipe(infectionTwoBookRecipe);

            witheringOneBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "withering_one_enchanted_book"), witheringOneBook);
            witheringOneBookRecipe.addIngredient(1, Material.BOOK);
            witheringOneBookRecipe.addIngredient(1, Material.COAL);
            witheringOneBookRecipe.addIngredient(1, Material.BONE);
            Bukkit.getServer().addRecipe(witheringOneBookRecipe);

            witheringTwoBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "withering_two_enchanted_book"), witheringTwoBook);
            witheringTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(witheringOneBook));
            witheringTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(witheringOneBook));
            Bukkit.getServer().addRecipe(witheringTwoBookRecipe);

            heavinessOneBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "heaviness_one_enchanted_book"), heavinessOneBook);
            heavinessOneBookRecipe.addIngredient(1, Material.BOOK);
            heavinessOneBookRecipe.addIngredient(1, Material.IRON_BLOCK);
            Bukkit.getServer().addRecipe(heavinessOneBookRecipe);

            heavinessTwoBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "heaviness_two_enchanted_book"), heavinessTwoBook);
            heavinessTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(heavinessOneBook));
            heavinessTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(heavinessOneBook));
            Bukkit.getServer().addRecipe(heavinessTwoBookRecipe);
            
            TwistCraft.instance.messageServer("Custom Enchants enabled!", p);
            enabled = true;
        }
        else {
            // Remove recipes
            Bukkit.getServer().removeRecipe(opLootBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(telepathyBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(lifestealOneBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(lifestealTwoBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(lifestealThreeBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(lifestealFourBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(lifestealFiveBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(infectionOneBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(infectionTwoBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(witheringOneBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(witheringTwoBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(heavinessOneBookRecipe.getKey());
            Bukkit.getServer().removeRecipe(heavinessTwoBookRecipe.getKey());

            TwistCraft.instance.messageServer("Custom Enchants disabled!", p);
            enabled = false;
        }

        return true;
    }
}
