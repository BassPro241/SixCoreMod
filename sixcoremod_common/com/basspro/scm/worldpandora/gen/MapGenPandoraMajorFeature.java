package com.basspro.scm.worldpandora.gen;

import java.util.Iterator;

import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

import com.basspro.scm.worldpandora.gen.feature.PandoraFeature;
import com.basspro.scm.worldpandora.gen.structure.StructurePandoraComponent;
import com.basspro.scm.worldpandora.gen.structure.StructurePandoraMajorFeatureStart;

public class MapGenPandoraMajorFeature extends MapGenStructure
{
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ)
    {
        return PandoraFeature.getFeatureDirectlyAt(chunkX, chunkZ,
                this.worldObj).structureEnabled;
    }

    protected StructureStart getStructureStart(int chunkX, int chunkZ)
    {
        this.rand.setSeed(this.worldObj.getSeed());
        long rand1 = this.rand.nextLong();
        long rand2 = this.rand.nextLong();
        long chunkXr1 = chunkX * rand1;
        long chunkZr2 = chunkZ * rand2;
        this.rand.setSeed(chunkXr1 ^ chunkZr2 ^ this.worldObj.getSeed());
        this.rand.nextInt();

        return new StructurePandoraMajorFeatureStart(this.worldObj, this.rand,
                chunkX, chunkZ);
    }

    public int getSpawnListIndexAt(int par1, int par2, int par3)
    {
        int highestFoundIndex = -1;

        Iterator startIterator = this.structureMap.values().iterator();

        while (startIterator.hasNext())
        {
            StructureStart start = (StructureStart) startIterator.next();

            if ((start.isSizeableStructure())
                    && (start.getBoundingBox().intersectsWith(par1, par3, par1,
                            par3)))
            {
                Iterator componentIterator = start.getComponents().iterator();

                while (componentIterator.hasNext())
                {
                    StructureComponent component = (StructureComponent) componentIterator
                            .next();

                    if (component.getBoundingBox()
                            .isVecInside(par1, par2, par3))
                    {
                        if ((component instanceof StructurePandoraComponent))
                        {
                            StructurePandoraComponent tfComponent = (StructurePandoraComponent) component;

                            if (tfComponent.spawnListIndex > highestFoundIndex)
                            {
                                highestFoundIndex = tfComponent.spawnListIndex;
                            }
                        }
                        else
                        {
                            return 0;
                        }
                    }
                }
            }
        }

        return highestFoundIndex;
    }

}
