package com.basspro.scm.worldpandora.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerPandoraBiomeBorders extends GenLayer
{
    public GenLayerPandoraBiomeBorders(long l, GenLayer genlayer)
    {
        super(l);
        this.parent = genlayer;
    }

    public int[] getInts(int x, int z, int width, int depth)
    {
        int nx = x - 1;
        int nz = z - 1;
        int nwidth = width + 2;
        int ndepth = depth + 2;
        int[] input = this.parent.getInts(nx, nz, nwidth, ndepth);
        int[] output = IntCache.getIntCache(width * depth);
        for (int dz = 0; dz < depth; dz++)
        {
            for (int dx = 0; dx < width; dx++)
            {
/*                int right = input[(dx + 0 + (dz + 1) * nwidth)];
                int left = input[(dx + 2 + (dz + 1) * nwidth)];
                int up = input[(dx + 1 + (dz + 0) * nwidth)];
                int down = input[(dx + 1 + (dz + 2) * nwidth)];*/
                int center = input[(dx + 1 + (dz + 1) * nwidth)];

                output[(dx + dz * width)] = center;
            }

        }

        return output;
    }
}
