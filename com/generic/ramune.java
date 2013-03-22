package com.generic;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ramune extends ItemFood {
	public String wsb = "";
	public ramune(int par1, int par2, float par3, boolean par4, String par5) {
		super(par1, par2, par3, par4);
		// TODO Auto-generated constructor stub
		//this.setCreativeTab(CreativeTabs.tabFood);
        wsb = par5;
    
    }
    @Override
    public void updateIcons(IconRegister iconRegister)
    {
             iconIndex = iconRegister.registerIcon(wsb);
    }


}
