package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.NetworkLink;
import nachos.machine.Packet;
import nachos.threads.Semaphore;

public class NewNetworkLink {
	NetworkLink nl = Machine.networkLink();
	Semaphore s = new Semaphore(0);
	public NewNetworkLink() {
		Runnable recieve = new Runnable() {
			
			@Override
			public void run() {
				Packet pkt = nl.receive();
				
			}
		};
		Runnable send = new Runnable() {
			
			@Override
			public void run() {
				
			}
		};
	}
}
