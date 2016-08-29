package com.example.RenderAndRegister;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;


/**
 * This is a SIMPLE, and quite arduous registration for blocks. Please take a look at LoopedBlockRegistry
 * for a better alternative, unless you want to define a block, and register, define a block, register, over and over again.
 * 
 * LoopedBlockRegistry also features something that will make it MUCH easier to automatically render each block.
 */

public class BlockRegistrySimple {

	public static Block TESTBLOCK;
	
	
	
	public static void initRegistryBlocks(){
		//Using the second constructor we made in the TestBlock class.
		TESTBLOCK = new TestBlock();
		register(TESTBLOCK);
		
		//Can also call this
		/* TESTBLOCK = new TestBlock(Material.GROUND)
		 * register(TESTBLOCK);
		 */
	}
	
	public static void register(Block block){
		//Register the block to the game.
		GameRegistry.register(block);
		
		//Register an ItemBlock variant as well (when held in hand, or inside an inventory)
		ItemBlock iblock = new ItemBlock(block);
		iblock.setRegistryName(block.getRegistryName());
		GameRegistry.register(iblock);
	}
}
