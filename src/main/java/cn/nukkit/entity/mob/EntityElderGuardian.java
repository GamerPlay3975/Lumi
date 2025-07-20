package cn.nukkit.entity.mob;

import cn.nukkit.Player;
import cn.nukkit.block.BlockSponge;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityCreature;
import cn.nukkit.entity.effect.Effect;
import cn.nukkit.entity.effect.EffectType;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.LevelEventPacket;
import cn.nukkit.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class EntityElderGuardian extends EntitySwimmingMob {

    public static final int NETWORK_ID = 50;

    public EntityElderGuardian(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return 1.9975f;
    }

    @Override
    public float getHeight() {
        return 1.9975f;
    }

    @Override
    public void initEntity() {
        this.setMaxHealth(80);

        super.initEntity();

        this.setDataFlag(DATA_FLAGS, DATA_FLAG_ELDER, true);
        this.setDamage(new int[] { 0, 5, 8, 12 });
    }

    @Override
    public boolean targetOption(EntityCreature creature, double distance) {
        return false;
    }

    @Override
    public void attackEntity(Entity player) {
    }

    @Override
    public Item[] getDrops() {
        List<Item> drops = new ArrayList<>();

        drops.add(Item.get(Item.PRISMARINE_SHARD, 0, Utils.rand(0, 2)));

        if (this.lastDamageCause instanceof EntityDamageByEntityEvent) {
            if (((EntityDamageByEntityEvent) this.lastDamageCause).getDamager() instanceof Player) {
                drops.add(Item.get(Item.SPONGE, BlockSponge.WET, 1));
            }
        }

        return drops.toArray(Item.EMPTY_ARRAY);
    }

    @Override
    public int getKillExperience() {
        return 10;
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.getNameTag() : "Elder Guardian";
    }

    @Override
    public boolean entityBaseTick(int tickDiff) {
        boolean result = super.entityBaseTick(tickDiff);
        if (!this.closed && this.ticksLived % 1200 == 0 && this.isAlive()) {
            for (Player player : this.level.getPlayers().values()) {
                if (player.getGamemode() % 2 == 0 && player.distanceSquared(this) < 2500 && !player.hasEffect(EffectType.MINING_FATIGUE)) {
                    player.addEffect(Effect.get(EffectType.MINING_FATIGUE).setAmplifier(2).setDuration(6000));
                    LevelEventPacket packet = new LevelEventPacket();
                    packet.evid = LevelEventPacket.EVENT_GUARDIAN_CURSE;
                    packet.x = (float) this.x;
                    packet.y = (float) this.y;
                    packet.z = (float) this.z;
                    player.dataPacket(packet);
                }
            }
        }
        return result;
    }
}
