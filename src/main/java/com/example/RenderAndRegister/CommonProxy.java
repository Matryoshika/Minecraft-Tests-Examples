package com.example.RenderAndRegister;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		
		//Here we register our blocks and items
		
		//SimpleBlockRegistry.initRegistryBlocks();
		BlockRegistryLooped.initRegistryBlocks();
		
		/**
		 * LoopedBlockRegistry is favoured, because you only need to add the block to the
		 * List. You don't need the extra line that registers the hard-coded instance of each
		 * block.
		 * This means, that in bigger mods, with let's say 50-100+ blocks, you cut the lines of 
		 * code by almost 50%!
		 * Add in the ease of the self-maintaining LoopedRenderRegistry, and you should be able
		 * to see how much more easier it is to loop the registries.
		 */

	}

}
