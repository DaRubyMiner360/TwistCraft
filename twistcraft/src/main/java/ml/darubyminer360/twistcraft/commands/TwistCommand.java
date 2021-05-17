package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.*;
import ml.darubyminer360.twistcraft.util.*;
import ml.darubyminer360.twistcraft.inventories.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Iterator;
import java.util.Random;

public class TwistCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "list":
                    TwistCraft.instance.messageServer("- Craftable Command Blocks (craftablecommandblocks)", p);
                    TwistCraft.instance.messageServer("- Craftable Barrier Blocks (craftablebarrierblocks)", p);
                    TwistCraft.instance.messageServer("- Craftable Enchanted Golden Apples (craftableenchantedgoldenapples)", p);
                    TwistCraft.instance.messageServer("- OP Mobs (opmobs)", p);
                    TwistCraft.instance.messageServer("- Half Heart Eating (halfhearteating)", p);
                    TwistCraft.instance.messageServer("- Manhunt (manhunt <speedrunner>)", p);
                    TwistCraft.instance.messageServer("- Everywhere Looked (everywherelooked <mode>)", p);
                    TwistCraft.instance.messageServer("- Death Swap (deathswap <other>)", p);
                    TwistCraft.instance.messageServer("- TNT Runner (tntrunner <cooldown>)", p);
                    TwistCraft.instance.messageServer("- Falling Blocks (fallingblocks <cooldown>)", p);
                    TwistCraft.instance.messageServer("- Raining Items (rainingitems <cooldown>)", p);
                    TwistCraft.instance.messageServer("- Sneak Invisibility (sneakinvisibility)", p);
                    TwistCraft.instance.messageServer("- Allowed Flight (allowedflight)", p);
                    TwistCraft.instance.messageServer("- Custom Enchants (customenchants)", p);
                    break;
                case "enable":
                    if (args[1].equalsIgnoreCase("craftablecommandblocks")) {
                        // Add recipe
                        CraftableCommandBlocksCommand.commandBlockRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "command_block"), new ItemStack(Material.COMMAND_BLOCK));
                        CraftableCommandBlocksCommand.commandBlockRecipe.addIngredient(1, Material.CRAFTING_TABLE);
                        CraftableCommandBlocksCommand.commandBlockRecipe.addIngredient(1, Material.OAK_BUTTON);
                        Bukkit.getServer().addRecipe(CraftableCommandBlocksCommand.commandBlockRecipe);

                        TwistCraft.instance.messageServer("Craftable Command Blocks enabled!", p);
                        CraftableCommandBlocksCommand.enabled = true;
                    }
                    else if (args[1].equalsIgnoreCase("craftablebarrierblocks")) {
                        // Add recipe
                        CraftableBarrierBlocksCommand.barrierBlockRecipex1 = new ShapedRecipe(new NamespacedKey(TwistCraft.instance, "barrier_block"), new ItemStack(Material.BARRIER, 1));
                        CraftableBarrierBlocksCommand.barrierBlockRecipex1.shape(
                                " G ",
                                "GDG",
                                " G "
                        );
                        CraftableBarrierBlocksCommand.barrierBlockRecipex1.setIngredient('G', Material.GLASS);
                        CraftableBarrierBlocksCommand.barrierBlockRecipex1.setIngredient('D', Material.RED_DYE);
                        Bukkit.getServer().addRecipe(CraftableBarrierBlocksCommand.barrierBlockRecipex1);

                        CraftableBarrierBlocksCommand.barrierBlockRecipex2 = new ShapedRecipe(new NamespacedKey(TwistCraft.instance, "barrier_block_x2"), new ItemStack(Material.BARRIER, 2));
                        CraftableBarrierBlocksCommand.barrierBlockRecipex2.shape(
                                "GGG",
                                "GDG",
                                "GGG"
                        );
                        CraftableBarrierBlocksCommand.barrierBlockRecipex2.setIngredient('G', Material.GLASS);
                        CraftableBarrierBlocksCommand.barrierBlockRecipex2.setIngredient('D', Material.RED_DYE);
                        Bukkit.getServer().addRecipe(CraftableBarrierBlocksCommand.barrierBlockRecipex2);

                        TwistCraft.instance.messageServer("Craftable Barrier Blocks enabled!", p);
                        CraftableBarrierBlocksCommand.enabled = true;
                    }
                    else if (args[1].equalsIgnoreCase("craftableenchantedgoldenapples")) {
                        // Add recipe
                        CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe = new ShapedRecipe(new NamespacedKey(TwistCraft.instance, "enchanted_golden_apple"), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
                        CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe.shape(
                                "GGG",
                                "GAG",
                                "GGG"
                        );
                        CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe.setIngredient('G', Material.GOLD_BLOCK);
                        CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe.setIngredient('A', Material.APPLE);
                        Bukkit.getServer().addRecipe(CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe);

                        TwistCraft.instance.messageServer("Craftable Enchanted Golden Apples enabled!", p);
                        CraftableEnchantedGoldenApplesCommand.enabled = true;
                    }
                    else if (args[1].equalsIgnoreCase("opmobs")) {
                        TwistCraft.instance.messageServer("OP Mobs enabled!", p);
                        OPMobsCommand.enabled = true;
                    }
                    else if (args[1].equalsIgnoreCase("halfhearteating")) {
                        TwistCraft.instance.messageServer("Half Heart Eating enabled!", p);
                        HalfHeartEatingCommand.enabled = true;
                    }
                    else if (args[1].equalsIgnoreCase("manhunt")) {
                        if (args.length > 2) {
                            ManhuntCommand.hunted = args[2];

                            TwistCraft.instance.messageServer("Manhunt enabled! " + args[2] + " is the speedrunner!", p);
                            ManhuntCommand.enabled = true;
                        }
                        else {
                            p.sendMessage("Add the speedrunner as an argument!");
                        }
                    }
                    else if (args[1].equalsIgnoreCase("everywherelooked")) {
                        if (args.length > 2) {
                            TwistCraft.instance.messageServer("Everywhere Looked enabled! " + args[2] + " is the selected mode!", p);
                            EverywhereLookedCommand.enabled = true;
                        }
                        else {
                            p.sendMessage("Add the mode as an argument!");
                        }
                    }
                    else if (args[1].equalsIgnoreCase("deathswap")) {
                        if (args.length > 2) {
                            Player p2 = p.getServer().getPlayer(args[2]);

                            BukkitScheduler scheduler = p.getServer().getScheduler();
                            DeathSwapCommand.task1 = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                                int num = 10;

                                @Override
                                public void run() {
                                    if (num == 0) {
                                        p.getServer().broadcastMessage("Go!");
                                        p.getServer().getScheduler().cancelTask(DeathSwapCommand.task1);
                                    }
                                    else {
                                        p.getServer().broadcastMessage(Integer.toString(num--));
                                    }
                                }
                            }, 20L, 20L);
                            DeathSwapCommand.task2 = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                                @Override
                                public void run() {
                                    DeathSwapCommand.task3 = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                                        int num = 20;

                                        @Override
                                        public void run() {
                                            if (num == 0) {
                                                Location l1 = p.getLocation();
                                                p.teleport(p2.getLocation());
                                                p2.teleport(l1);
                                                p.getServer().getScheduler().cancelTask(DeathSwapCommand.task3);
                                            }
                                            else {
                                                p.getServer().broadcastMessage(Integer.toString(num--));
                                            }
                                        }
                                    }, 0L, 20L);
                                }
                            }, 6020L, 6000L);

                            TwistCraft.instance.messageServer("Death Swap enabled! The players are " + p.getDisplayName() + " and " + args[2] + "!", p);
                            DeathSwapCommand.enabled = true;
                        }
                        else {
                            p.sendMessage("Add the other player as an argument!");
                        }
                    }
                    else if (args[1].equalsIgnoreCase("tntrunner")) {
                        if (args.length > 2) {
                            int cooldown = Integer.parseInt(args[2]);

                            BukkitScheduler scheduler = p.getServer().getScheduler();
                            TNTRunnerCommand.task = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                                @Override
                                public void run() {
                                    Entity tnt = p.getWorld().spawn(p.getLocation(), TNTPrimed.class);
                                    ((TNTPrimed)tnt).setFuseTicks(80);
                                }
                            }, cooldown, cooldown);

                            TwistCraft.instance.messageServer("TNT Runner enabled with a cooldown of " + args[2] + "!", p);
                            TNTRunnerCommand.enabled = true;
                        }
                        else {
                            p.sendMessage("Add the amount of time between TNT spawns in ticks (20 ticks is 1 second) as an argument!");
                        }
                    }
                    else if (args[1].equalsIgnoreCase("fallingblocks")) {
                        if (args.length > 2) {
                            int cooldown = Integer.parseInt(args[2]);

                            BukkitScheduler scheduler = p.getServer().getScheduler();
                            FallingBlocksCommand.task = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                                @Override
                                public void run() {
                                    Random rnd = new Random();
                                    Material material = FallingBlocksCommand.mats[rnd.nextInt(FallingBlocksCommand.mats.length)];

                                    while (!material.isBlock() || material.isLegacy()) {
                                        material = FallingBlocksCommand.mats[rnd.nextInt(FallingBlocksCommand.mats.length)];
                                    }

                                    int x = rnd.nextInt(26);
                                    if (rnd.nextBoolean()) {
                                        x = -x;
                                    }

                                    int z = rnd.nextInt(26);
                                    if (rnd.nextBoolean()) {
                                        z = -z;
                                    }

                                    Location location = p.getLocation();
                                    location.add(x, 100, z);

                                    location.getWorld().spawnFallingBlock(location, material.createBlockData());
                                }
                            }, cooldown, cooldown);

                            TwistCraft.instance.messageServer("Falling Blocks enabled with a cooldown of " + args[2] + "!", p);
                            FallingBlocksCommand.enabled = true;
                        }
                        else {
                            p.sendMessage("Add the amount of time between blocks in ticks (20 ticks is 1 second) as an argument!");
                        }
                    }
                    else if (args[1].equalsIgnoreCase("rainingitems")) {
                        if (args.length > 2) {
                            int cooldown = Integer.parseInt(args[2]);

                            BukkitScheduler scheduler = p.getServer().getScheduler();
                            RainingItemsCommand.task = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                                @Override
                                public void run() {
                                    Random rnd = new Random();
                                    Material material = RainingItemsCommand.mats[rnd.nextInt(RainingItemsCommand.mats.length)];

                                    while (material.isLegacy()) {
                                        material = RainingItemsCommand.mats[rnd.nextInt(RainingItemsCommand.mats.length)];
                                    }

                                    int x = rnd.nextInt(16);
                                    if (rnd.nextBoolean()) {
                                        x = -x;
                                    }

                                    int z = rnd.nextInt(16);
                                    if (rnd.nextBoolean()) {
                                        z = -z;
                                    }

                                    Location location = p.getLocation();
                                    location.add(x, 100, z);

                                    Item item = location.getWorld().dropItem(location, new ItemStack(material, 1));
                                    item.setPickupDelay(0);
                                }
                            }, cooldown, cooldown);

                            TwistCraft.instance.messageServer("Raining Items enabled with a cooldown of " + args[2] + "!", p);
                            RainingItemsCommand.enabled = true;
                        }
                        else {
                            p.sendMessage("Add the amount of time between items in ticks (20 ticks is 1 second) as an argument!");
                        }
                    }
                    else if (args[1].equalsIgnoreCase("sneakinvisibility")) {
                        TwistCraft.instance.messageServer("Sneak Invisibility enabled!", p);
                        SneakInvisibilityCommand.enabled = true;
                    }
                    else if (args[1].equalsIgnoreCase("allowedflight")) {
                        for (Player player: Bukkit.getOnlinePlayers()) {
                            player.setAllowFlight(true);
                        }

                        TwistCraft.instance.messageServer("Allowed Flight enabled!", p);
                        AllowedFlightCommand.enabled = true;
                    }
                    else if (args[1].equalsIgnoreCase("customenchants")) {
                        // Add recipes
                        ItemStack opLootBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta opLootBookMeta = (EnchantmentStorageMeta) opLootBook.getItemMeta();
                        opLootBookMeta.addStoredEnchant(CustomEnchants.OPLOOT, 1, true);
                        opLootBook.setItemMeta(opLootBookMeta);

                        ItemStack telepathyBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta telepathyBookMeta = (EnchantmentStorageMeta) telepathyBook.getItemMeta();
                        telepathyBookMeta.addStoredEnchant(CustomEnchants.TELEPATHY, 1, true);
                        telepathyBook.setItemMeta(telepathyBookMeta);

                        ItemStack lifestealOneBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta lifestealOneBookMeta = (EnchantmentStorageMeta) lifestealOneBook.getItemMeta();
                        lifestealOneBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 1, true);
                        lifestealOneBook.setItemMeta(lifestealOneBookMeta);

                        ItemStack lifestealTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta lifestealTwoBookMeta = (EnchantmentStorageMeta) lifestealTwoBook.getItemMeta();
                        lifestealTwoBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 2, true);
                        lifestealTwoBook.setItemMeta(lifestealTwoBookMeta);

                        ItemStack lifestealThreeBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta lifestealThreeBookMeta = (EnchantmentStorageMeta) lifestealThreeBook.getItemMeta();
                        lifestealThreeBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 3, true);
                        lifestealThreeBook.setItemMeta(lifestealThreeBookMeta);

                        ItemStack lifestealFourBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta lifestealFourBookMeta = (EnchantmentStorageMeta) lifestealFourBook.getItemMeta();
                        lifestealFourBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 4, true);
                        lifestealFourBook.setItemMeta(lifestealFourBookMeta);

                        ItemStack lifestealFiveBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta lifestealFiveBookMeta = (EnchantmentStorageMeta) lifestealFiveBook.getItemMeta();
                        lifestealFiveBookMeta.addStoredEnchant(CustomEnchants.LIFESTEAL, 5, true);
                        lifestealFiveBook.setItemMeta(lifestealFiveBookMeta);

                        ItemStack infectionOneBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta infectionOneBookMeta = (EnchantmentStorageMeta) infectionOneBook.getItemMeta();
                        infectionOneBookMeta.addStoredEnchant(CustomEnchants.INFECTION, 1, true);
                        infectionOneBook.setItemMeta(infectionOneBookMeta);

                        ItemStack infectionTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta infectionTwoBookMeta = (EnchantmentStorageMeta) infectionTwoBook.getItemMeta();
                        infectionTwoBookMeta.addStoredEnchant(CustomEnchants.INFECTION, 2, true);
                        infectionTwoBook.setItemMeta(infectionTwoBookMeta);

                        ItemStack witheringOneBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta witheringOneBookMeta = (EnchantmentStorageMeta) witheringOneBook.getItemMeta();
                        witheringOneBookMeta.addStoredEnchant(CustomEnchants.WITHERING, 1, true);
                        witheringOneBook.setItemMeta(witheringOneBookMeta);

                        ItemStack witheringTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta witheringTwoBookMeta = (EnchantmentStorageMeta) witheringTwoBook.getItemMeta();
                        witheringTwoBookMeta.addStoredEnchant(CustomEnchants.WITHERING, 2, true);
                        witheringTwoBook.setItemMeta(witheringTwoBookMeta);

                        ItemStack heavinessOneBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta heavinessOneBookMeta = (EnchantmentStorageMeta) heavinessOneBook.getItemMeta();
                        heavinessOneBookMeta.addStoredEnchant(CustomEnchants.HEAVINESS, 1, true);
                        heavinessOneBook.setItemMeta(heavinessOneBookMeta);

                        ItemStack heavinessTwoBook = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta heavinessTwoBookMeta = (EnchantmentStorageMeta) heavinessTwoBook.getItemMeta();
                        heavinessTwoBookMeta.addStoredEnchant(CustomEnchants.HEAVINESS, 2, true);
                        heavinessTwoBook.setItemMeta(heavinessTwoBookMeta);

                        CustomEnchantsCommand.opLootBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "op_loot_enchanted_book"), opLootBook);
                        CustomEnchantsCommand.opLootBookRecipe.addIngredient(1, Material.BOOK);
                        CustomEnchantsCommand.opLootBookRecipe.addIngredient(1, Material.IRON_INGOT);
                        CustomEnchantsCommand.opLootBookRecipe.addIngredient(1, Material.GOLD_INGOT);
                        CustomEnchantsCommand.opLootBookRecipe.addIngredient(1, Material.DIAMOND);
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.opLootBookRecipe);

                        CustomEnchantsCommand.telepathyBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "telepathy_enchanted_book"), telepathyBook);
                        CustomEnchantsCommand.telepathyBookRecipe.addIngredient(1, Material.BOOK);
                        CustomEnchantsCommand.telepathyBookRecipe.addIngredient(1, Material.ENDER_PEARL);
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.telepathyBookRecipe);

                        CustomEnchantsCommand.lifestealOneBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_one_enchanted_book"), lifestealOneBook);
                        CustomEnchantsCommand.lifestealOneBookRecipe.addIngredient(1, Material.BOOK);
                        CustomEnchantsCommand.lifestealOneBookRecipe.addIngredient(1, Material.REDSTONE);
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.lifestealOneBookRecipe);

                        CustomEnchantsCommand.lifestealTwoBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_two_enchanted_book"), lifestealTwoBook);
                        CustomEnchantsCommand.lifestealTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealOneBook));
                        CustomEnchantsCommand.lifestealTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealOneBook));
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.lifestealTwoBookRecipe);

                        CustomEnchantsCommand.lifestealThreeBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_three_enchanted_book"), lifestealThreeBook);
                        CustomEnchantsCommand.lifestealThreeBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealTwoBook));
                        CustomEnchantsCommand.lifestealThreeBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealTwoBook));
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.lifestealThreeBookRecipe);

                        CustomEnchantsCommand.lifestealFourBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_four_enchanted_book"), lifestealFourBook);
                        CustomEnchantsCommand.lifestealFourBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealThreeBook));
                        CustomEnchantsCommand.lifestealFourBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealThreeBook));
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.lifestealFourBookRecipe);

                        CustomEnchantsCommand.lifestealFiveBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "lifesteal_five_enchanted_book"), lifestealFiveBook);
                        CustomEnchantsCommand.lifestealFiveBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealFourBook));
                        CustomEnchantsCommand.lifestealFiveBookRecipe.addIngredient(new RecipeChoice.ExactChoice(lifestealFourBook));
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.lifestealFiveBookRecipe);

                        CustomEnchantsCommand.infectionOneBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "infection_one_enchanted_book"), infectionOneBook);
                        CustomEnchantsCommand.infectionOneBookRecipe.addIngredient(1, Material.BOOK);
                        CustomEnchantsCommand.infectionOneBookRecipe.addIngredient(1, Material.SPIDER_EYE);
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.infectionOneBookRecipe);

                        CustomEnchantsCommand.infectionTwoBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "infection_two_enchanted_book"), infectionTwoBook);
                        CustomEnchantsCommand.infectionTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(infectionOneBook));
                        CustomEnchantsCommand.infectionTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(infectionOneBook));
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.infectionTwoBookRecipe);

                        CustomEnchantsCommand.witheringOneBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "withering_one_enchanted_book"), witheringOneBook);
                        CustomEnchantsCommand.witheringOneBookRecipe.addIngredient(1, Material.BOOK);
                        CustomEnchantsCommand.witheringOneBookRecipe.addIngredient(1, Material.COAL);
                        CustomEnchantsCommand.witheringOneBookRecipe.addIngredient(1, Material.BONE);
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.witheringOneBookRecipe);

                        CustomEnchantsCommand.witheringTwoBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "withering_two_enchanted_book"), witheringTwoBook);
                        CustomEnchantsCommand.witheringTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(witheringOneBook));
                        CustomEnchantsCommand.witheringTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(witheringOneBook));
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.witheringTwoBookRecipe);

                        CustomEnchantsCommand.heavinessOneBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "heaviness_one_enchanted_book"), heavinessOneBook);
                        CustomEnchantsCommand.heavinessOneBookRecipe.addIngredient(1, Material.BOOK);
                        CustomEnchantsCommand.heavinessOneBookRecipe.addIngredient(1, Material.IRON_BLOCK);
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.heavinessOneBookRecipe);

                        CustomEnchantsCommand.heavinessTwoBookRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "heaviness_two_enchanted_book"), heavinessTwoBook);
                        CustomEnchantsCommand.heavinessTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(heavinessOneBook));
                        CustomEnchantsCommand.heavinessTwoBookRecipe.addIngredient(new RecipeChoice.ExactChoice(heavinessOneBook));
                        Bukkit.getServer().addRecipe(CustomEnchantsCommand.heavinessTwoBookRecipe);

                        TwistCraft.instance.messageServer("Custom Enchants enabled!", p);
                        CustomEnchantsCommand.enabled = true;
                    }
                    break;
                case "disable":
                    if (args[1].equalsIgnoreCase("craftablecommandblocks")) {
                        // Remove recipe
                        Bukkit.getServer().removeRecipe(CraftableCommandBlocksCommand.commandBlockRecipe.getKey());

                        TwistCraft.instance.messageServer("Craftable Command Blocks disabled!", p);
                        CraftableCommandBlocksCommand.enabled = false;
                    }
                    else if (args[1].equalsIgnoreCase("craftablebarrierblocks")) {
                        // Remove recipe
                        Bukkit.getServer().removeRecipe(CraftableBarrierBlocksCommand.barrierBlockRecipex1.getKey());
                        Bukkit.getServer().removeRecipe(CraftableBarrierBlocksCommand.barrierBlockRecipex2.getKey());

                        TwistCraft.instance.messageServer("Craftable Barrier Blocks disabled!", p);
                        CraftableBarrierBlocksCommand.enabled = false;
                    }
                    else if (args[1].equalsIgnoreCase("craftableenchantedgoldenapples")) {
                        // Remove recipe
                        Bukkit.getServer().removeRecipe(CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe.getKey());

                        TwistCraft.instance.messageServer("Craftable Enchanted Golden Apples disabled!", p);
                        CraftableEnchantedGoldenApplesCommand.enabled = false;
                    }
                    else if (args[1].equalsIgnoreCase("opmobs")) {
                        TwistCraft.instance.messageServer("OP Mobs disabled!", p);
                        OPMobsCommand.enabled = false;
                    }
                    else if (args[1].equalsIgnoreCase("halfhearteating")) {
                        TwistCraft.instance.messageServer("Half Heart Eating disabled!", p);
                        HalfHeartEatingCommand.enabled = false;
                    }
                    else if (args[1].equalsIgnoreCase("manhunt")) {
                        TwistCraft.instance.messageServer("Manhunt disabled!", p);
                        ManhuntCommand.enabled = false;
                    }
                    else if (args[1].equalsIgnoreCase("everywherelooked")) {
                        TwistCraft.instance.messageServer("Everywhere Looked disabled!", p);
                        EverywhereLookedCommand.enabled = false;
                    }
                    else if (args[1].equalsIgnoreCase("deathswap")) {
                        if (DeathSwapCommand.enabled) {
                            p.getServer().getScheduler().cancelTask(DeathSwapCommand.task1);
                            p.getServer().getScheduler().cancelTask(DeathSwapCommand.task2);
                            p.getServer().getScheduler().cancelTask(DeathSwapCommand.task3);

                            TwistCraft.instance.messageServer("Death Swap disabled!", p);
                            DeathSwapCommand.enabled = false;
                        }
                    }
                    else if (args[1].equalsIgnoreCase("tntrunner")) {
                        if (TNTRunnerCommand.enabled) {
                            p.getServer().getScheduler().cancelTask(TNTRunnerCommand.task);

                            TwistCraft.instance.messageServer("TNT Runner disabled!", p);
                            TNTRunnerCommand.enabled = false;
                        }
                    }
                    else if (args[1].equalsIgnoreCase("fallingblocks")) {
                        if (FallingBlocksCommand.enabled) {
                            p.getServer().getScheduler().cancelTask(FallingBlocksCommand.task);

                            TwistCraft.instance.messageServer("Falling Blocks disabled!", p);
                            FallingBlocksCommand.enabled = false;
                        }
                    }
                    else if (args[1].equalsIgnoreCase("rainingitems")) {
                        if (RainingItemsCommand.enabled) {
                            p.getServer().getScheduler().cancelTask(RainingItemsCommand.task);

                            TwistCraft.instance.messageServer("Raining Items disabled!", p);
                            RainingItemsCommand.enabled = false;
                        }
                    }
                    else if (args[1].equalsIgnoreCase("sneakinvisibility")) {
                        TwistCraft.instance.messageServer("Sneak Invisibility disabled!", p);
                        SneakInvisibilityCommand.enabled = false;
                    }
                    else if (args[1].equalsIgnoreCase("allowedflight")) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            if (player.getGameMode() != GameMode.CREATIVE && player.getGameMode() != GameMode.SPECTATOR) {
                                player.setAllowFlight(false);
                            }
                        }

                        TwistCraft.instance.messageServer("Allowed Flight disabled!", p);
                        AllowedFlightCommand.enabled = false;
                    }
                    else if (args[1].equalsIgnoreCase("customenchants")) {
                        // Remove recipes
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.opLootBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.telepathyBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.lifestealOneBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.lifestealTwoBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.lifestealThreeBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.lifestealFourBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.lifestealFiveBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.infectionOneBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.infectionTwoBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.witheringOneBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.witheringTwoBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.heavinessOneBookRecipe.getKey());
                        Bukkit.getServer().removeRecipe(CustomEnchantsCommand.heavinessTwoBookRecipe.getKey());

                        TwistCraft.instance.messageServer("Custom Enchants disabled!", p);
                        CustomEnchantsCommand.enabled = false;
                    }
                    break;
                case "info":
                    if (args[1].equalsIgnoreCase("craftablecommandblocks")) {
                        TwistCraft.instance.messageServer("Craftable Command Blocks allows you to craft and use command blocks in survival mode.", p);
                    }
                    else if (args[1].equalsIgnoreCase("craftablebarrierblocks")) {
                        TwistCraft.instance.messageServer("Craftable Barrier Blocks allows you to craft barrier blocks.", p);
                    }
                    else if (args[1].equalsIgnoreCase("craftableenchantedgoldenapples")) {
                        TwistCraft.instance.messageServer("Craftable Enchanted Golden Apples allows you to craft enchanted golden apples.", p);
                    }
                    else if (args[1].equalsIgnoreCase("opmobs")) {
                        TwistCraft.instance.messageServer("OP Mobs makes every mob extremely overpowered.", p);
                    }
                    else if (args[1].equalsIgnoreCase("halfhearteating")) {
                        TwistCraft.instance.messageServer("Half Heart Eating makes eating bring you to half a heart.", p);
                    }
                    else if (args[1].equalsIgnoreCase("manhunt")) {
                        TwistCraft.instance.messageServer("Manhunt is the gamemode where a speedrunner attempts to defeat the Ender Dragon while one or more hunters try to kill the speedrunner.", p);
                    }
                    else if (args[1].equalsIgnoreCase("everywherelooked")) {
                        TwistCraft.instance.messageServer("Everywhere Looked makes it to where whereever a player looks, something happens!", p);
                    }
                    else if (args[1].equalsIgnoreCase("deathswap")) {
                        TwistCraft.instance.messageServer("Death Swap is the gamemode where two players try to kill each other with traps when they swap positions!", p);
                    }
                    else if (args[1].equalsIgnoreCase("tntrunner")) {
                        TwistCraft.instance.messageServer("TNT Runner makes TNT spawn on top of you every given amount of time!", p);
                    }
                    else if (args[1].equalsIgnoreCase("fallingblocks")) {
                        TwistCraft.instance.messageServer("Falling Blocks makes random blocks fall from the sky every given amount of time!", p);
                    }
                    else if (args[1].equalsIgnoreCase("rainingitems")) {
                        TwistCraft.instance.messageServer("Raining Items makes random items fall from the sky every given amount of time!", p);
                    }
                    else if (args[1].equalsIgnoreCase("sneakinvisibility")) {
                        TwistCraft.instance.messageServer("Sneak Invisibility makes it to where whenever a player sneaks, they become invisible!", p);
                    }
                    else if (args[1].equalsIgnoreCase("allowedflight")) {
                        TwistCraft.instance.messageServer("Allowed Flight allows everyone to fly like creative mode!", p);
                    }
                    else if (args[1].equalsIgnoreCase("customenchants")) {
                        TwistCraft.instance.messageServer("Custom Enchants adds new enchantments!", p);
                    }
                    break;
                default:
                    TwistSelectionScreen twistSelector = new TwistSelectionScreen();
                    p.openInventory(twistSelector.getInventory());
                    break;
            }
        }
        else {
            TwistSelectionScreen twistSelector = new TwistSelectionScreen();
            p.openInventory(twistSelector.getInventory());
        }

        return true;
    }
}
