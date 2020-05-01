package corbahelloserver;

import org.omg.CORBA.ORB;

import HelloApp.HelloPOA;

public class HelloServant extends HelloPOA {
	
	private String message = "Hello World";
	
	private ORB orb;
	
	
	@Override
	public String hellomessage() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public void hellomessage(String newHellomessage) {
		// TODO Auto-generated method stub
		message = newHellomessage;
	}

	public ORB getOrb() {
		return orb;
	}

	public void setOrb(ORB orb) {
		this.orb = orb;
	}

}
