package com.example.RenderAndRegister;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = RenderAndRegister.MODID, name = "RenderAndRegister", version = RenderAndRegister.VERSION)
public class RenderAndRegister{
	
    public static final String MODID = "renderandregister";
    public static final String VERSION = "0.0";
    
    
    @Instance(MODID)
    public static RenderAndRegister instance;
    
    @SidedProxy
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event){
        
    }
}
