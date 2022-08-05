package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import org.bukkit.World;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import ru.vladthemountain.lilybukkit.inventory.LBPlayerInventory;

import java.util.Set;

public class LBHumanEntity extends LBLivingEntity implements HumanEntity {

    final EntityPlayer entity;
    boolean op;

    public LBHumanEntity(World w, EntityPlayer e) {
        super(w, e);
        this.entity = e;
        this.op = false;
    }

    @Override
    public String getName() {
        return this.entity.username;
    }

    @Override
    public PlayerInventory getInventory() {
        return new LBPlayerInventory(this.entity.inventory);
    }

    @Override
    public ItemStack getItemInHand() {
        net.minecraft.src.ItemStack ci = this.entity.inventory.getCurrentItem();
        return new ItemStack(ci.itemID, ci.stackSize, (short) ci.itemDmg);
    }

    @Override
    public void setItemInHand(ItemStack itemStack) {
        this.entity.inventory.setInventorySlotContents(this.entity.inventory.currentItem, new net.minecraft.src.ItemStack(itemStack.getTypeId(), itemStack.getAmount(), itemStack.getDurability()));
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
        return this.op;
    }

    @Override
    public void setOp(boolean b) {
        this.op = b;
    }

    @Override
    public Entity getHandle() {return this.entity;}
}
