package com.basspro.scm.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.item.Item;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class CorrosionParticle extends EntityFX
{
    public CorrosionParticle(World par1World, double par2, double par4,
            double par6, Item par8Item, RenderEngine par9RenderEngine)
    {
        super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
        this.setParticleIcon(par9RenderEngine, par8Item.getIconFromDamage(0));
        this.particleGreen = 1.0F;
        this.particleGravity = Block.blockSnow.blockParticleGravity;
        this.particleScale /= 2.0F;
    }
}
