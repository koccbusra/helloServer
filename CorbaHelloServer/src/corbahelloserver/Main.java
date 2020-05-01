package corbahelloserver;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import HelloApp.Hello;
import HelloApp.HelloHelper;

public class Main {

	public static void main(String[] args) throws InvalidName, AdapterInactive, ServantNotActive, WrongPolicy, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed {
		// TODO Auto-generated method stub

		
	
			org.omg.CORBA.ORB orb = ORB.init(args, null);
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			
			HelloServant helloserv = new HelloServant();
			helloserv.setOrb(orb);
			
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloserv);
			Hello href = HelloHelper.narrow(ref);
			
			org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
			NamingContextExt  ncRef = NamingContextExtHelper.narrow(objref);
			
			NameComponent path[];
			path = ncRef.to_name("ABC");
			ncRef.rebind_context(path, ncRef);
	
			System.out.println("hello server !!!");
			
			for (;;) {
				orb.run();
			}
			
}}
