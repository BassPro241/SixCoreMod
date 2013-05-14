package com.basspro.scm.worldpandora.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.basspro.scm.worldpandora.gen.feature.PandoraFeature;
import com.basspro.scm.worldpandora.gen.layer.GenLayerPandora;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class WorldChunkManagerPandora extends WorldChunkManager
{
    private GenLayer myGenBiomes;
    private GenLayer myBiomeIndexLayer;
    private BiomeCache myBiomeCache;
//    private PandoraFeatureCache featureCache;
    private List myBiomesToSpawnIn;

    protected WorldChunkManagerPandora()
    {
        this.myBiomeCache = new BiomeCache(this);
        this.myBiomesToSpawnIn = new ArrayList();
        this.myBiomesToSpawnIn.add(BiomeGenBasePandora.pandora);
        this.myBiomesToSpawnIn.add(BiomeGenBasePandora.pandora2);

//         this.featureCache = new TFFeatureCache(this);
    }

    public WorldChunkManagerPandora(long par1, WorldType par3WorldType)
    {
        this();
        GenLayer[] agenlayer = GenLayerPandora.makeTheWorld(par1);
        this.myGenBiomes = agenlayer[0];
        this.myBiomeIndexLayer = agenlayer[1];
    }

    public WorldChunkManagerPandora(World par1World)
    {
        this(par1World.getSeed(), par1World.getWorldInfo().getTerrainType());
    }

    public List getBiomesToSpawnIn()
    {
        return this.myBiomesToSpawnIn;
    }

    public BiomeGenBase getBiomeGenAt(int par1, int par2)
    {
        BiomeGenBase biome = this.myBiomeCache.getBiomeGenAt(par1, par2);
        if (biome == null)
        {
            return BiomeGenBasePandora.pandora;
        }

        return biome;
    }

    public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3,
            int par4, int par5)
    {
        IntCache.resetIntCache();

        if ((par1ArrayOfFloat == null)
                || (par1ArrayOfFloat.length < par4 * par5))
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

        int[] ai = this.myBiomeIndexLayer.getInts(par2, par3, par4, par5);

        for (int i = 0; i < par4 * par5; i++)
        {
            if ((ai[i] >= 0) && (BiomeGenBase.biomeList[ai[i]] != null))
            {
                float f = BiomeGenBase.biomeList[ai[i]].getIntRainfall() / 65536.0F;

                if (f > 1.0F)
                {
                    f = 1.0F;
                }

                par1ArrayOfFloat[i] = f;
            }

        }

        return par1ArrayOfFloat;
    }

    public float getTemperatureAtHeight(float par1, int par2)
    {
        return par1;
    }

    public float[] getTemperatures(float[] par1ArrayOfFloat, int par2,
            int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if ((par1ArrayOfFloat == null)
                || (par1ArrayOfFloat.length < par4 * par5))
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

        int[] var6 = this.myBiomeIndexLayer.getInts(par2, par3, par4, par5);

        for (int var7 = 0; var7 < par4 * par5; var7++)
        {
            float floatTemp;
            if ((var6[var7] >= 0)
                    && (BiomeGenBase.biomeList[var6[var7]] != null))
            {
                floatTemp = BiomeGenBase.biomeList[var6[var7]]
                        .getIntTemperature() / 65536.0F;
            }
            else
            {
                floatTemp = 0.5F;
            }

            if (floatTemp > 1.0F)
            {
                floatTemp = 1.0F;
            }

            par1ArrayOfFloat[var7] = floatTemp;
        }

        return par1ArrayOfFloat;
    }

    public BiomeGenBase[] getBiomesForGeneration(
            BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3,
            int par4, int par5)
    {
        IntCache.resetIntCache();

        if ((par1ArrayOfBiomeGenBase == null)
                || (par1ArrayOfBiomeGenBase.length < par4 * par5))
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        int[] ai = this.myGenBiomes.getInts(par2, par3, par4, par5);

        for (int i = 0; i < par4 * par5; i++)
        {
            if (ai[i] >= 0)
            {
                par1ArrayOfBiomeGenBase[i] = BiomeGenBase.biomeList[ai[i]];
            }
            else
            {
                par1ArrayOfBiomeGenBase[i] = BiomeGenBasePandora.pandora;
            }
        }

        return par1ArrayOfBiomeGenBase;
    }

    public BiomeGenBase[] loadBlockGeneratorData(
            BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3,
            int par4, int par5)
    {
        return getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3, par4, par5,
                true);
    }

    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase,
            int x, int y, int width, int length, boolean cacheFlag)
    {
        IntCache.resetIntCache();

        if ((par1ArrayOfBiomeGenBase == null)
                || (par1ArrayOfBiomeGenBase.length < width * length))
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[width * length];
        }

        if ((cacheFlag) && (width == 16) && (length == 16) && ((x & 0xF) == 0)
                && ((y & 0xF) == 0))
        {
            BiomeGenBase[] abiomegenbase = this.myBiomeCache.getCachedBiomes(x,
                    y);
            System.arraycopy(abiomegenbase, 0, par1ArrayOfBiomeGenBase, 0,
                    width * length);
            return par1ArrayOfBiomeGenBase;
        }

        int[] ai = this.myBiomeIndexLayer.getInts(x, y, width, length);

        for (int i = 0; i < width * length; i++)
        {
            if (ai[i] >= 0)
            {
                par1ArrayOfBiomeGenBase[i] = BiomeGenBase.biomeList[ai[i]];
            }
            else
            {
                par1ArrayOfBiomeGenBase[i] = BiomeGenBasePandora.pandora;
            }
        }

        return par1ArrayOfBiomeGenBase;
    }

    public boolean areBiomesViable(int par1, int par2, int par3, List par4List)
    {
        int i = par1 - par3 >> 2;
        int j = par2 - par3 >> 2;
        int k = par1 + par3 >> 2;
        int l = par2 + par3 >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] ai = this.myGenBiomes.getInts(i, j, i1, j1);

        for (int k1 = 0; k1 < i1 * j1; k1++)
        {
            BiomeGenBase biomegenbase = BiomeGenBase.biomeList[ai[k1]];

            if (!par4List.contains(biomegenbase))
            {
                return false;
            }
        }

        return true;
    }

    public ChunkPosition findBiomePosition(int par1, int par2, int par3,
            List par4List, Random par5Random)
    {
        int i = par1 - par3 >> 2;
        int j = par2 - par3 >> 2;
        int k = par1 + par3 >> 2;
        int l = par2 + par3 >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] ai = this.myGenBiomes.getInts(i, j, i1, j1);
        ChunkPosition chunkposition = null;
        int k1 = 0;

        for (int l1 = 0; l1 < ai.length; l1++)
        {
            int i2 = i + l1 % i1 << 2;
            int j2 = j + l1 / i1 << 2;
            BiomeGenBase biomegenbase = BiomeGenBase.biomeList[ai[l1]];

            if ((par4List.contains(biomegenbase))
                    && ((chunkposition == null) || (par5Random.nextInt(k1 + 1) == 0)))
            {
                chunkposition = new ChunkPosition(i2, 0, j2);
                k1++;
            }
        }

        return chunkposition;
    }

    public void cleanupCache()
    {
        this.myBiomeCache.cleanupCache();
    }

    public int getFeatureID(int mapX, int mapZ, World world)
    {
        return getFeatureIDNoCache(mapX, mapZ, world);
    }

    public int getFeatureIDNoCache(int mapX, int mapZ, World world)
    {
        return getFeatureNoCache(mapX, mapZ, world).featureID;
    }

    public PandoraFeature getFeatureAt(int mapX, int mapZ, World world)
    {
        return getFeatureNoCache(mapX, mapZ, world);
    }

    public PandoraFeature getFeatureNoCache(int mapX, int mapZ, World world)
    {
        return PandoraFeature.generateFeatureFor(mapX >> 4, mapZ >> 4, world);
    }

    public boolean isInFeatureChunk(int mapX, int mapZ)
    {
        int chunkX = mapX >> 4;
        int chunkZ = mapZ >> 4;

        return (chunkX % 16 == 0) && (chunkZ % 16 == 0);
    }
}
