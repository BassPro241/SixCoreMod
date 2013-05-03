package com.basspro.scm.worldpandora;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import com.basspro.scm.SixCoreMod;
import com.basspro.scm.worldpandora.gen.ChunkProviderPandora;

public class WorldProviderPandora extends WorldProvider
{
    @Override
    public String getDimensionName()
    {
        return "Pandora";
    }

    public boolean canRespawnHere()
    {
        return true;
    }

    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.beach,
                0.8F, 0.1F);
        this.dimensionId = SixCoreMod.dimension;
    }

    @Override
    public IChunkProvider createChunkGenerator()
    {
        return new ChunkProviderPandora(worldObj, worldObj.getSeed(), true);
    }
}
