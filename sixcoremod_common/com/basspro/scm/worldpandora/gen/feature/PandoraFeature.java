package com.basspro.scm.worldpandora.gen.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

import com.basspro.scm.worldpandora.WorldSCM;
import com.basspro.scm.worldpandora.biome.WorldChunkManagerPandora;

public class PandoraFeature
{
    public static final PandoraFeature[] featureList = new PandoraFeature[256];

    public static final PandoraFeature hill1 = new PandoraFeature(1, 1,
            "Small Hollow Hill").enableDecorations();

    public static final PandoraFeature nothing = new PandoraFeature(0, 0,
            "No Feature").enableDecorations().disableStructure();

    ArrayList emptyList = new ArrayList();
    public int featureID;
    public int size;
    public String name;
    public boolean chunkDecorationsEnabled;
    public boolean structureEnabled;
    protected List spawnableMonsterLists;
    protected List ambientCreatureList;
    protected List waterCreatureList;

    public PandoraFeature(int parID, int parSize, String parName)
    {
        this.featureID = parID;
        featureList[parID] = this;
        this.size = parSize;
        this.name = parName;
        this.chunkDecorationsEnabled = false;
        this.structureEnabled = true;
        this.spawnableMonsterLists = new ArrayList();
        this.ambientCreatureList = new ArrayList();
        this.waterCreatureList = new ArrayList();

        this.ambientCreatureList.add(new SpawnListEntry(EntityBat.class, 10, 8,
                8));
    }

    public PandoraFeature enableDecorations()
    {
        this.chunkDecorationsEnabled = true;
        return this;
    }

    public PandoraFeature disableStructure()
    {
        this.structureEnabled = false;
        return this;
    }

    public PandoraFeature addMonster(Class monsterClass, int weight,
            int minGroup, int maxGroup)
    {
        addMonster(0, monsterClass, weight, minGroup, maxGroup);
        return this;
    }

    public PandoraFeature addMonster(int listIndex, Class monsterClass,
            int weight, int minGroup, int maxGroup)
    {
        List monsterList;
        if (this.spawnableMonsterLists.size() > listIndex)
        {
            monsterList = (List) this.spawnableMonsterLists.get(listIndex);
        }
        else
        {
            monsterList = new ArrayList();
            this.spawnableMonsterLists.add(listIndex, monsterList);
        }

        monsterList.add(new SpawnListEntry(monsterClass, weight, minGroup,
                maxGroup));
        return this;
    }

    public PandoraFeature addWaterCreature(Class monsterClass, int weight,
            int minGroup, int maxGroup)
    {
        this.waterCreatureList.add(new SpawnListEntry(monsterClass, weight,
                minGroup, maxGroup));
        return this;
    }

    public static PandoraFeature getFeatureDirectlyAt(int chunkX, int chunkZ,
            World world)
    {
        if ((world != null)
                && ((world.getWorldChunkManager() instanceof WorldChunkManagerPandora)))
        {
            WorldChunkManagerPandora pandoraManager = (WorldChunkManagerPandora) world
                    .getWorldChunkManager();

            if (pandoraManager.isInFeatureChunk(chunkX << 4, chunkZ << 4))
            {
                return pandoraManager.getFeatureAt(chunkX << 4, chunkZ << 4,
                        world);
            }

            return nothing;
        }

        return nothing;
    }

