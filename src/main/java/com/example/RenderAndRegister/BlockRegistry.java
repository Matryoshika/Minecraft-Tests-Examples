package com.example.RenderAndRegister;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


/**
 * Here we will assign blocks to an ArrayList, and then use said list to
 * register, and later, also render each block.
 * 
 * The same functionality can be used for Items.
 * 
 * Please do note the Annotation below here. It is required because we will
 * be subscribing to an event, before preInit.
 */
@Mod.EventBusSubscriber
public class BlockRegistry {
	
	public static Block TESTBLOCK;
	
	
	//We create a list that holds each and every block we make. When we make a new block, 
	//we only need to add the block to this list.
	public static List<Block> BlockList = new ArrayList<Block>();
	
	public static void prepareBlocks(){
		//Using the second constructor we made in the TestBlock class.
		BlockList.add(TESTBLOCK = new TestBlock());

	}
	
	//This method will be called without us calling it. This is because 
	//Forge calls it -for- us, when the RegistryEvent happens. This is why
	//we had to use the @Mod.EventBusSubscriber at the top of the class.
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event){
		
		//We make sure that the list gets filled with our blocks.
		prepareBlocks();
		
		//For-each-loop. Essentially, for each and every block we find in the BlockList, 
		//we will call it "block", and register it.
		for(Block block : BlockList){
			event.getRegistry().register(block);
		}
	}
	
	//Don't forget to register the ItemBlock variant (When held, or in an inventory, a block is an "item")
	//We do not need to call prepareBlocks() in this method, because Blocks are registered before items.
	//Thus, our registerBlocks method has already happened.
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event){
		for(Block block : BlockList){
			ItemBlock iblock = new ItemBlock(block);
			iblock.setRegistryName(block.getRegistryName());
			event.getRegistry().register(iblock);
		}
	}

}
