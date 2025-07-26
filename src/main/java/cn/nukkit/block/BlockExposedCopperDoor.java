package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockExposedCopperDoor extends BlockCopperDoorBase {

    public BlockExposedCopperDoor() {
        this(0);
    }

    public BlockExposedCopperDoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Exposed Copper Door";
    }

    @Override
    public int getId() {
        return EXPOSED_COPPER_DOOR;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.EXPOSED;
    }
}
