package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMob;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import ru.vladthemountain.lilybukkit.LBWorld;

import java.util.Set;

public class LBHumanEntity extends LBLivingEntity implements HumanEntity {

    final EntityMob entity;

    public LBHumanEntity(LBWorld w, EntityMob e) {
        super(w, e);
        this.entity = e;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public PlayerInventory getInventory() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public ItemStack getItemInHand() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void setItemInHand(ItemStack itemStack) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean isPermissionSet(String s) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean isPermissionSet(Permission permission) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean hasPermission(String s) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean hasPermission(Permission permission) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int i) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void removeAttachment(PermissionAttachment permissionAttachment) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void recalculatePermissions() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean isOp() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void setOp(boolean b) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
