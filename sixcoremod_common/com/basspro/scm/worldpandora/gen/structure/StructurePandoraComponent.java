package com.basspro.scm.worldpandora.gen.structure;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public abstract class StructurePandoraComponent extends StructureComponent
{

    public StructurePandoraDecorator deco = null;
    public int spawnListIndex = 0;

    public StructurePandoraComponent(int i)
    {
        super(i);
    }

    public static StructureBoundingBox getComponentToAddBoundingBox(int x,
            int y, int z, int minX, int minY, int minZ, int maxX, int maxY,
            int maxZ, int dir)
    {
        switch (dir)
        {
            default:
                return new StructureBoundingBox(x + minX, y + minY, z + minZ, x
                        + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            case 0:
                return new StructureBoundingBox(x + minX, y + minY, z + minZ, x
                        + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            case 1:
                return new StructureBoundingBox(x - maxZ + minZ, y + minY, z
                        + minX, x + minZ, y + maxY + minY, z + maxX + minX);
            case 2:
                return new StructureBoundingBox(x - maxX - minX, y + minY, z
                        - maxZ - minZ, x - minX, y + maxY + minY, z - minZ);
            case 3:
        }
        return new StructureBoundingBox(x + minZ, y + minY, z - maxX, x + maxZ
                + minZ, y + maxY + minY, z + minX);
    }

    protected TileEntityMobSpawner placeSpawnerAtCurrentPosition(World world,
            Random rand, int x, int y, int z, String monsterID,
            StructureBoundingBox sbb)
    {
        TileEntityMobSpawner tileEntitySpawner = null;

        int dx = getXWithOffset(x, z);
        int dy = getYWithOffset(y);
        int dz = getZWithOffset(x, z);
        if ((sbb.isVecInside(dx, dy, dz))
                && (world.getBlockId(dx, dy, dz) != Block.mobSpawner.blockID))
        {
            world.setBlock(dx, dy, dz, Block.mobSpawner.blockID, 0, 2);
            tileEntitySpawner = (TileEntityMobSpawner) world
                    .getBlockTileEntity(dx, dy, dz);
            if (tileEntitySpawner != null)
            {
                tileEntitySpawner.func_98049_a().setMobID(monsterID);
            }
        }

        return tileEntitySpawner;
    }

    protected TileEntityMobSpawner placeSpawnerRotated(World world, int x,
            int y, int z, int rotation, String monsterID,
            StructureBoundingBox sbb)
    {
        TileEntityMobSpawner tileEntitySpawner = null;

        int dx = getXWithOffsetAsIfRotated(x, z, rotation);
        int dy = getYWithOffset(y);
        int dz = getZWithOffsetAsIfRotated(x, z, rotation);
        if ((sbb.isVecInside(dx, dy, dz))
                && (world.getBlockId(dx, dy, dz) != Block.mobSpawner.blockID))
        {
            world.setBlock(dx, dy, dz, Block.mobSpawner.blockID, 0, 2);
            tileEntitySpawner = (TileEntityMobSpawner) world
                    .getBlockTileEntity(dx, dy, dz);
            if (tileEntitySpawner != null)
            {
                tileEntitySpawner.func_98049_a().setMobID(monsterID);
            }
        }

        return tileEntitySpawner;
    }


    protected int[] offsetTowerCoords(int x, int y, int z, int towerSize,
            int direction)
    {
        int dx = getXWithOffset(x, z);
        int dy = getYWithOffset(y);
        int dz = getZWithOffset(x, z);

        if (direction == 0)
        {
            return new int[] { dx + 1, dy - 1, dz - towerSize / 2 };
        }
        if (direction == 1)
        {
            return new int[] { dx + towerSize / 2, dy - 1, dz + 1 };
        }
        if (direction == 2)
        {
            return new int[] { dx - 1, dy - 1, dz + towerSize / 2 };
        }
        if (direction == 3)
        {
            return new int[] { dx - towerSize / 2, dy - 1, dz - 1 };
        }

        return new int[] { x, y, z };
    }

    public int[] getOffsetAsIfRotated(int[] src, int rotation)
    {
        int temp = getCoordBaseMode();
        int[] dest = new int[3];
        setCoordBaseMode(rotation);

        dest[0] = getXWithOffset(src[0], src[2]);
        dest[1] = getYWithOffset(src[1]);
        dest[2] = getZWithOffset(src[0], src[2]);

        setCoordBaseMode(temp);
        return dest;
    }

    protected int getXWithOffset(int x, int z)
    {
        switch (getCoordBaseMode())
        {
            case 0:
                return this.boundingBox.minX + x;
            case 1:
                return this.boundingBox.maxX - z;
            case 2:
                return this.boundingBox.maxX - x;
            case 3:
                return this.boundingBox.minX + z;
        }
        return x;
    }

    protected int getYWithOffset(int par1)
    {
        return super.getYWithOffset(par1);
    }

    protected int getZWithOffset(int x, int z)
    {
        switch (getCoordBaseMode())
        {
            case 0:
                return this.boundingBox.minZ + z;
            case 1:
                return this.boundingBox.minZ + x;
            case 2:
                return this.boundingBox.maxZ - z;
            case 3:
                return this.boundingBox.maxZ - x;
        }
        return z;
    }

    protected int getXWithOffsetAsIfRotated(int x, int z, int rotation)
    {
        if (this.coordBaseMode < 0)
        {
            return x;
        }

        switch ((this.coordBaseMode + rotation) % 4)
        {
            case 0:
                return this.boundingBox.minX + x;
            case 1:
                return this.boundingBox.maxX - z;
            case 2:
                return this.boundingBox.maxX - x;
            case 3:
                return this.boundingBox.minX + z;
        }
        return x;
    }

    protected int getZWithOffsetAsIfRotated(int x, int z, int rotation)
    {
        if (this.coordBaseMode < 0)
        {
            return x;
        }

        switch ((this.coordBaseMode + rotation) % 4)
        {
            case 0:
                return this.boundingBox.minZ + z;
            case 1:
                return this.boundingBox.minZ + x;
            case 2:
                return this.boundingBox.maxZ - z;
            case 3:
                return this.boundingBox.maxZ - x;
        }
        return z;
    }

    public int getCoordBaseMode()
    {
        return this.coordBaseMode;
    }

    public void setCoordBaseMode(int coordBaseMode)
    {
        this.coordBaseMode = coordBaseMode;
    }

    protected int getBlockIdAtCurrentPosition(World par1World, int par2,
            int par3, int par4, StructureBoundingBox par5StructureBoundingBox)
    {
        return super.getBlockIdAtCurrentPosition(par1World, par2, par3, par4,
                par5StructureBoundingBox);
    }

    protected void placeBlockAtCurrentPosition(World par1World, int par2,
            int par3, int par4, int par5, int par6,
            StructureBoundingBox par7StructureBoundingBox)
    {
        super.placeBlockAtCurrentPosition(par1World, par2, par3, par4, par5,
                par6, par7StructureBoundingBox);
    }

    protected void placeBlockRotated(World world, int blockID, int meta, int x,
            int y, int z, int rotation, StructureBoundingBox sbb)
    {
        int dx = getXWithOffsetAsIfRotated(x, z, rotation);
        int dy = getYWithOffset(y);
        int dz = getZWithOffsetAsIfRotated(x, z, rotation);

        if (sbb.isVecInside(dx, dy, dz))
        {
            world.setBlock(dx, dy, dz, blockID, meta, 2);
        }
    }

    protected int getBlockIDRotated(World world, int x, int y, int z,
            int rotation, StructureBoundingBox sbb)
    {
        int dx = getXWithOffsetAsIfRotated(x, z, rotation);
        int dy = getYWithOffset(y);
        int dz = getZWithOffsetAsIfRotated(x, z, rotation);

        if (sbb.isVecInside(dx, dy, dz))
        {
            return world.getBlockId(dx, dy, dz);
        }

        return 0;
    }

    protected void fillBlocksRotated(World world, StructureBoundingBox sbb,
            int minX, int minY, int minZ, int maxX, int maxY, int maxZ,
            int blockID, int meta, int rotation)
    {
        for (int dx = minY; dx <= maxY; dx++)
        {
            for (int dy = minX; dy <= maxX; dy++)
            {
                for (int dz = minZ; dz <= maxZ; dz++)
                {
                    placeBlockRotated(world, blockID, meta, dy, dx, dz,
                            rotation, sbb);
                }
            }
        }
    }

    protected void fillAirRotated(World world, StructureBoundingBox sbb,
            int minX, int minY, int minZ, int maxX, int maxY, int maxZ,
            int rotation)
    {
        fillBlocksRotated(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, 0, 0,
                rotation);
    }

    

    protected int getStairMeta(int dir)
    {
        switch ((getCoordBaseMode() + dir) % 4)
        {
            case 0:
                return 0;
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 3;
        }
        return -1;
    }

    protected int getLadderMeta(int ladderDir)
    {
        switch ((getCoordBaseMode() + ladderDir) % 4)
        {
            case 0:
                return 4;
            case 1:
                return 2;
            case 2:
                return 5;
            case 3:
                return 3;
        }
        return -1;
    }

    protected int getLadderMeta(int ladderDir, int rotation)
    {
        return getLadderMeta(ladderDir + rotation);
    }

    public void nullifySkyLightForBoundingBox(World world)
    {
        nullifySkyLight(world, this.boundingBox.minX - 1,
                this.boundingBox.minY - 1, this.boundingBox.minZ - 1,
                this.boundingBox.maxX + 1, this.boundingBox.maxY + 1,
                this.boundingBox.maxZ + 1);
    }

    public void nullifySkyLightAtCurrentPosition(World world, int sx, int sy,
            int sz, int dx, int dy, int dz)
    {
        nullifySkyLight(world, getXWithOffset(sx, sz), getYWithOffset(sy),
                getZWithOffset(sx, sz), getXWithOffset(dx, dz),
                getYWithOffset(dy), getZWithOffset(dx, dz));
    }

    public void nullifySkyLight(World world, int sx, int sy, int sz, int dx,
            int dy, int dz)
    {
        for (int x = sx; x <= dx; x++)
        {
            for (int z = sz; z <= dz; z++)
            {
                for (int y = sy; y <= dy; y++)
                {
                    world.setLightValue(EnumSkyBlock.Sky, x, y, z, 0);
                }
            }
        }
    }

}
