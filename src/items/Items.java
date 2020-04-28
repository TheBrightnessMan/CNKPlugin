package items;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

import static items.Reg.rarity;

public class Items {

    public static ItemStack stickystick() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta mstick = stick.getItemMeta();
        mstick.setDisplayName(ChatColor.GREEN + "Sticky Stick");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "This mythical stick allows you to keep your inventory");
        lore.add(ChatColor.WHITE + "when you die, but you will lose it afterwards");
        lore.add("");
        lore.add(rarity(Tier.MYTHICAL));
        mstick.setLore(lore);
        stick.setItemMeta(mstick);

        return stick;
    }

    public static ItemStack slimeboots() {
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta mboots = boots.getItemMeta();
        LeatherArmorMeta meta = (LeatherArmorMeta) mboots;
        mboots.setDisplayName(ChatColor.GREEN + "Slime Boots");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "Lets you bounce like a slime, mitigating fall damage");
        lore.add("");
        lore.add(rarity(Tier.RARE));
        mboots.setLore(lore);
        meta.setColor(Color.GREEN);
        meta.setUnbreakable(true);
        boots.setItemMeta(mboots);

        return boots;
    }

    public static ItemStack grapple() {
        ItemStack grappling = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = grappling.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "Grappling Hook");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "Fling yourself into the air");
        lore.add("");
        lore.add(rarity(Tier.UNCOMMON));
        meta.setLore(lore);
        meta.setUnbreakable(true);
        grappling.setItemMeta(meta);

        return grappling;
    }

    public static ItemStack pearlpickaxe() {
        ItemStack pearlpick = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = pearlpick.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "Ender Pickaxe");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "The blocks you mine goes into a nearby chest");
        lore.add("");
        lore.add(rarity(Tier.UNCOMMON));
        meta.setLore(lore);
        pearlpick.setItemMeta(meta);

        return pearlpick;
    }

    public static ItemStack pearlshovel() {
        ItemStack pearlpick = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = pearlpick.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "Ender Shovel");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "The blocks you mine goes into a nearby chest");
        lore.add("");
        lore.add(rarity(Tier.UNCOMMON));
        meta.setLore(lore);
        pearlpick.setItemMeta(meta);

        return pearlpick;
    }

    public static ItemStack pearlaxe() {
        ItemStack pearlpick = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = pearlpick.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "Ender Axe");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "The blocks you mine goes into a nearby chest");
        lore.add("");
        lore.add(rarity(Tier.UNCOMMON));
        meta.setLore(lore);
        pearlpick.setItemMeta(meta);

        return pearlpick;
    }

    public static ItemStack oldperalpickaxe() {

        ItemStack pearlpick = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = pearlpick.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "Ender Pickaxe");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "The blocks you mine goes into a nearby chest");
        lore.add("");
        lore.add(rarity(Tier.LEGENDARY));
        meta.setLore(lore);
        meta.setUnbreakable(true);
        pearlpick.setItemMeta(meta);

        return pearlpick;
    }

    public static ItemStack slimecore() {
        ItemStack slime = new ItemStack(Material.SLIME_BALL);
        ItemMeta slimemeta = slime.getItemMeta();
        slimemeta.setDisplayName(ChatColor.GREEN + "Slime Core");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(rarity(Tier.UNCOMMON));
        slimemeta.setLore(lore);
        slime.addUnsafeEnchantment(Enchantment.OXYGEN, 1);
        slimemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        slime.setItemMeta(slimemeta);

        return slime;
    }

    public static ItemStack spawndrag() {
        ItemStack summon = new ItemStack(Material.BONE);
        ItemMeta meta = summon.getItemMeta();
        meta.setDisplayName("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Dragon Bones");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "Place this on the alter to summon the dragon");
        lore.add("");
        lore.add(rarity(Tier.EPIC));
        meta.setLore(lore);
        summon.setItemMeta(meta);

        return summon;
    }
}
