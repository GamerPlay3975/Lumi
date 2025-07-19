package cn.nukkit.item;

import cn.nukkit.Player;
import cn.nukkit.entity.effect.EffectType;
import cn.nukkit.event.entity.EntityEffectUpdateEvent;
import cn.nukkit.math.Vector3;
import cn.nukkit.network.protocol.ProtocolInfo;

public class ItemHoneyBottle extends ItemFood {
    
    public ItemHoneyBottle() {
        this(0, 1);
    }
    
    public ItemHoneyBottle(Integer meta) {
        this(meta, 1);
    }
    
    public ItemHoneyBottle(Integer meta, int count) {
        super(HONEY_BOTTLE, meta, count, "Honey Bottle");
    }
    
    @Override
    public int getMaxStackSize() {
        return 16;
    }
    
    @Override
    public boolean onClickAir(Player player, Vector3 directionVector) {
        return true;
    }

    @Override
    public int getFoodRestore() {
        return 6;
    }

    @Override
    public float getSaturationRestore() {
        return 1.2F;
    }

    @Override
    public boolean onEaten(Player player) {
        player.getInventory().addItem(new ItemGlassBottle());
        player.removeEffect(EffectType.POISON);

        return true;
    }

    @Override
    public boolean isSupportedOn(int protocolId) {
        return protocolId >= ProtocolInfo.v1_14_0;
    }
}
