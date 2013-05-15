package com.basspro.scm.worldpandora.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayerPandora extends GenLayer
{
    public GenLayerPandora(long par1)
    {
        super(par1);
    }

    public static GenLayer[] makeTheWorld(long par1)
    {
        byte zoomFactor = 4;

        GenLayer biomes = new GenLayerPandoraBiomes(1L);

        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerZoom(1001L, biomes);

        biomes = new GenLayerPandoraBiomeBorders(500L, biomes);

/*        GenLayer riverLayer = new GenLayerPandoraStream(1L, biomes);
        riverLayer = new GenLayerSmooth(7000L, riverLayer);
        biomes = new GenLayerRiverMix(100L, biomes, riverLayer);*/

        biomes = new GenLayerZoom(1002L, biomes);
        biomes = new GenLayerZoom(1003L, biomes);
        biomes = new GenLayerZoom(1004L, biomes);
        biomes = new GenLayerZoom(1005L, biomes);

        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);

        biomes.initWorldGenSeed(par1);
        genlayervoronoizoom.initWorldGenSeed(par1);

        return new GenLayer[] { biomes, genlayervoronoizoom };
    }

    public static GenLayer[] makeTheWorldPreFeatureRemoval(long l)
    {
        byte zoomFactor = 4;

        GenLayer biomes = new GenLayerPandoraBiomes(1L);
        GenLayer features = new GenLayerPandoraMajorFeatures(1L);

        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerZoom(1001L, biomes);

        biomes = new GenLayerPandoraBiomeBorders(500L, biomes);

        biomes = new GenLayerZoom(1002L, biomes);
        biomes = new GenLayerZoom(1003L, biomes);

        features = GenLayerPandoraFeatureZoom.multipleZoom(1000L, features, 4);

        features = new GenLayerPandoraMinorFeatures(700, biomes, features);
        features = new GenLayerPandoraClearMajorFeatures(700L, features);
        features = new GenLayerPandoraClearMinorFeatures(701L, features);

        biomes = new GenLayerZoom(1004L, biomes);
        biomes = new GenLayerZoom(1005L, biomes);

        /*
         * GenLayer riverLayer = new GenLayerPandoraStream(1L, biomes);
         * riverLayer = new GenLayerSmooth(7000L, riverLayer); biomes = new
         * GenLayerRiverMix(100L, biomes, riverLayer);
         */

        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);

        features = GenLayerPandoraFeatureZoom.multipleZoom(1004L, features, 4);

        genlayervoronoizoom = new GenLayerPandoraReinsertFeatures(100L,
                genlayervoronoizoom, features);

        biomes.initWorldGenSeed(l);
        genlayervoronoizoom.initWorldGenSeed(l);
        features.initWorldGenSeed(l);

        return new GenLayer[] { biomes, genlayervoronoizoom, features };
    }

    public static GenLayer[] makeTheWorldPreset(long l)
    {
        byte zoomFactor = 4;

        GenLayer biomes = new GenLayerPandoraBiomes(1L);

        GenLayer features = new GenLayerPandoraMajorFeatures(1L);

        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerZoom(1001L, biomes);

        features = GenLayerPandoraFeatureZoom.multipleZoom(1000L, features, 2);
        biomes = new GenLayerPandoraStabilizeBiomes(900, biomes, features);
        biomes = new GenLayerPandoraBiomeBorders(500L, biomes);

        biomes = new GenLayerZoom(1002L, biomes);
        biomes = new GenLayerZoom(1003L, biomes);

        features = GenLayerPandoraFeatureZoom.multipleZoom(1002L, features, 2);

        features = new GenLayerPandoraMinorFeatures(700, biomes, features);
        features = new GenLayerPandoraClearMajorFeatures(700L, features);
        features = new GenLayerPandoraClearMinorFeatures(701L, features);

        biomes = new GenLayerZoom(1004L, biomes);
        biomes = new GenLayerZoom(1005L, biomes);

/*        GenLayer riverLayer = new GenLayerPandoraStream(1L, biomes);
        riverLayer = new GenLayerSmooth(7000L, riverLayer);
        biomes = new GenLayerRiverMix(100L, biomes, riverLayer);*/

        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);

        features = GenLayerPandoraFeatureZoom.multipleZoom(1004L, features, 4);

        genlayervoronoizoom = new GenLayerPandoraReinsertFeatures(100L,
                genlayervoronoizoom, features);

        biomes.initWorldGenSeed(l);
        genlayervoronoizoom.initWorldGenSeed(l);
        features.initWorldGenSeed(l);

        return new GenLayer[] { biomes, genlayervoronoizoom, features };
    }
}
