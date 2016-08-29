package com.example.RenderAndRegister;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TestBlock extends Block{

	//Dynamic constructor, uses any material you pass to it.
	public TestBlock(Material materialIn) {
		super(materialIn);
		setRegistryName("test_block");
		setUnlocalizedName(getRegistryName().toString());
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	
	//Static constructor, doesn't need a material to instantiate.
	//In effect, EXACTLY the same as the constructor above, if one uses new TestBlock(Material.GROUND)
	public TestBlock(){
		super(Material.GROUND);
		setRegistryName("test_block");
		setUnlocalizedName(getRegistryName().toString());
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

}
