package cn.nukkit.entity;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.math.Vector3;
import cn.nukkit.nbt.tag.CompoundTag;
import org.jetbrains.annotations.NotNull;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public abstract class EntityCreature extends EntityLiving implements EntityNameable, EntityAgeable {

    public EntityCreature(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public boolean onInteract(Player player, Item item, Vector3 clickedPos) {
        if (item.getId() == Item.NAME_TAG && !player.isAdventure()) {
            return this.applyNameTag(player, item);
        }
        return false;
    }

    public final boolean playerApplyNameTag(@NotNull Player player, @NotNull Item item) {
        return applyNameTag(player, item);
    }

    // Structured like this so I can override nametags in player and dragon classes
    // without overriding onInteract.
    protected boolean applyNameTag(Player player, Item item) {
        if (item.hasCustomName()) {
            this.setNameTag(item.getCustomName());
            this.setNameTagVisible(true);

            if (!player.isCreative()) {
                player.getInventory().removeItem(item);
            }
            // Set entity as persistent.
            return true;
        }
        return false;
    }
}
