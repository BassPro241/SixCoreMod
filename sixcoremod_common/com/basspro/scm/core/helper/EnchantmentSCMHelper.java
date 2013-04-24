package com.basspro.scm.core.helper;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;

import com.basspro.scm.enchantment.SixCoreModEnchantment;

public class EnchantmentSCMHelper extends EnchantmentHelper
{
    public static int getCorrosionAspectModifier(EntityLiving par0EntityLiving)
    {
        return getEnchantmentLevel(SixCoreModEnchantment.corrosionAspect.effectId, par0EntityLiving.getHeldItem());
    }

}
