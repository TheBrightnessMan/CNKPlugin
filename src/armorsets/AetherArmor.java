package armorsets;

import items.Tier;
import net.minecraft.server.v1_15_R1.*;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.jar.Attributes;

import static items.Reg.rarity;

public class AetherArmor {

    public static ItemStack helemt() {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta mhel = helmet.getItemMeta();

        mhel.setDisplayName(ChatColor.GOLD + "Aether Dragon Helmet");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Piece ability: " + ChatColor.GOLD + "Draconic Sight");
        lore.add(ChatColor.WHITE + "Gives you permanent night vision");
        lore.add("");

        lore.add(ChatColor.AQUA + "Full set Bonus: " + ChatColor.GOLD + "One With the Dragon");
        lore.add(ChatColor.WHITE + "Reduces damage taken by 90%");
        lore.add("");

        lore.add(rarity(Tier.LEGENDARY));
        mhel.setLore(lore);
        LeatherArmorMeta meta = (LeatherArmorMeta) mhel;
        meta.setColor(Color.BLACK);
        mhel.setUnbreakable(true);
        helmet.setItemMeta(meta);
        helmet.setItemMeta(mhel);

        return helmet;
    }

    public static ItemStack chestplate() {
        ItemStack helmet = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta mhel = helmet.getItemMeta();

        mhel.setDisplayName(ChatColor.GOLD + "Aether Dragon Chestplate");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Piece ability: " + ChatColor.GOLD + "Aviator");
        lore.add(ChatColor.WHITE + "This turns into an elytra when you are in the air");
        lore.add(ChatColor.WHITE + "When this turns into an elytra, press shift to launch yourself");
        lore.add("");

        lore.add(ChatColor.AQUA + "Full set Bonus: " + ChatColor.GOLD + "One With the Dragon");
        lore.add(ChatColor.WHITE + "Reduces damage taken by 90%");
        lore.add("");

        lore.add(rarity(Tier.LEGENDARY));
        mhel.setUnbreakable(true);
        mhel.setLore(lore);
        LeatherArmorMeta meta = (LeatherArmorMeta) mhel;

        meta.setColor(Color.BLACK);
        helmet.setItemMeta(meta);
        helmet.setItemMeta(mhel);

        return helmet;
    }

    public static ItemStack leggings() {
        ItemStack helmet = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta mhel = helmet.getItemMeta();

        mhel.setDisplayName(ChatColor.GOLD + "Aether Dragon Leggings");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Piece ability: " + ChatColor.GOLD + "Speedster");
        lore.add(ChatColor.WHITE + "Gives you permanent speed boost");
        lore.add("");

        lore.add(ChatColor.AQUA + "Full set Bonus: " + ChatColor.GOLD + "One With the Dragon");
        lore.add(ChatColor.WHITE + "Reduces damage taken by 90%");
        lore.add("");

        lore.add(rarity(Tier.LEGENDARY));
        mhel.setLore(lore);
        LeatherArmorMeta meta = (LeatherArmorMeta) mhel;
        meta.setColor(Color.BLACK);
        mhel.setUnbreakable(true);
        helmet.setItemMeta(meta);
        helmet.setItemMeta(mhel);

        return helmet;
    }

    public static ItemStack boots() {
        ItemStack helmet = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta mhel = helmet.getItemMeta();

        mhel.setDisplayName(ChatColor.GOLD + "Aether Dragon Boots");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Piece ability: " + ChatColor.GOLD + "Feather Falling");
        lore.add(ChatColor.WHITE + "Gives immunity to fall damage");
        lore.add("");

        lore.add(ChatColor.AQUA + "Full set Bonus: " + ChatColor.GOLD + "One With the Dragon");
        lore.add(ChatColor.WHITE + "Reduces damage taken by 90%");
        lore.add("");

        lore.add(rarity(Tier.LEGENDARY));

        mhel.setLore(lore);
        LeatherArmorMeta meta = (LeatherArmorMeta) mhel;
        meta.setColor(Color.BLACK);
        mhel.setUnbreakable(true);
        helmet.setItemMeta(meta);
        helmet.setItemMeta(mhel);

        return helmet;
    }

    public static ItemStack elytra() {
        ItemStack helmet = new ItemStack(Material.ELYTRA);
        ItemMeta meta = helmet.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "Aether Dragon Wings");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Piece ability: " + ChatColor.GOLD + "Aviator");
        lore.add(ChatColor.WHITE + "Shift to launch yourself");
        lore.add("");

        lore.add(ChatColor.AQUA + "Full set Bonus: " + ChatColor.GOLD + "One With the Dragon");
        lore.add(ChatColor.WHITE + "Reduces damage taken by 90%");
        lore.add("");

        lore.add(rarity(Tier.LEGENDARY));
        meta.setLore(lore);
        meta.setUnbreakable(true);
        helmet.setItemMeta(meta);

        return helmet;
    }

    public static ItemStack sword() {
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = sword.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Aetherial Blade");

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Good Stuff");
        lore.add("");
        lore.add(rarity(Tier.LEGENDARY));
        meta.setLore(lore);
        meta.setUnbreakable(true);
        sword.setItemMeta(meta);

        return sword;
    }
}
