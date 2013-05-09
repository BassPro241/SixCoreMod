package com.basspro.scm.worldpandora.biome;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomePandoraDecorator extends BiomeDecorator
{

    public BiomePandoraDecorator(BiomeGenBase par1BiomeGenBase)
    {
        super(par1BiomeGenBase);

    }

    public void setTreesPerChunk(int treesPerChunk)
    {
        this.treesPerChunk = treesPerChunk;
    }

    public void setBigMushroomsPerChunk(int bigMushroomsPerChunk)
    {
        this.bigMushroomsPerChunk = bigMushroomsPerChunk;
    }

    public void setClayPerChunk(int clayPerChunk)
    {
        this.clayPerChunk = clayPerChunk;
    }

    public void setDeadBushPerChunk(int deadBushPerChunk)
    {
        this.deadBushPerChunk = deadBushPerChunk;
    }

    public void setMushroomsPerChunk(int mushroomsPerChunk)
    {
        this.mushroomsPerChunk = mushroomsPerChunk;
    }

    public void setFlowersPerChunk(int flowersPerChunk)
    {
        this.flowersPerChunk = flowersPerChunk;
    }

    public void setReedsPerChunk(int reedsPerChunk)
    {
        this.reedsPerChunk = reedsPerChunk;
    }

    public void setWaterlilyPerChunk(int waterlilyPerChunk)
    {
        this.waterlilyPerChunk = waterlilyPerChunk;
    }

    public void setGrassPerChunk(int grassPerChunk)
    {
        this.grassPerChunk = grassPerChunk;
    }

}
