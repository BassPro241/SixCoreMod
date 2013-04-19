package com.basspro.scm.block;

import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;

import com.basspro.scm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOreSCM extends BlockOre
{
    public BlockOreSCM(int id)
    {

        super(id);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {

        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":" + this.getUnlocalizedName2());
    }
}
