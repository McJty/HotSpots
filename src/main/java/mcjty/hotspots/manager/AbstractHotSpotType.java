package mcjty.hotspots.manager;

import mcjty.hotspots.api.HotSpotAttenuation;
import mcjty.hotspots.api.HotSpotLifecycle;
import mcjty.hotspots.api.IHotSpotType;
import net.minecraft.nbt.NBTTagCompound;

public abstract class AbstractHotSpotType implements IHotSpotType {

    private final String id;
    private final HotSpotAttenuation attenuation;
    private final HotSpotLifecycle lifecycle;

    public AbstractHotSpotType(String id, HotSpotTypeBuilder builder) {
        this.id = id;
        this.attenuation = builder.getAttenuation();
        this.lifecycle = builder.getLifecycle();
    }

    @Override
    public abstract void clear();

    @Override
    public String getID() {
        return id;
    }

    @Override
    public HotSpotAttenuation getAttenuation() {
        return attenuation;
    }

    @Override
    public HotSpotLifecycle getLifeCycle() {
        return lifecycle;
    }

    public abstract void createFromNBT(NBTTagCompound tag);

    public abstract void writeToNBT(NBTTagCompound tag);
}
