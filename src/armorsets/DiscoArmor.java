package armorsets;

import items.Tier;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;

import static items.Reg.rarity;

public class DiscoArmor implements Listener {

    public static ItemStack discohel(Color c) {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta mhel = helmet.getItemMeta();
        mhel.setDisplayName(ChatColor.GOLD + "Disco Helmet");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Full set ability: " + ChatColor.GOLD + "Disco!");
        lore.add(ChatColor.WHITE + "This set changes color! Fancy");
        lore.add("");
        lore.add(rarity(Tier.UNCOMMON));
        mhel.setLore(lore);
        LeatherArmorMeta meta = (LeatherArmorMeta) mhel;
        meta.setColor(c);
        helmet.setItemMeta(meta);
        helmet.setItemMeta(mhel);
        helmet.setItemMeta(mhel);

        return helmet;
    }

    public static ItemStack discochest(Color c) {
        ItemStack helmet = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta mhel = helmet.getItemMeta();
        mhel.setDisplayName(ChatColor.GOLD + "Disco Chestplate");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Full set ability: " + ChatColor.GOLD + "Disco!");
        lore.add(ChatColor.WHITE + "This set changes color! Fancy");
        lore.add("");
        lore.add(rarity(Tier.UNCOMMON));
        mhel.setLore(lore);
        LeatherArmorMeta meta = (LeatherArmorMeta) mhel;
        meta.setColor(c);
        helmet.setItemMeta(meta);
        helmet.setItemMeta(mhel);
        helmet.setItemMeta(mhel);

        return helmet;
    }

    public static ItemStack discoleg(Color c) {
        ItemStack helmet = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta mhel = helmet.getItemMeta();
        mhel.setDisplayName(ChatColor.GOLD + "Disco Leggings");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Full set ability: " + ChatColor.GOLD + "Disco!");
        lore.add(ChatColor.WHITE + "This set changes color! Fancy");
        lore.add("");
        lore.add(rarity(Tier.UNCOMMON));
        mhel.setLore(lore);
        LeatherArmorMeta meta = (LeatherArmorMeta) mhel;
        meta.setColor(c);
        helmet.setItemMeta(meta);
        helmet.setItemMeta(mhel);
        helmet.setItemMeta(mhel);

        return helmet;
    }

    public static ItemStack discoboots(Color c) {
        ItemStack helmet = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta mhel = helmet.getItemMeta();
        mhel.setDisplayName(ChatColor.GOLD + "Disco Boots");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "Full set ability: " + ChatColor.GOLD + "Disco!");
        lore.add(ChatColor.WHITE + "This set changes color! Fancy");
        lore.add("");
        lore.add(rarity(Tier.UNCOMMON));
        mhel.setLore(lore);
        LeatherArmorMeta meta = (LeatherArmorMeta) mhel;
        meta.setColor(c);
        helmet.setItemMeta(meta);
        helmet.setItemMeta(mhel);

        return helmet;
    }
}
