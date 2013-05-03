package com.basspro.scm.block;

import com.basspro.scm.SixCoreMod;

import net.minecraft.block.material.Material;

public class BlockDust extends BlockSandSCM
{
    public BlockDust(int par1, Material material)
    {
        super(par1, material);
        setStepSound(soundSandFootstep);
        setCreativeTab(SixCoreMod.tabSixCoreModBlock);
    }

}
