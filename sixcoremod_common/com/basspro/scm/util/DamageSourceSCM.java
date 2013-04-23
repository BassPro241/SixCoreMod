package com.basspro.scm.util;

import net.minecraft.util.DamageSource;

public class DamageSourceSCM extends DamageSource
{
    private boolean corrosionDamage;

    protected DamageSourceSCM(String par1)
    {
        super(par1);
        
    }

    protected DamageSourceSCM setCorrosionDamage()
    {
        this.corrosionDamage = true;
        return this;
    }

    public boolean isCorrosionDamage()
    {
        return this.corrosionDamage;
    }
}
