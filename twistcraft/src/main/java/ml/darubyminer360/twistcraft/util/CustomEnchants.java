package ml.darubyminer360.twistcraft.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

import ml.darubyminer360.twistcraft.util.EnchantmentWrapper;
import org.bukkit.enchantments.Enchantment;

public class CustomEnchants {
    public static final Enchantment OPLOOT = new EnchantmentWrapper("oploot", "OP Loot", 1);
    public static final Enchantment TELEPATHY = new EnchantmentWrapper("telepathy", "Telepathy", 1);

    public static void register() {
        boolean registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(TELEPATHY);

        if (!registered) {
            registerEnchantment(OPLOOT);
            registerEnchantment(TELEPATHY);
        }
    }

    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;
        
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        if (registered) {
        }
    }
}
