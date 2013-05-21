package com.basspro.scm.worldpandora.gen;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;

import com.basspro.scm.worldpandora.WorldSCM;
import com.basspro.scm.worldpandora.biome.BiomeGenBasePandora;
import com.basspro.scm.worldpandora.gen.feature.PandoraFeature;

public abstract class ChunkProviderPandora implements IChunkProvider
{
    private Random rand;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    private NoiseGeneratorOctaves noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    private World worldObj;
    private final boolean mapFeaturesEnabled;
    private double[] noiseArray;
    private double[] stoneNoise;
    private PandoraGenCaves caveGenerator;
    private PandoraGenRavine ravineGenerator;
    private BiomeGenBase[] biomesForGeneration;
    double[] noise3;
    double[] noise1;
    double[] noise2;
    double[] noise5;
    double[] noise6;
    float[] parabolicField;
    int[][] field_73219_j = new int[32][32];
    private MapGenPandoraMajorFeature majorFeatureGenerator;

    public ChunkProviderPandora(World par1World, long par2, boolean par4)
    {
        this.stoneNoise = new double[256];
        this.caveGenerator = new PandoraGenCaves();

        // this.majorFeatureGenerator = new MapGenPandoraMajorFeature();

        this.ravineGenerator = new PandoraGenRavine();
        this.field_73219_j = new int[32][32];
        this.worldObj = par1World;
        this.mapFeaturesEnabled = par4;
        this.rand = new Random(par2);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
    }

