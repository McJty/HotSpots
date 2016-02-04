package mcjty.hotspots.api;

/**
 * Use this to build IHotSpotType instances
 */
public interface IHotSpotTypeBuilder<T extends IHotSpotTypeBuilder> {

    T setLifecycle(HotSpotLifecycle lifecycle);
}
