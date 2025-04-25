package grauly.spyglassrangefinder;

import grauly.spyglassrangefinder.rendering.RangefinderRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.minecraft.util.Identifier;

public class SpyglassRangefinderClient implements ClientModInitializer {

    public static final Identifier RANGEFINDER_LAYER = Identifier.of(SpyglassRangefinder.MODID, "rangefinder");

    @Override
    public void onInitializeClient() {
        HudLayerRegistrationCallback.EVENT.register(layeredDrawerWrapper -> {
            layeredDrawerWrapper.attachLayerAfter(IdentifiedLayer.MISC_OVERLAYS, RANGEFINDER_LAYER, RangefinderRenderer::onRender);
        });
    }
}
