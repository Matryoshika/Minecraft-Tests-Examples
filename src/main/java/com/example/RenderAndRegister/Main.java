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
    
    @SidedProxy
    public static CommonProxy proxy;
    
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//This is where both Registering, and Rendering, happens.
		//Please proceed to look over the Simple, then Looped Registy
		//Then proceed to look over the Simple, then Looped Render-registry
		proxy.preInit(event);
	}
    
    @EventHandler
    public void init(FMLInitializationEvent event){
        
    }
}
