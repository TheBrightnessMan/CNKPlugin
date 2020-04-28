package dragonproject;

import net.minecraft.server.v1_15_R1.*;
import org.bukkit.entity.Enderman;

public class NewEnderman extends EntityEnderman {

    public NewEnderman(World world) {
        super(EntityTypes.ENDERMAN, world);

        Enderman enderman = (Enderman) this.getBukkitEntity();
        PathfinderGoalNearestAttackableTarget target = new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, true);
        this.targetSelector.a(0, target);
        world.addEntity(this);
    }
}
