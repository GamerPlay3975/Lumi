package cn.nukkit.entity.mob;




import cn.nukkit.entity.EntityWalkable;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityMagmaCube extends EntityMob implements EntityWalkable {

    public static final int NETWORK_ID = 42;

    public EntityMagmaCube(FullChunk chunk, CompoundTag nbt) {
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
        return 2.04f;
    }

    @Override
    public float getHeight() {
        return 2.04f;
    }

    
    
    @Override
    public int getFrostbiteInjury() {
        return 5;
    }

    
    
    @Override
    public String getOriginalName() {
        return "Magma Cube";
    }
}
