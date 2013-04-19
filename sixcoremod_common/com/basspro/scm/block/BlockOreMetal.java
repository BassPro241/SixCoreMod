package com.basspro.scm.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.basspro.scm.SixCoreMod;

public class BlockOreMetal extends BlockSCM
{
    public BlockOreMetal(int id, Material material)
    {
        super(id, material);

        setHardness(3.0F);
        setStepSound(Block.soundMetalFootstep);
        setCreativeTab(SixCoreMod.tabSixCoreModBlock);
    }
}
