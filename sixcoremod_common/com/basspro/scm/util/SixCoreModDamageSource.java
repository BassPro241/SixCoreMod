package com.basspro.scm.util;

import net.minecraft.util.DamageSource;

import com.basspro.scm.lib.Strings;


public class SixCoreModDamageSource
{

    public static DamageSource isCorroding;
    
    public static void init()
    {
        isCorroding = new DamageSourceSCM(Strings.IS_CORRODING_NAME).setCorrosionDamage();
    }

    
}
