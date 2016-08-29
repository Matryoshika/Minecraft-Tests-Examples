package com.example.RenderAndRegister;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class LoopedRenderRegistry {

	public static void registerBlockRenderer(){
		
		//Time for another for-loop. Like last time, we will loop
		//through the same loop we used to register the blocks
		for(Block block : LoopedBlockRegistry.BlockList){
			
			/**
			 * DO NOT USE Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
			 * It is *incredibly* prone to issues. The only reason Vanilla rendering works, is because of the extensive knowledge of the system, and the years
			 * of expertice the coders of Mojang have.
			 * 
			 * Instead, use this; It is provided by forge, and has to be called in preInit: V
			 */
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
			
			
			/**
			 * If you use modid + ":" + getUnlocalizedName().substring() for the ModelResourceLocation, I swear I will find you, and
			 * bash your head with 1000 printed papers of this page.
			 * It is *completely* redundant, moronic, atrocious and gratuitous to manually create the ModelResourceLocation, when
			 * getRegistryName() DOES THAT FOR YOU! IT CREATES THE PATH USING MODID:NAME! THATS ALL YOU NEED!
			 * 
			 * Not to mention, unLocalizedName, should be used SOLELY to render the NAME of the item/block. It should not in any damned way
			 * have anything to do with unique identifiers.
			 */
		}
	}
}
