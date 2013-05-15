package com.basspro.scm.worldpandora.gen.structure;

import java.util.List;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentPandoraHollowHill extends StructurePandoraComponent
{
    int hillSize;
    int radius;

    public ComponentPandoraHollowHill(World world, Random rand, int i,
            int size, int x, int y, int z)
    {
        super(i);

        setCoordBaseMode(0);

        this.hillSize = size;
        this.radius = ((this.hillSize * 2 + 1) * 8 - 6);

        this.boundingBox = StructurePandoraComponent
                .getComponentToAddBoundingBox(x, y, z, -this.radius, -3,
                        -this.radius, this.radius * 2, 10, this.radius * 2, 0);
    }

    public void buildComponent(StructureComponent structurecomponent,
            List list, Random random)
    {
        super.buildComponent(structurecomponent, list, random);
    }

    public boolean addComponentParts(World world, Random rand,
            StructureBoundingBox sbb)
    {
        int[] sna = { 0, 128, 256, 512 };
        int sn = sna[this.hillSize];
        int[] mga = { 0, 1, 4, 9 };
        int mg = mga[this.hillSize];
        int[] tca = { 0, 2, 6, 12 };
        int tc = tca[this.hillSize];

        for (int i = 0; i < mg; i++)
        {
            int[] dest = getCoordsInHill2D(rand);
            String mobID = getMobID(rand);

            placeSpawnerAtCurrentPosition(world, rand, dest[0],
                    rand.nextInt(4), dest[1], mobID, sbb);
        }

        if (this.hillSize == 3);
            return true;
    }

    boolean isInHill(int cx, int cz)
    {
        int dx = this.radius - cx;
        int dz = this.radius - cz;
        int dist = (int) Math.sqrt(dx * dx + dz * dz);

        return dist < this.radius;
    }

    boolean isInHill(int mapX, int mapY, int mapZ)
    {
        int dx = this.boundingBox.minX + this.radius - mapX;
        int dy = (this.boundingBox.minY - mapY) * 2;
        int dz = this.boundingBox.minZ + this.radius - mapZ;
        int dist = dx * dx + dy * dy + dz * dz;
        return dist < this.radius * this.radius;
    }

    int[] getCoordsInHill2D(Random rand)
    {
        return getCoordsInHill2D(rand, this.radius);
    }

    int[] getCoordsInHill2D(Random rand, int rad)
    {
        int rx;
        int rz;
        do
        {
            rx = rand.nextInt(2 * rad);
            rz = rand.nextInt(2 * rad);
        } while (!isInHill(rx, rz));

        int[] coords = { rx, rz };
        return coords;
    }

    protected String getMobID(Random rand)
    {
        return getMobID(rand, this.hillSize);
    }

    protected String getMobID(Random rand, int level)
    {
        if (level == 1)
        {
            return getLevel1Mob(rand);
        }
        if (level == 2)
        {
            return getLevel2Mob(rand);
        }
        if (level == 3)
        {
            return getLevel3Mob(rand);
        }

        return "Spider";
    }

    public String getLevel1Mob(Random rand)
    {
        switch (rand.nextInt(10))
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return "Spider";
            case 6:
            case 7:
                return "Zombie";
            case 8:
                return "Silverfish";
            case 9:
        }
        return "Enderman";
    }

    public String getLevel2Mob(Random rand)
    {
        switch (rand.nextInt(10))
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return "Zombie";
            case 6:
            case 7:
                return "Skeleton";
            case 8:
            case 9:
                return "CaveSpider";
        }
        return "Enderman";
    }

    public String getLevel3Mob(Random rand)
    {
        switch (rand.nextInt(11))
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return "Skeleton";
            case 6:
            case 7:
            case 8:
                return "CaveSpider";
            case 9:
                return "Creeper";
            case 10:
        }
        return "Enderman";
    }

}
