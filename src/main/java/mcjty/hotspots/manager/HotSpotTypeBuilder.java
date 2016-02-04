package mcjty.hotspots.manager;

import mcjty.hotspots.api.HotSpotAttenuation;
import mcjty.hotspots.api.HotSpotLifecycle;
import mcjty.hotspots.api.IHotSpotTypeBuilder;

public abstract class HotSpotTypeBuilder<T extends IHotSpotTypeBuilder> implements IHotSpotTypeBuilder<T> {

    private HotSpotLifecycle lifecycle = HotSpotLifecycle.LINEARDECREASE;

    @Override
    public T setLifecycle(HotSpotLifecycle lifecycle) {
        this.lifecycle = lifecycle;
        return (T) this;
    }

    public abstract HotSpotAttenuation getAttenuation();

    public HotSpotLifecycle getLifecycle() {
        return lifecycle;
    }
}
