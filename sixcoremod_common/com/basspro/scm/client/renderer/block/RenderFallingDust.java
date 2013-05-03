package com.basspro.scm.client.renderer.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderFallingSand;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.basspro.scm.block.SixCoreModBlocks;
import com.basspro.scm.lib.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFallingDust extends RenderFallingSand
{
    private RenderBlocks dustRenderBlocks = new RenderBlocks();

    @Override
    public void doRenderFallingSand(EntityFallingSand par1EntityFallingDust,
            double par2, double par4, double par6, float par8, float par9)
    {
        World world = par1EntityFallingDust.getWorld();
        Block block = Block.blocksList[par1EntityFallingDust.blockID];

        if (world.getBlockId(
                MathHelper.floor_double(par1EntityFallingDust.posX),
                MathHelper.floor_double(par1EntityFallingDust.posY),
                MathHelper.floor_double(par1EntityFallingDust.posZ)) != par1EntityFallingDust.blockID)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef((float) par2, (float) par4, (float) par6);
            if (Block.blocksList[par1EntityFallingDust.blockID].blockID == SixCoreModBlocks.blockDust.blockID)
            {
                this.loadTexture(Textures.BLOCK_DUST_BLOCK);
            } else
                this.loadTexture("/terrain.png");
            GL11.glDisable(GL11.GL_LIGHTING);
            Tessellator tessellator;

            if (block instanceof BlockAnvil && block.getRenderType() == 35)
            {
                this.dustRenderBlocks.blockAccess = world;
                tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                tessellator
                        .setTranslation(
                                (double) ((float) (-MathHelper
                                        .floor_double(par1EntityFallingDust.posX)) - 0.5F),
                                (double) ((float) (-MathHelper
                                        .floor_double(par1EntityFallingDust.posY)) - 0.5F),
                                (double) ((float) (-MathHelper
                                        .floor_double(par1EntityFallingDust.posZ)) - 0.5F));
                this.dustRenderBlocks.renderBlockAnvilMetadata(
                        (BlockAnvil) block,
                        MathHelper.floor_double(par1EntityFallingDust.posX),
                        MathHelper.floor_double(par1EntityFallingDust.posY),
                        MathHelper.floor_double(par1EntityFallingDust.posZ),
                        par1EntityFallingDust.metadata);
                tessellator.setTranslation(0.0D, 0.0D, 0.0D);
                tessellator.draw();
            } else if (block.getRenderType() == 27)
            {
                this.dustRenderBlocks.blockAccess = world;
                tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                tessellator
                        .setTranslation(
                                (double) ((float) (-MathHelper
                                        .floor_double(par1EntityFallingDust.posX)) - 0.5F),
                                (double) ((float) (-MathHelper
                                        .floor_double(par1EntityFallingDust.posY)) - 0.5F),
                                (double) ((float) (-MathHelper
                                        .floor_double(par1EntityFallingDust.posZ)) - 0.5F));
                this.dustRenderBlocks.renderBlockDragonEgg(
                        (BlockDragonEgg) block,
                        MathHelper.floor_double(par1EntityFallingDust.posX),
                        MathHelper.floor_double(par1EntityFallingDust.posY),
                        MathHelper.floor_double(par1EntityFallingDust.posZ));
                tessellator.setTranslation(0.0D, 0.0D, 0.0D);
                tessellator.draw();
            } else if (block != null)
            {
                this.dustRenderBlocks.setRenderBoundsFromBlock(block);
                this.dustRenderBlocks.renderBlockSandFalling(block, world,
                        MathHelper.floor_double(par1EntityFallingDust.posX),
                        MathHelper.floor_double(par1EntityFallingDust.posY),
                        MathHelper.floor_double(par1EntityFallingDust.posZ),
                        par1EntityFallingDust.metadata);
            }

            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();
        }
    }
}
