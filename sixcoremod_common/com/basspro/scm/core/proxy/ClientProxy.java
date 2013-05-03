package com.basspro.scm.core.proxy;

import net.minecraft.entity.item.EntityFallingSand;

import com.basspro.scm.client.renderer.block.RenderFallingDust;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{

    @Override
    public void registerRenders()
    {

        RenderingRegistry.registerEntityRenderingHandler(EntityFallingSand.class, new RenderFallingDust());
        
    }

}
