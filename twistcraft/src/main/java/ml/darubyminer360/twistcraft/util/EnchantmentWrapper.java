package ml.darubyminer360.twistcraft.util;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class EnchantmentWrapper extends Enchantment {
    final String name;
    final int maxLevel;

    final boolean cursed;
    final boolean treasure;
    
    public EnchantmentWrapper(String namespace, String name, int level, boolean cursed = false, boolean treasure = false) {
        super(NamespacedKey.minecraft(namespace));
        this.maxLevel = level;
        this.name = name;
        
        this.cursed = cursed;
        this.treasure = treasure;
    }

    @Override
    public boolean canEnchantItem(ItemStack arg0) {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment arg0) {
        return false;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStartLevel() {
        return 0;
    }

    @Override
    public boolean isCursed() {
        return this.cursed;
    }
    
    @Override
    public boolean isTreasure() {
        return this.treasure;
    }
}
