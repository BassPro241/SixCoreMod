package com.basspro.scm.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.basspro.scm.SixCoreMod;
import com.basspro.scm.lib.Reference;
import com.basspro.scm.worldpandora.PandoraTeleporter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPandoraPortal extends BlockPortal
{

    public BlockPandoraPortal(int par1)
    {
        super(par1);
        this.setTickRandomly(true);
        this.setCreativeTab(SixCoreMod.tabSixCoreModBlock);
        this.setHardness(-1.0F);
        this.setStepSound(Block.soundGlassFootstep);
        this.setLightValue(0.75F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {

        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":" + this.getUnlocalizedName2());
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4,
            Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.provider.isSurfaceWorld()
                && par5Random.nextInt(2000) < par1World.difficultySetting)
        {
            int l;

            for (l = par3; !par1World.doesBlockHaveSolidTopSurface(par2, l,
                    par4) && l > 0; --l)
            {
                ;
            }

            if (l > 0 && !par1World.isBlockNormalCube(par2, l + 1, par4))
            {
                Entity entity = ItemMonsterPlacer.spawnCreature(par1World, 57,
                        (double) par2 + 0.5D, (double) l + 1.1D,
                        (double) par4 + 0.5D);

                if (entity != null)
                {
                    entity.timeUntilPortal = entity.getPortalCooldown();
                }
            }
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
            int par2, int par3, int par4)
    {
        return null;
    }

    /*
     * Updates the blocks bounds based on its current state. Args: world, x, y,
     * z
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
            int par2, int par3, int par4)
    {
        float f;
        float f1;

        if (par1IBlockAccess.getBlockId(par2 - 1, par3, par4) != this.blockID
                && par1IBlockAccess.getBlockId(par2 + 1, par3, par4) != this.blockID)
        {
            f = 0.125F;
            f1 = 0.5F;
            this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F,
                    0.5F + f1);
        }
        else
        {
            f = 0.5F;
            f1 = 0.125F;
            this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F,
                    0.5F + f1);
        }
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean tryToCreatePortal(World par1World, int par2, int par3,
            int par4)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (par1World.getBlockId(par2 - 1, par3, par4) == Block.blockEmerald.blockID
                || par1World.getBlockId(par2 + 1, par3, par4) == Block.blockEmerald.blockID)
        {
            b0 = 1;
        }

        if (par1World.getBlockId(par2, par3, par4 - 1) == Block.blockEmerald.blockID
                || par1World.getBlockId(par2, par3, par4 + 1) == Block.blockEmerald.blockID)
        {
            b1 = 1;
        }

        if (b0 == b1)
        {
            return false;
        }
        else
        {
            if (par1World.getBlockId(par2 - b0, par3, par4 - b1) == 0)
            {
                par2 -= b0;
                par4 -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l)
            {
                for (i1 = -1; i1 <= 3; ++i1)
                {
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
                    {
                        int j1 = par1World.getBlockId(par2 + b0 * l, par3 + i1,
                                par4 + b1 * l);

                        if (flag)
                        {
                            if (j1 != Block.blockEmerald.blockID)
                            {
                                return false;
                            }
                        }
                        else if (j1 != 0 && j1 != Block.fire.blockID)
                        {
                            return false;
                        }
                    }
                }
            }

            for (l = 0; l < 2; ++l)
            {
                for (i1 = 0; i1 < 3; ++i1)
                {
                    par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l,
                            SixCoreModBlocks.pandoraPortal.blockID, 0, 2);
                }
            }

            return true;
        }
    }

    /*
     * Lets the block know when one of its neighbor changes. Doesn't know which
     * neighbor changed (coordinates passed are their own) Args: x, y, z,
     * neighbor blockID
     */

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3,
            int par4, int par5)
    {
        byte b0 = 0;
        byte b1 = 1;

        if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID
                || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID)
        {
            b0 = 1;
            b1 = 0;
        }

        int i1;

        for (i1 = par3; par1World.getBlockId(par2, i1 - 1, par4) == this.blockID; --i1)
        {
            ;
        }

        if (par1World.getBlockId(par2, i1 - 1, par4) != Block.blockEmerald.blockID)
        {
            par1World.setBlockToAir(par2, par3, par4);
        }
        else
        {
            int j1;

            for (j1 = 1; j1 < 4
                    && par1World.getBlockId(par2, i1 + j1, par4) == this.blockID; ++j1)
            {
                ;
            }

            if (j1 == 3
                    && par1World.getBlockId(par2, i1 + j1, par4) == Block.blockEmerald.blockID)
            {
                boolean flag = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID
                        || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
                boolean flag1 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID
                        || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;

                if (flag && flag1)
                {
                    par1World.setBlockToAir(par2, par3, par4);
                }
                else
                {
                    if ((par1World.getBlockId(par2 + b0, par3, par4 + b1) != Block.blockEmerald.blockID || par1World
                            .getBlockId(par2 - b0, par3, par4 - b1) != this.blockID)
                            && (par1World
                                    .getBlockId(par2 - b0, par3, par4 - b1) != Block.blockEmerald.blockID || par1World
                                    .getBlockId(par2 + b0, par3, par4 + b1) != this.blockID))
                    {
                        par1World.setBlockToAir(par2, par3, par4);
                    }
                }
            }
            else
            {
                par1World.setBlockToAir(par2, par3, par4);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    /*
     * Returns true if the given side of this block type should be rendered, if
     * the adjacent block is at the given coordinates. Args: blockAccess, x, y,
     * z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess,
            int par2, int par3, int par4, int par5)
    {
        if (par1IBlockAccess.getBlockId(par2, par3, par4) == this.blockID)
        {
            return false;
        }
        else
        {
            boolean flag = par1IBlockAccess.getBlockId(par2 - 1, par3, par4) == this.blockID
                    && par1IBlockAccess.getBlockId(par2 - 2, par3, par4) != this.blockID;
            boolean flag1 = par1IBlockAccess.getBlockId(par2 + 1, par3, par4) == this.blockID
                    && par1IBlockAccess.getBlockId(par2 + 2, par3, par4) != this.blockID;
            boolean flag2 = par1IBlockAccess.getBlockId(par2, par3, par4 - 1) == this.blockID
                    && par1IBlockAccess.getBlockId(par2, par3, par4 - 2) != this.blockID;
            boolean flag3 = par1IBlockAccess.getBlockId(par2, par3, par4 + 1) == this.blockID
                    && par1IBlockAccess.getBlockId(par2, par3, par4 + 2) != this.blockID;
            boolean flag4 = flag || flag1;
            boolean flag5 = flag2 || flag3;
            return flag4 && par5 == 4 ? true : (flag4 && par5 == 5 ? true
                    : (flag5 && par5 == 2 ? true : flag5 && par5 == 3));
        }
    }

    @Override
    /*
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    @Override
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
            int par4, Entity par5Entity)
    {
        if (par5Entity.ridingEntity == null
                && par5Entity.riddenByEntity == null)
        {
            if (par5Entity instanceof EntityPlayerMP)
            {
                EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;
                if (par5Entity.dimension != SixCoreMod.dimension)
                {
                    thePlayer.mcServer
                            .getConfigurationManager()
                            .transferPlayerToDimension(
                                    thePlayer,
                                    SixCoreMod.dimension,
                                    new PandoraTeleporter(
                                            thePlayer.mcServer
                                                    .worldServerForDimension(SixCoreMod.dimension)));
                }
                else
                {
                    thePlayer.mcServer.getConfigurationManager()
                            .transferPlayerToDimension(
                                    thePlayer,
                                    0,
                                    new PandoraTeleporter(thePlayer.mcServer
                                            .worldServerForDimension(0)));
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3,
            int par4, Random par5Random)
    {
        if (par5Random.nextInt(100) == 0)
        {
            par1World.playSound((double) par2 + 0.5D, (double) par3 + 0.5D,
                    (double) par4 + 0.5D, "portal.portal", 0.5F,
                    par5Random.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int l = 0; l < 4; ++l)
        {
            double d0 = (double) ((float) par2 + par5Random.nextFloat());
            double d1 = (double) ((float) par3 + par5Random.nextFloat());
            double d2 = (double) ((float) par4 + par5Random.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = par5Random.nextInt(2) * 2 - 1;
            d3 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;

            if (par1World.getBlockId(par2 - 1, par3, par4) != this.blockID
                    && par1World.getBlockId(par2 + 1, par3, par4) != this.blockID)
            {
                d0 = (double) par2 + 0.5D + 0.25D * (double) i1;
                d3 = (double) (par5Random.nextFloat() * 2.0F * (float) i1);
            }
            else
            {
                d2 = (double) par4 + 0.5D + 0.25D * (double) i1;
                d5 = (double) (par5Random.nextFloat() * 2.0F * (float) i1);
            }

            par1World.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return 0;
    }

}