    public static PandoraFeature generateFeatureFor(int chunkX, int chunkZ,
            World world)
    {
        BiomeGenBase biomeAt = world.getBiomeGenForCoords((chunkX << 4) + 8,
                (chunkZ << 4) + 8);

        Random hillRNG = new Random(world.getSeed() + chunkX * 25117 + chunkZ
                * 151121);
        int randnum = hillRNG.nextInt(16);

        switch (randnum)
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            default:
                return hill1;

        }
    }

    public static PandoraFeature generateFeaturePreset5x5(int chunkX,
            int chunkZ, World world)
    {
        int cf = 16;

        if ((chunkX % cf != 0) || (chunkZ % cf != 0))
        {
            return nothing;
        }

        int mx = chunkX / cf + 4;
        int mz = chunkZ / cf + 4;

        int[][] map = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 19, 18, 8, 15, 14, 0 }, { 0, 0, 18, 18, 2, 3, 15, 0 },
                { 0, 0, 4, 4, 5, 16, 9, 0 }, { 0, 0, 13, 6, 1, 2, 17, 0 },
                { 0, 0, 12, 13, 3, 17, 7, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };

        if ((mx >= 0) && (mx < 8) && (mz >= 0) && (mz < 8))
        {
            return featureList[map[mz][mx]];
        }

        return nothing;
    }

    public static PandoraFeature generateFeaturePreset6x6(int chunkX,
            int chunkZ, World world)
    {
        int cf = 16;

        if ((chunkX % cf != 0) || (chunkZ % cf != 0))
        {
            return nothing;
        }

        int mx = chunkX / cf + 3;
        int mz = chunkZ / cf + 3;

        int[][] map = { { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 19, 19, 18, 15, 0, 0, 0 }, { 0, 18, 18, 18, 0, 14, 0, 0 },
                { 0, 0, 4, 1, 2, 3, 15, 0 }, { 0, 4, 1, 5, 16, 9, 17, 0 },
                { 0, 0, 13, 2, 3, 17, 17, 0 }, { 0, 0, 12, 13, 6, 17, 7, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 } };

        if ((mx >= 0) && (mx < 8) && (mz >= 0) && (mz < 8))
        {
            return featureList[map[mz][mx]];
        }

        return nothing;
    }

    public static PandoraFeature getNearestFeature(int cx, int cz, World world)
    {
        for (int rad = 1; rad <= 3; rad++)
        {
            for (int x = -rad; x <= rad; x++)
            {
                for (int z = -rad; z <= rad; z++)
                {
                    PandoraFeature directlyAt = getFeatureDirectlyAt(x + cx, z
                            + cz, world);
                    if (directlyAt.size == rad)
                    {
                        return directlyAt;
                    }
                }
            }
        }

        return nothing;
    }

    public static PandoraFeature getNearestFeatureIncludeMore(int chunkX,
            int chunkZ, World world)
    {
        for (int rad = 1; rad <= 3; rad++)
        {
            for (int x = -rad; x <= rad; x++)
            {
                for (int z = -rad; z <= rad; z++)
                {
                    PandoraFeature directlyAt = getFeatureDirectlyAt(
                            x + chunkX, z + chunkZ, world);
                    if (directlyAt != nothing)
                    {
                        return directlyAt;
                    }
                }
            }
        }

        return nothing;
    }

    public static int[] getNearestCenter(int cx, int cz, World world)
    {
        for (int rad = 1; rad <= 3; rad++)
        {
            for (int x = -rad; x <= rad; x++)
            {
                for (int z = -rad; z <= rad; z++)
                {
                    if (getFeatureDirectlyAt(x + cx, z + cz, world).size == rad)
                    {
                        int[] center = { x * 16 + 8, z * 16 + 8 };
                        return center;
                    }
                }
            }
        }
        int[] no = { 0, 0 };
        return no;
    }

    public static ChunkCoordinates getNearestCenterXYZ(int cx, int cz,
            World world)
    {
        int fx = (int) (Math.round(cx / 256.0D) * 256L + 8L);
        int fz = (int) (Math.round(cz / 256.0D) * 256L + 8L);

        return new ChunkCoordinates(fx, WorldSCM.SEALEVEL, fz);
    }

    public List getSpawnableList(EnumCreatureType par1EnumCreatureType)
    {
        if (par1EnumCreatureType == EnumCreatureType.monster)
        {
            return getSpawnableList(EnumCreatureType.monster, 0);
        }
        if (par1EnumCreatureType == EnumCreatureType.ambient)
        {
            return this.ambientCreatureList;
        }
        if (par1EnumCreatureType == EnumCreatureType.waterCreature)
        {
            return this.waterCreatureList;
        }

        return this.emptyList;
    }

    public List getSpawnableList(EnumCreatureType par1EnumCreatureType,
            int index)
    {
        if (par1EnumCreatureType == EnumCreatureType.monster)
        {
            if ((index >= 0) && (index < this.spawnableMonsterLists.size()))
            {
                return (List) this.spawnableMonsterLists.get(index);
            }

            return this.emptyList;
        }

        return getSpawnableList(par1EnumCreatureType);
    }

    static
    {
        hill1.addMonster(EntitySpider.class, 10, 4, 4);
        hill1.addMonster(EntityZombie.class, 10, 4, 4);
    }
}
