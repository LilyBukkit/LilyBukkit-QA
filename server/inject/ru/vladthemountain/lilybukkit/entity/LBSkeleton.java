package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntitySkeleton;
import org.bukkit.entity.Skeleton;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBSkeleton extends LBMonster implements Skeleton {

    EntitySkeleton entity;

    public LBSkeleton(LBWorld w, EntitySkeleton e) {
        super(w, e);
        this.entity = e;
    }
}
