package cn.nukkit.entity;

import cn.nukkit.entity.ai.memory.CoreMemoryTypes;

public interface EntityAngryable extends EntityComponent {
    default boolean isAngry() {
        return getMemoryStorage().get(CoreMemoryTypes.IS_ANGRY);
    }

    default void setAngry(boolean angry) {
        getMemoryStorage().put(CoreMemoryTypes.IS_ANGRY, angry);
        asEntity().setDataFlag(Entity.DATA_FLAGS, Entity.DATA_FLAG_ANGRY, angry);
    }
}