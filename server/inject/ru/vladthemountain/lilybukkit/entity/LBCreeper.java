package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityCreeper;
import org.bukkit.entity.Creeper;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBCreeper extends LBMonster implements Creeper {
    EntityCreeper entity;

    public LBCreeper(LBWorld w, EntityCreeper e) {
        super(w,e);
        this.entity = e;
    }
}
