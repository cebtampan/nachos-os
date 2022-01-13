package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.MalformedPacketException;
import nachos.machine.NetworkLink;
import nachos.machine.Packet;
import nachos.threads.Semaphore;

public class CustNetworkLink {
	NetworkLink nl = Machine.networkLink();
	Semaphore s = new Semaphore(0);
	public CustNetworkLink() {
		nl.setInterruptHandlers(new Runnable() {
			@Override
			public void run() {
				Packet pkt = nl.receive();
//				conn.println("Message : " + new String(pkt.contents));
				System.out.println("Message : " + new String(pkt.contents));
			}
		}, new Runnable() {
			@Override
			public void run() {
				s.P();
			}
		});
	}
	
	public void send(String msg, Integer destLink) {
		try {
			Packet pkt = new Packet(destLink, nl.getLinkAddress(), msg.getBytes());
			nl.send(pkt);
			s.P();
		} catch (MalformedPacketException e) {
			e.printStackTrace();
		}
	}
}
