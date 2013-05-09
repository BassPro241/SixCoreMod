package com.basspro.scm.worldpandora.gen.feature;

import java.util.ArrayList;
import java.util.List;

import twilightforest.TFFeature;

import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.biome.SpawnListEntry;

public class PandoraFeature
{
    public static final PandoraFeature[] featureList = new PandoraFeature[256];

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
}
