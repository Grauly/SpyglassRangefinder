package grauly.spyglassrangefinder;

import grauly.spyglassrangefinder.rendering.RangefinderRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.util.Identifier;

public class SpyglassRangefinderClient implements ClientModInitializer {

    public static final Identifier RANGEFINDER_LAYER = Identifier.of(SpyglassRangefinder.MODID, "rangefinder");

    @Override
    public void onInitializeClient() {
        HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, RANGEFINDER_LAYER, RangefinderRenderer::onRender);
    }
}
