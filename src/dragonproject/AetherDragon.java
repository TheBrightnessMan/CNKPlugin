package dragonproject;

import net.minecraft.server.v1_15_R1.*;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EnderDragon;

public class AetherDragon extends EntityEnderDragon {

    public AetherDragon(World world) {
        super(EntityTypes.ENDER_DRAGON, world);

        EnderDragon dragon = (EnderDragon) this.getBukkitEntity();

        dragon.setCustomName("" + ChatColor.WHITE + ChatColor.BOLD + "Aether Dragon");
        dragon.setCustomNameVisible(true);
        PathfinderGoalNearestAttackableTarget target = new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, true);
        this.targetSelector.a(0, target);
        dragon.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1000);
        world.addEntity(this);
    }
}
