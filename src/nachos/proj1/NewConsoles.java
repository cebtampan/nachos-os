package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.SerialConsole;
import nachos.threads.Semaphore;

public class NewConsoles {
	private SerialConsole sc = Machine.console();
	private Semaphore s = new Semaphore(0);
	private String buffer = "";
	public NewConsoles() {
		Runnable recieve = new Runnable() {
			
			@Override
			public void run() {
				char c = (char) sc.readByte();
				if(c == '\n') {
					s.V();
					return;
				}
				buffer = buffer + c;
			}
		};
		
		Runnable send = new Runnable() {
			
			@Override
			public void run() {
				s.V();
			}
		};
		sc.setInterruptHandlers(recieve, send);
	}
	
	public String readLine() {
		buffer = "";
		s.P();
		return buffer;
	}
	
	public void print(String args) {
		for(char c : args.toCharArray()) {
			sc.writeByte(c);
			s.P();
		}
	}
	public void printInt(Integer args) {
		print(args.toString());
	}
	
	public Integer readInt() {
		return Integer.parseInt(readLine());
	}
	
	public Double readDouble() {
		return Double.parseDouble(readLine());
	}
}
