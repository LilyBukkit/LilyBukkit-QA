package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityMob;
import org.bukkit.entity.Monster;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBMonster extends LBCreature implements Monster {

    EntityMob entity;

    public LBMonster(LBWorld w, EntityMob e) {
        super(w,e);
        this.entity = e;
    }
}
