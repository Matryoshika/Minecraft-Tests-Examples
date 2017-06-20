package com.example.RenderAndRegister;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Just as we did with the BlockRegistry, we have to use the annotation to tell
 * Forge "HEY, when you are ready to register models, use this!"
 * However, as this class uses Client-side only code, we have to make sure that it
 * will only exist on the Client, therefore we use the @SideOnly annotation.
 * Alternatively, you could do this inside your Client-Proxy instead of calling
 * @SideOnly.
 */
@SideOnly(Side.CLIENT)
@EventBusSubscriber
public class RenderRegistry {

	@SubscribeEvent
	public static void registerBlockRenderer(ModelRegistryEvent event) {

		/**
		 * DO NOT USE
		 * Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
		 * register(Item.getItemFromBlock(block), 0, new
		 * ModelResourceLocation(block.getRegistryName(), "inventory")); It is
		 * *incredibly* prone to issues. The only reason Vanilla rendering
		 * works, is because of the extensive knowledge of the system, and the
		 * years of expertise the coders of Mojang have.
		 * 
		 * Instead, use ModelLoader; It is provided by forge, and has to be
		 * called before or during preInit: V
		 */

		// Time for another for-loop. Like last time, we will loop
		// through the same loop we used to register the blocks
		for (Block block : BlockRegistry.blocks) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}

		// OR we can use Lambda Expressions here as well
		BlockRegistry.blocks.forEach(block -> ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),0, new ModelResourceLocation(block.getRegistryName(), "inventory")));

		
		//Remember, only use either one, never both.
		
		/**
		 * If you use modid + ":" + getUnlocalizedName().substring() for the
		 * ModelResourceLocation, I swear I will find you, and bash your head
		 * with 1000 printed papers of this page. It is *completely* redundant,
		 * moronic, atrocious and gratuitous to manually create the
		 * ModelResourceLocation, when getRegistryName() DOES THAT FOR YOU! IT
		 * CREATES THE PATH USING MODID:NAME! THATS ALL YOU NEED!
		 * 
		 * Not to mention, unLocalizedName, should be used SOLELY to render the
		 * NAME of the item/block. It should not in any damned way have anything
		 * to do with unique identifiers. </rage>
		 */
	}
}
