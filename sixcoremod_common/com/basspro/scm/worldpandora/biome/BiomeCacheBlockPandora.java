package com.basspro.scm.worldpandora.biome;

import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeCacheBlockPandora
{
    /** An array of chunk temperatures saved by this cache. */
    public float[] temperatureValues;

    /** An array of chunk rainfall values saved by this cache. */
    public float[] rainfallValues;

    /** The array of biome types stored in this BiomeCacheBlock. */
    public BiomeGenBasePandora[] biomes;

    /** The x coordinate of the BiomeCacheBlock. */
    public int xPosition;

    /** The z coordinate of the BiomeCacheBlock. */
    public int zPosition;

    /** The last time this BiomeCacheBlock was accessed, in milliseconds. */
    public long lastAccessTime;

    /** The BiomeCache object that contains this BiomeCacheBlock */
    final BiomeCache theBiomeCache;

    public BiomeCacheBlockPandora(BiomeCache par1BiomeCache, int par2, int par3)
    {
        this.theBiomeCache = par1BiomeCache;
        this.temperatureValues = new float[256];
        this.rainfallValues = new float[256];
        this.biomes = new BiomeGenBasePandora[256];
        this.xPosition = par2;
        this.zPosition = par3;
        BiomeCachePandora.getChunkManager(par1BiomeCache).getTemperatures(this.temperatureValues, par2 << 4, par3 << 4, 16, 16);
        BiomeCachePandora.getChunkManager(par1BiomeCache).getRainfall(this.rainfallValues, par2 << 4, par3 << 4, 16, 16);
        BiomeCachePandora.getChunkManager(par1BiomeCache).getBiomeGenAt(this.biomes, par2 << 4, par3 << 4, 16, 16, false);
    }

    /**
     * Returns the BiomeGenBase related to the x, z position from the cache block.
     */
    public BiomeGenBasepandora getBiomeGenAt(int par1, int par2)
    {
        return this.biomes[par1 & 15 | (par2 & 15) << 4];
    }
}
