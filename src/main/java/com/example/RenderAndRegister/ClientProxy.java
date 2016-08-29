package com.example.RenderAndRegister;

import com.example.ModelAnimationDebug.CommonProxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	
	public void preInit(FMLPreInitializationEvent event){
		
		//we know the blocks & items have been initialized in the commonproxy already, so let's register our renderers
		
		//SimpleRenderRegistry.registerRenderers();
		LoopedRenderRegistry.registerBlockRenderer();
		
		/**
		 * LoopedRenderRegistry is favoured, because it's set-and-forget. As long as you
		 * add the blocks to the List in the LoopedBlcoKRegistry, you don't need to add
		 * the block manually to the renderer.
		 */
	}

}
