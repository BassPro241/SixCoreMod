package com.basspro.scm.worldpandora.gen.structure;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

import com.basspro.scm.worldpandora.WorldSCM;
import com.basspro.scm.worldpandora.biome.WorldChunkManagerPandora;
import com.basspro.scm.worldpandora.gen.feature.PandoraFeature;

public class StructurePandoraMajorFeatureStart extends StructureStart
{
    public PandoraFeature feature;

    public StructurePandoraMajorFeatureStart(World world, Random rand,
            int chunkX, int chunkZ)
    {
        StructureStrongholdPieces.prepareStructurePieces();

        int x = (chunkX << 4) + 8;
        int z = (chunkZ << 4) + 8;
        int y = WorldSCM.SEALEVEL + 1;

        this.feature = PandoraFeature.getFeatureDirectlyAt(chunkX, chunkZ,
                world);

        StructureComponent firstComponent = makeFirstComponent(world, rand,
                this.feature, x, y, z);
        if (firstComponent != null)
        {
            this.components.add(firstComponent);
            firstComponent
                    .buildComponent(firstComponent, this.components, rand);
        }

        updateBoundingBox();
        int offY;
        if ((firstComponent instanceof ComponentStrongholdStairs2))
        {
            ArrayList var6 = ((ComponentStrongholdStairs2) firstComponent).field_75026_c;

            while (!var6.isEmpty())
            {
                int var7 = rand.nextInt(var6.size());
                StructureComponent var8 = (StructureComponent) var6
                        .remove(var7);
                var8.buildComponent(firstComponent, this.components, rand);
            }

            updateBoundingBox();

            offY = -33;

            this.boundingBox.offset(0, offY, 0);

            for (StructureComponent com : getComponents())
            {
                com.getBoundingBox().offset(0, offY, 0);
            }

        }
    }

    public StructureComponent makeFirstComponent(World world, Random rand,
            PandoraFeature feature, int x, int y, int z)
    {
        if (feature == PandoraFeature.hill1)
        {
            return new ComponentPandoraHollowHill(world, rand, 0, 1, x, y, z);
        }
        return null;
    }

    public boolean isSizeableStructure()
    {
        return this.feature.structureEnabled;
    }

    protected void moveToAvgGroundLevel(World world, int x, int z)
    {
        int offY;
        if ((world.getWorldChunkManager() instanceof WorldChunkManagerPandora))
        {
            BiomeGenBase biomeAt = world.getBiomeGenForCoords(x, z);

            offY = (int) ((biomeAt.minHeight + biomeAt.maxHeight) * 8.0F);

            if (offY > 0)
            {
                this.boundingBox.offset(0, offY, 0);

                for (StructureComponent com : this.getComponents())
                {
                    com.getBoundingBox().offset(0, offY, 0);
                }
            }
        }
    }

}
