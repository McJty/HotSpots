package mcjty.immcraft.network;


import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketReturnInfoToClient implements IMessage {

    private InfoPacketClient packet;

    @Override
    public void fromBytes(ByteBuf buf) {
        int id = buf.readInt();
        Class<? extends InfoPacketClient> clazz = PacketHandler.getClientInfoPacket(id);
        try {
            packet = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        packet.fromBytes(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(PacketHandler.getClientInfoPacketId(packet.getClass()));
        packet.toBytes(buf);
    }

    public InfoPacketClient getPacket() {
        return packet;
    }

    public PacketReturnInfoToClient() {
    }

    public PacketReturnInfoToClient(InfoPacketClient packet) {
        this.packet = packet;
    }
}