package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityPainting;
import org.bukkit.entity.Painting;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBPainting extends LBEntity implements Painting {
    public LBPainting(LBWorld w, EntityPainting e) {
        super(w, e);
    }
}