    public void generateTerrain(int par1, int par2, short[] par3ArrayofShort)
    {
        byte byte0 = 4;
        byte byte1 = 8;
        byte byte2 = (byte) WorldSCM.SEALEVEL;
        int i = byte0 + 1;
        byte byte3 = 9;
        int j = byte0 + 1;
        this.biomesForGeneration = this.worldObj.getWorldChunkManager()
                .getBiomesForGeneration(this.biomesForGeneration, par1 * 4 - 2,
                        par2 * 4 - 2, i + 5, j + 5);
        this.noiseArray = makeLandPerBiome(this.noiseArray, par1 * byte0, 0,
                par2 * byte0, i, byte3, j);

        for (int k = 0; k < byte0; k++)
        {
            for (int l = 0; l < byte0; l++)
            {
                for (int i1 = 0; i1 < byte1; i1++)
                {
                    double d = 0.125D;
                    double d1 = this.noiseArray[(((k + 0) * j + (l + 0))
                            * byte3 + (i1 + 0))];
                    double d2 = this.noiseArray[(((k + 0) * j + (l + 1))
                            * byte3 + (i1 + 0))];
                    double d3 = this.noiseArray[(((k + 1) * j + (l + 0))
                            * byte3 + (i1 + 0))];
                    double d4 = this.noiseArray[(((k + 1) * j + (l + 1))
                            * byte3 + (i1 + 0))];
                    double d5 = (this.noiseArray[(((k + 0) * j + (l + 0))
                            * byte3 + (i1 + 1))] - d1)
                            * d;
                    double d6 = (this.noiseArray[(((k + 0) * j + (l + 1))
                            * byte3 + (i1 + 1))] - d2)
                            * d;
                    double d7 = (this.noiseArray[(((k + 1) * j + (l + 0))
                            * byte3 + (i1 + 1))] - d3)
                            * d;
                    double d8 = (this.noiseArray[(((k + 1) * j + (l + 1))
                            * byte3 + (i1 + 1))] - d4)
                            * d;

                    for (int j1 = 0; j1 < 8; j1++)
                    {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int k1 = 0; k1 < 4; k1++)
                        {
                            int l1 = k1 + k * 4 << 11 | 0 + l * 4 << 7 | i1 * 8
                                    + j1;
                            char c = 'a';
                            l1 -= c;
                            double d14 = 0.25D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            d15 -= d16;

                            for (int i2 = 0; i2 < 4; i2++)
                            {

                                if ((d15 += d16) > 0.0D)
                                {
                                    int tmp516_515 = (l1 + c);
                                    l1 = tmp516_515;
                                    par3ArrayofShort[tmp516_515] = ((short) Block.stone.blockID);
                                }
                                else if (i1 * 8 + j1 < byte2)
                                {
                                    int tmp549_548 = (l1 + c);
                                    l1 = tmp549_548;
                                    par3ArrayofShort[tmp549_548] = ((short) Block.waterStill.blockID);
                                }
                                else
                                {
                                    int tmp569_568 = (l1 + c);
                                    l1 = tmp569_568;
                                    par3ArrayofShort[tmp569_568] = 0;
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void replaceBlocksForBiome(int par1, int par2,
            short[] blockArray4096, BiomeGenBase[] par4ArrayOfBiomeGenBase)
    {
        byte sealevel = (byte) WorldSCM.SEALEVEL;
        double d = 0.03125D;
        this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise,
                par1 * 16, par2 * 16, 0, 16, 16, 1, d * 2.0D, d * 2.0D,
                d * 2.0D);

        for (int i = 0; i < 16; i++)
        {
            for (int j = 0; j < 16; j++)
            {
                BiomeGenBase biomegenbase = par4ArrayOfBiomeGenBase[(j + i * 16)];
                if (biomegenbase == null)
                {
                    biomegenbase = BiomeGenBasePandora.pandora;
                }
                float f = biomegenbase.getFloatTemperature();
                int k = (int) (this.stoneNoise[(i + j * 16)] / 3.0D + 3.0D + this.rand
                        .nextDouble() * 0.25D);
                int l = -1;
                short top = (short) biomegenbase.topBlock;
                short filler = (short) biomegenbase.fillerBlock;

                for (int i1 = 127; i1 >= 0; i1--)
                {
                    int j1 = (j * 16 + i) * 128 + i1;

                    if (i1 <= 0 + this.rand.nextInt(5))
                    {
                        blockArray4096[j1] = ((short) Block.bedrock.blockID);
                    }
                    else
                    {
                        short currentBlock = blockArray4096[j1];

                        if (currentBlock == Block.stone.blockID)
                        {
                            if (l == -1)
                            {
                                if (k <= 0)
                                {
                                    top = 0;
                                    filler = (short) Block.stone.blockID;
                                }
                                else if ((i1 >= sealevel - 4)
                                        && (i1 <= sealevel + 1))
                                {
                                    top = (short) biomegenbase.topBlock;
                                    filler = (short) biomegenbase.fillerBlock;
                                }

                                if ((i1 < sealevel) && (top == 0))
                                {
                                    if (f < 0.15F)
                                    {
                                        top = (short) Block.ice.blockID;
                                    }
                                    else
                                    {
                                        top = (short) Block.waterStill.blockID;
                                    }
                                }

                                l = k;

                                if (i1 >= sealevel - 1)
                                {
                                    blockArray4096[j1] = top;
                                }
                                else
                                {
                                    blockArray4096[j1] = filler;
                                }

                            }
                            else if (l > 0)
                            {
                                l--;
                                blockArray4096[j1] = filler;

                                if ((l == 0) && (filler == Block.sand.blockID))
                                {
                                    l = this.rand.nextInt(4);
                                    filler = (short) Block.sandStone.blockID;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * loads or generates the chunk at the chunk location specified
     */
    public Chunk loadChunk(int par1, int par2)
    {
        return this.provideChunk(par1, par2);
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it
     * will generates all the blocks for the specified chunk from the map seed
     * and chunk seed
     */
    public Chunk provideChunk(int par1, int par2)
    {
        this.rand.setSeed((long) par1 * 341873128712L + (long) par2
                * 132897987541L);
        short[] blockStorage = new short[32768];
        byte[] metaStorage = new byte[32768];
        this.generateTerrain(par1, par2, blockStorage);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager()
                .loadBlockGeneratorData(this.biomesForGeneration, par1 * 16,
                        par2 * 16, 16, 16);

        byte[] fake = new byte[0];

        this.replaceBlocksForBiome(par1, par2, blockStorage,
                this.biomesForGeneration);
        this.caveGenerator.generate(this, this.worldObj, par1, par2,
                metaStorage);
        this.ravineGenerator.generate(this, this.worldObj, par1, par2,
                metaStorage);

        Chunk chunk = new Chunk(this.worldObj, metaStorage, par1, par2);
        byte[] abyte1 = chunk.getBiomeArray();

        for (int k = 0; k < abyte1.length; ++k)
        {
            abyte1[k] = (byte) this.biomesForGeneration[k].biomeID;
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    protected Chunk makeAChunk(World world, short[] ids, byte[] metadata,
            int chunkX, int chunkZ)
    {
        Chunk chunk = new Chunk(world, chunkX, chunkZ);

        ExtendedBlockStorage[] storageArrays = chunk.getBlockStorageArray();

        int height = ids.length / 256;

        for (int x = 0; x < 16; x++)
        {
            for (int z = 0; z < 16; z++)
            {
                for (int y = 0; y < height; y++)
                {
                    int index = x << 11 | z << 7 | y;
                    int id = ids[index] & 0xFFF;
                    int meta = metadata[index];

                    if (id != 0)
                    {
                        int storageIndex = y >> 4;

                        if (storageArrays[storageIndex] == null)
                        {
                            storageArrays[storageIndex] = new ExtendedBlockStorage(
                                    storageIndex << 4, true);
                        }

                        storageArrays[storageIndex].setExtBlockID(x, y & 0xF,
                                z, id);
                        storageArrays[storageIndex].setExtBlockMetadata(x,
                                y & 0xF, z, meta);
                    }
                }
            }
        }
        return chunk;
    }

    private double[] makeLandPerBiome(double[] ad, int xx, int zero, int zz,
            int l, int i1, int j1)
    {
        if (ad == null)
        {
            ad = new double[l * i1 * j1];
        }
        if (this.parabolicField == null)
        {
            this.parabolicField = new float[25];
            for (int k1 = -2; k1 <= 2; k1++)
            {
                for (int l1 = -2; l1 <= 2; l1++)
                {
                    float f = 10.0F / MathHelper.sqrt_float(k1 * k1 + l1 * l1
                            + 0.2F);
                    this.parabolicField[(k1 + 2 + (l1 + 2) * 5)] = f;
                }
            }

        }

        double d = 684.41200000000003D;
        double d1 = 684.41200000000003D;
        this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, xx, zz,
                l, j1, 1.121D, 1.121D, 0.5D);
        this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, xx, zz,
                l, j1, 200.0D, 200.0D, 0.5D);
        this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, xx,
                zero, zz, l, i1, j1, d / 80.0D, d1 / 160.0D, d / 80.0D);
        this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, xx,
                zero, zz, l, i1, j1, d, d1, d);
        this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, xx,
                zero, zz, l, i1, j1, d, d1, d);
        xx = zz = 0;
        int i2 = 0;
        int j2 = 0;
        for (int k2 = 0; k2 < l; k2++)
        {
            for (int l2 = 0; l2 < j1; l2++)
            {
                float f1 = 0.0F;
                float f2 = 0.0F;
                float f3 = 0.0F;
                byte byte0 = 2;
                BiomeGenBase biomegenbase = this.biomesForGeneration[(k2 + 2 + (l2 + 2)
                        * (l + 5))];
                for (int i3 = -byte0; i3 <= byte0; i3++)
                {
                    for (int j3 = -byte0; j3 <= byte0; j3++)
                    {
                        BiomeGenBase biomegenbase1 = this.biomesForGeneration[(k2
                                + i3 + 2 + (l2 + j3 + 2) * (l + 5))];
                        float f4 = this.parabolicField[(i3 + 2 + (j3 + 2) * 5)]
                                / (biomegenbase1.minHeight + 2.0F);
                        if (biomegenbase1.minHeight > biomegenbase.minHeight)
                        {
                            f4 /= 2.0F;
                        }
                        f1 += biomegenbase1.maxHeight * f4;
                        f2 += biomegenbase1.minHeight * f4;
                        f3 += f4;
                    }

                }

                f1 /= f3;
                f2 /= f3;
                f1 = f1 * 0.9F + 0.1F;
                f2 = (f2 * 4.0F - 1.0F) / 8.0F;
                double d2 = this.noise6[j2] / 8000.0D;
                if (d2 < 0.0D)
                {
                    d2 = -d2 * 0.3D;
                }
                d2 = d2 * 3.0D - 2.0D;
                if (d2 < 0.0D)
                {
                    d2 /= 2.0D;
                    if (d2 < -1.0D)
                    {
                        d2 = -1.0D;
                    }
                    d2 /= 1.4D;
                    d2 /= 2.0D;
                }
                else
                {
                    if (d2 > 1.0D)
                    {
                        d2 = 1.0D;
                    }
                    d2 /= 8.0D;
                }
                j2++;
                for (int k3 = 0; k3 < i1; k3++)
                {
                    double d3 = f2;
                    double d4 = f1;
                    d3 += d2 * 0.2D;
                    d3 = d3 * i1 / 16.0D;
                    double d5 = i1 / 2.0D + d3 * 4.0D;
                    double d6 = 0.0D;
                    double d7 = (k3 - d5) * 12.0D * 128.0D
                            / WorldSCM.WORLDHEIGHT / d4;
                    if (d7 < 0.0D)
                    {
                        d7 *= 4.0D;
                    }
                    double d8 = this.noise1[i2] / 512.0D;
                    double d9 = this.noise2[i2] / 512.0D;
                    double d10 = (this.noise3[i2] / 10.0D + 1.0D) / 2.0D;
                    if (d10 < 0.0D)
                    {
                        d6 = d8;
                    }
                    else if (d10 > 1.0D)
                    {
                        d6 = d9;
                    }
                    else
                    {
                        d6 = d8 + (d9 - d8) * d10;
                    }
                    d6 -= d7;
                    if (k3 > i1 - 4)
                    {
                        double d11 = (k3 - (i1 - 4)) / 3.0F;
                        d6 = d6 * (1.0D - d11) + -10.0D * d11;
                    }
                    ad[i2] = d6;
                    i2++;
                }

            }

        }

        return ad;
    }

    private void addFeatureMarker(int cx, int cz, short[] blockStorage,
            byte[] metaStorage)
    {
        PandoraFeature feature = PandoraFeature.getFeatureDirectlyAt(cx, cz,
                this.worldObj);
        if (feature != PandoraFeature.nothing)
        {
            byte featureLowNibble = (byte) (feature.featureID & 0xF);
            byte featureHighNibble = (byte) ((feature.featureID & 0xF0) >> 4);

            blockStorage[0] = ((short) Block.bedrock.blockID);
            blockStorage[1] = ((short) Block.bedrock.blockID);
            blockStorage[2] = ((short) Block.bedrock.blockID);

            metaStorage[0] = featureLowNibble;
            metaStorage[1] = featureHighNibble;
            metaStorage[2] = 1;
        }
    }

    public boolean chunkExists(int i, int j)
    {
        return true;
    }

    public void populate(IChunkProvider ichunkprovider, int chunkX, int chunkZ)
    {
        net.minecraft.block.BlockSand.fallInstantly = true;
        int mapX = chunkX * 16;
        int mapY = chunkZ * 16;
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(
                mapX + 16, mapY + 16);

        if ((biomegenbase == BiomeGenBasePandora.majorFeature)
                || (biomegenbase == BiomeGenBasePandora.minorFeature))
        {
            biomegenbase = this.worldObj.getBiomeGenForCoords(mapX + 17,
                    mapY + 17);
        }
        this.rand.setSeed(this.worldObj.getSeed());
        long l1 = this.rand.nextLong() / 2L * 2L + 1L;
        long l2 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(chunkX * l1 + chunkZ * l2 ^ this.worldObj.getSeed());
        boolean disableFeatures = false;

        disableFeatures |= this.majorFeatureGenerator
                .generateStructuresInChunk(this.worldObj, this.rand, chunkX,
                        chunkZ);

        disableFeatures |= !PandoraFeature.getNearestFeature(chunkX, chunkZ,
                this.worldObj).chunkDecorationsEnabled;

        if ((!disableFeatures) && (this.rand.nextInt(4) == 0))
        {
            int i1 = mapX + this.rand.nextInt(16) + 8;
            int i2 = this.rand.nextInt(WorldSCM.WORLDHEIGHT);
            int i3 = mapY + this.rand.nextInt(16) + 8;
            new WorldGenLakes(Block.waterStill.blockID).generate(this.worldObj,
                    this.rand, i1, i2, i3);
        }
        if ((!disableFeatures) && (this.rand.nextInt(32) == 0))
        {
            int j1 = mapX + this.rand.nextInt(16) + 8;
            int j2 = this.rand.nextInt(this.rand
                    .nextInt(WorldSCM.WORLDHEIGHT - 8) + 8);
            int j3 = mapY + this.rand.nextInt(16) + 8;
            if ((j2 < WorldSCM.SEALEVEL) || (this.rand.nextInt(10) == 0))
            {
                new WorldGenLakes(Block.lavaStill.blockID).generate(
                        this.worldObj, this.rand, j1, j2, j3);
            }
        }
        for (int k1 = 0; k1 < 8; k1++)
        {
            int k2 = mapX + this.rand.nextInt(16) + 8;
            int k3 = this.rand.nextInt(WorldSCM.WORLDHEIGHT);
            int l3 = mapY + this.rand.nextInt(16) + 8;
            if (new WorldGenDungeons().generate(this.worldObj, this.rand, k2,
                    k3, l3))
                ;
        }
        biomegenbase.decorate(this.worldObj, this.rand, mapX, mapY);
        SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase,
                mapX + 8, mapY + 8, 16, 16, this.rand);
        mapX += 8;
        mapY += 8;
        for (int i2 = 0; i2 < 16; i2++)
        {
            for (int j3 = 0; j3 < 16; j3++)
            {
                int j4 = this.worldObj.getPrecipitationHeight(mapX + i2, mapY
                        + j3);
                if (this.worldObj
                        .isBlockFreezable(i2 + mapX, j4 - 1, j3 + mapY))
                {
                    this.worldObj.setBlock(i2 + mapX, j4 - 1, j3 + mapY,
                            Block.ice.blockID, 0, 2);
                }
                if (this.worldObj.canSnowAt(i2 + mapX, j4, j3 + mapY))
                {
                    this.worldObj.setBlock(i2 + mapX, j4, j3 + mapY,
                            Block.snow.blockID, 0, 2);
                }
            }
        }

        net.minecraft.block.BlockSand.fallInstantly = false;
    }

    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate)
    {
        return true;
    }

    public boolean canSave()
    {
        return true;
    }

    public String makeString()
    {
        return "PandoraLevelSource";
    }

    public List getPossibleCreatures(EnumCreatureType creatureType, int mapX,
            int mapY, int mapZ)
    {
        PandoraFeature nearestFeature = PandoraFeature.getNearestFeatureIncludeMore(
                mapX >> 4, mapZ >> 4, this.worldObj);

        if (nearestFeature != PandoraFeature.nothing)
        {
            int spawnListIndex = this.majorFeatureGenerator
                    .getSpawnListIndexAt(mapX, mapY, mapZ);

            if (spawnListIndex >= 0)
            {
                return nearestFeature.getSpawnableList(creatureType,
                        spawnListIndex);
            }

        }

        if ((mapY < WorldSCM.SEALEVEL)
                && (creatureType == EnumCreatureType.monster))
        {
            return PandoraFeature.underground.getSpawnableList(creatureType);
        }

        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(mapX,
                mapZ);

        if (biomegenbase == null)
        {
            return null;
        }

        return biomegenbase.getSpawnableList(creatureType);
    }

    public ChunkPosition findClosestStructure(World par1World, String par2Str,
            int par3, int par4, int par5)
    {
        return null;
    }

    public int getLoadedChunkCount()
    {
        return 0;
    }

    public void recreateStructures(int var1, int var2)
    {
        this.majorFeatureGenerator.generate(this, this.worldObj, var1, var2,
                (byte[]) null);
    }

    public boolean unloadQueuedChunks()
    {
        return false;
    }
}
