package com.basspro.scm.block;

import com.basspro.scm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockSandSCM extends BlockSand
{

    public BlockSandSCM(int id, Material material)
    {
        super(id, material);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {

        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":" + this.getUnlocalizedName2());
    }
    
}
