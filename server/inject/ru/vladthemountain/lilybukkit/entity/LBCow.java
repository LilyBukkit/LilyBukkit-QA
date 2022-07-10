package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityCow;
import org.bukkit.entity.Cow;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBCow extends LBAnimals implements Cow {

    public LBCow(LBWorld w, EntityCow e) {
        super(w,e);
    }
}
