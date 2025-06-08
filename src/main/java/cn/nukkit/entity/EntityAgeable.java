package cn.nukkit.entity;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public interface EntityAgeable {
    default boolean isBaby() {
        return ((Entity) this).getDataFlag(Entity.DATA_FLAGS, Entity.DATA_FLAG_BABY);
    }

    default void setBaby(boolean flag) {
        var entity = (Entity) this;
        entity.setDataFlag(Entity.DATA_FLAGS, Entity.DATA_FLAG_BABY, flag);
        entity.setScale(flag ? 0.5f : 1f);
    }
}