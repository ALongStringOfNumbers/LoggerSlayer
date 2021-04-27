package mod.alson.loggerslayer;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
@IFMLLoadingPlugin.SortingIndex(Integer.MAX_VALUE)
public final class LoggerSlayerPlugin implements IFMLLoadingPlugin {

    public static final Logger LOGGER = LogManager.getLogger("LoggerSlayer");

    static {
        LOGGER.info("LoggerSlayer Mixins Initializing...");
        MixinBootstrap.init();
        addConfig();
    }

    private static void addConfig() {
        Mixins.addConfiguration("mixin.loggerslayer.json");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) { }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
