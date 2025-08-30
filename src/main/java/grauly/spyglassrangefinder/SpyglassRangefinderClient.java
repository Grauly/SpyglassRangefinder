package grauly.spyglassrangefinder;

import grauly.spyglassrangefinder.rendering.RangefinderRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class SpyglassRangefinderClient implements ClientModInitializer {

    public static final Identifier RANGEFINDER_LAYER = Identifier.of(SpyglassRangefinder.MODID, "rangefinder");
    public static final KeyBinding tpKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key." + SpyglassRangefinder.MODID + "teleport",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_GRAVE_ACCENT,
            "category." + SpyglassRangefinder.MODID + ".category"
    ));

    @Override
    public void onInitializeClient() {
        HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, RANGEFINDER_LAYER, RangefinderRenderer::onRender);
        ClientTickEvents.END_CLIENT_TICK.register(TeleportTrigger::tick);
    }
}
