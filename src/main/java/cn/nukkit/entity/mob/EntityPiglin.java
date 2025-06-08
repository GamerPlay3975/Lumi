package cn.nukkit.entity.mob;

import cn.nukkit.Player;


import cn.nukkit.entity.EntityAgeable;
import cn.nukkit.entity.EntityWalkable;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author Erik Miller | EinBexiii
 */

public class EntityPiglin extends EntityMob implements EntityWalkable, EntityAgeable {

    public final static int NETWORK_ID = 123;

    public EntityPiglin(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    @Override
    protected void initEntity() {
        this.setMaxHealth(16);
        super.initEntity();
    }

    @Override
    public float getWidth() {
        return 0.6f;
    }

    @Override
    public float getHeight() {
        return 1.9f;
    }

    
    
    @Override
    public String getOriginalName() {
        return "Piglin";
    }

    
    @Override
    public boolean isPreventingSleep(Player player) {
        return !this.isBaby()/*TODO: Should this check player's golden armor?*/;
    }
}
