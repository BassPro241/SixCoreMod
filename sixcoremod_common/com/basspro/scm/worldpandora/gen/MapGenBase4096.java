package com.basspro.scm.worldpandora.gen;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;

public class MapGenBase4096 extends MapGenBase
{
    public void generate(IChunkProvider par1IChunkProvider, World par2World,
            int cx, int cz, short[] par5ArrayOfByte)
    {
        int rangeVar = this.range;
        this.worldObj = par2World;
        this.rand.setSeed(par2World.getSeed());
        long long1 = this.rand.nextLong();
        long long2 = this.rand.nextLong();

        for (int gx = cx - rangeVar; gx <= cx + rangeVar; gx++)
        {
            for (int gz = cz - rangeVar; gz <= cz + rangeVar; gz++)
            {
                long var13 = gx * long1;
                long var15 = gz * long2;
                this.rand.setSeed(var13 ^ var15 ^ par2World.getSeed());
                recursiveGenerate(par2World, gx, gz, cx, cz, par5ArrayOfByte);
            }
        }
    }

    protected void recursiveGenerate(World par1World, int genX, int genZ,
            int centerX, int centerZ, short[] par6ArrayOfByte)
    {
    }

}
