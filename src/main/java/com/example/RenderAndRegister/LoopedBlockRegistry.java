package com.example.RenderAndRegister;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;


/**
 * The tiny-bit-more advanced way of registering blocks (and items) to the game
 * Makes use of a List, from which we then take back the block, and register it.
 * 
 * Please view LoopedRenderRegistry to see how this is the better alternative, not 
 * just for less lines of code, but also how it makes registering renderers for 
 * blocks that much easier
 */
public class LoopedBlockRegistry {
	
	public static Block TESTBLOCK;
	
	
	//We create a list that holds each and every block we make. When we make a new one, we only need
	//to add the block to this list.
	public static List<Block> BlockList = new ArrayList<Block>();
	
	public static void initRegistryBlocks(){
		//Using the second constructor we made in the TestBlock class.
		BlockList.add(TESTBLOCK = new TestBlock());
		
		//For loop. Essentially, for each and every block we find in the BlockList, we will call it "block"
		for(Block block : BlockList){
			GameRegistry.register(block);
			
			//Don't forget to register the ItemBlock variant (When held, or in an inventory, a block is an "item")
			ItemBlock iblock = new ItemBlock(block);
			iblock.setRegistryName(block.getRegistryName());
			GameRegistry.register(iblock);
		}
	}

}
