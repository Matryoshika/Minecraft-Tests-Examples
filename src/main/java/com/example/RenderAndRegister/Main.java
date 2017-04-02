package com.example.RenderAndRegister;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = "RenderAndRegister", version = Main.VERSION)
public class Main{
	
    public static final String MODID = "renderandregister";
    public static final String VERSION = "0.0";
    
    
    @Instance(MODID)
    public static Main instance;
    
    @SidedProxy(clientSide = "com.example.RenderAndRegister.ClientProxy", serverSide = "com.example.RenderAndRegister.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	//What is this? Why isn't blocks/items being registered here?
    	//Go and have a look over at the BlockRegistry & RenderRegistry classes!
	}
    
    @EventHandler
    public void init(FMLInitializationEvent event){
        
    }
}
