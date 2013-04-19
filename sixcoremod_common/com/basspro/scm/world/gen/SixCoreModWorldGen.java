package com.basspro.scm.world.gen;

import com.basspro.scm.world.gen.ore.WorldGenOnyxOre;

import cpw.mods.fml.common.registry.GameRegistry;

public class SixCoreModWorldGen
{

    public static void init()
    {
        GameRegistry.registerWorldGenerator(new WorldGenOnyxOre());
    }

}
