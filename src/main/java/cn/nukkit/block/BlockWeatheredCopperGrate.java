package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWeatheredCopperGrate extends BlockCopperGrateBase {
    @Override
    public String getName() {
        return "Weathered Copper Grate";
    }

    @Override
    public int getId() {
        return WEATHERED_COPPER_GRATE;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.WEATHERED;
    }
}
