package com.example.RenderAndRegister;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * Here we will assign blocks to a collection, and then use said collection to
 * register, and later, also render each block.
 * 
 * The same functionality can be used for Items.
 * 
 * Please do note the Annotation below here. It is required because we will
 * be subscribing to an event, <b>before</b> preInit.
 */
@EventBusSubscriber
public class BlockRegistry {
	
	public static Block TESTBLOCK;
	
	
	//We create a list that holds each and every block we make. When we make a new block, 
	//we only need to add the block to this list.
	public static Set<Block> blocks = new HashSet<Block>();
	
	public static void prepareBlocks(){
		//Using the second constructor we made in the TestBlock class.
		blocks.add(TESTBLOCK = new TestBlock());

	}
	
	//This method will be called without us calling it. This is because 
	//Forge calls it -for- us, when the RegistryEvent happens. This is why
	//we had to use the @Mod.EventBusSubscriber at the top of the class.
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event){
		
		//We make sure that the list gets filled with our blocks.
		prepareBlocks();
		
		//For-each-loop. Essentially, for each and every block we find in the BlockList, 
		//we will call it "block", and register it.
		for(Block block : blocks){
			event.getRegistry().register(block);
		}
		
		//OR we can also use Java8 Lambda expressions here.
		//Only use either the for-loop, or the forEach expression. Not both (as that would register it twice)
		blocks.forEach(event.getRegistry()::register);
	}
	
	//Don't forget to register the ItemBlock variant (When held, or in an inventory, a block is an "item")
	//We do not need to call prepareBlocks() in this method, because Blocks are registered before items.
	//Thus, our registerBlocks method has already happened.
	//ItemBlocks are of course not required to be made for Items.
	@SubscribeEvent
	public static void registerItemBlocks(Register<Item> event){
		
		for(Block block : blocks){
			ItemBlock iblock = new ItemBlock(block);
			iblock.setRegistryName(block.getRegistryName());
			event.getRegistry().register(iblock);
		}
		
		
		//OR we can do this in one line (we split it in two here, to make it easier to read all at once, but the split is only syntactical sugar)
		// by using another lambda expression again
		//What is done here is: for each block in this collection(that contains blocks! As infered by the type-parameter aka the <Block> part), 
		//create a new ItemBlock and set it's RegistryName to the block's RegistryName. 
		//Put this new ItemBlock into a new list, and for each thing in this new list, register
		blocks.stream().map(block -> new ItemBlock(block).setRegistryName(block.getRegistryName()))
		.collect(Collectors.toList()).forEach(event.getRegistry()::register);
		
		
		//Choose one way, and stick to it. For-loops are simpler, but Lambda's are good to use, as they can simplify several lines of code into a single one.
		
	}

}
