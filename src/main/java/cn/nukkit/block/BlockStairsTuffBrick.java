package cn.nukkit.block;

import cn.nukkit.item.ItemTool;

public class BlockStairsTuffBrick extends BlockStairs {
    public BlockStairsTuffBrick() {
        this(0);
    }

    public BlockStairsTuffBrick(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return TUFF_BRICK_STAIRS;
    }

    @Override
    public String getName() {
        return "Tuff Brick Stairs";
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public double getResistance() {
        return 6;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int getToolTier() {
        return ItemTool.TIER_WOODEN;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }
}
