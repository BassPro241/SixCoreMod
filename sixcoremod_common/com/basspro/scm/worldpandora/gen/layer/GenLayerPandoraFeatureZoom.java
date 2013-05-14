package com.basspro.scm.worldpandora.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerPandoraFeatureZoom extends GenLayer
/*    */ {
/*    */   public GenLayerPandoraFeatureZoom(long l, GenLayer genlayer)
/*    */   {
/* 12 */     super(l);
/* 13 */     this.parent = genlayer;
/*    */   }
/*    */ 
/*    */   public int[] getInts(int x, int z, int width, int depth)
/*    */   {
/* 18 */     int sx = x >> 1;
/* 19 */     int sz = z >> 1;
/* 20 */     int swidth = (width >> 1) + 3;
/* 21 */     int sdepth = (depth >> 1) + 3;
/* 22 */     int[] src = this.parent.getInts(sx, sz, swidth, sdepth);
/* 23 */     int[] dest = IntCache.getIntCache(swidth * 2 * (sdepth * 2));
/* 24 */     int doubleWidth = swidth << 1;
/* 25 */     for (int dz = 0; dz < sdepth - 1; dz++)
/*    */     {
/* 27 */       for (int dx = 0; dx < swidth - 1; dx++)
/*    */       {
/* 29 */         dest[(dx * 2 + 0 + (dz * 2 + 0) * doubleWidth)] = src[(dx + dz * swidth)];
/* 30 */         dest[(dx * 2 + 1 + (dz * 2 + 0) * doubleWidth)] = 0;
/* 31 */         dest[(dx * 2 + 0 + (dz * 2 + 1) * doubleWidth)] = 0;
/* 32 */         dest[(dx * 2 + 1 + (dz * 2 + 1) * doubleWidth)] = 0;
/*    */       }
/*    */     }
/*    */ 
/* 36 */     int[] output = IntCache.getIntCache(width * depth);
/* 37 */     for (int copyZ = 0; copyZ < depth; copyZ++)
/*    */     {
/* 39 */       System.arraycopy(dest, (copyZ + (z & 0x1)) * (swidth << 1) + (x & 0x1), output, copyZ * width, width);
/*    */     }
/*    */ 
/* 42 */     return output;
/*    */   }
/*    */ 
/*    */   public static GenLayer multipleZoom(long seed, GenLayer genlayer, int loops)
/*    */   {
/* 48 */     GenLayer layer = genlayer;
/* 49 */     for (int i = 0; i < loops; i++)
/*    */     {
/* 51 */       layer = new GenLayerPandoraFeatureZoom(seed + i, layer);
/*    */     }
/*    */ 
/* 54 */     return layer;
/*    */   }

}
