public class Runner {
	String name;
	double result = 0;		// race result
	boolean registered = false;
	
	// creates a new Runner instance
	Runner(String runnerName) {
		// implement this method
		name = runnerName;
	}
	
	// register the runner in the race
	public void register() {
		// implement this method
		registered = true;
	}
	
	// set the runner's race time
	public void setResult(double res) {
		// implement this method
		result = res;
	}
	
	// returns Runner's name
	public String getName() {
		// implement this method
		return name;
	}
	
	// get runner's race result
	public double getResult() {
		// implement this method
		return result;
	}
	
	// returns number of races Runner has registered for
	public boolean isRegistered() {
		// implement this method
		return registered;
	}
	
	public static void main(String[] args) {
		// small test for Runner
		Runner bob = new Runner("Bob");
		
		System.out.println("Name (should be Bob): " + bob.getName());
		System.out.println("isRegistered (should be false): " + bob.isRegistered());
		bob.register();		
		System.out.println("isRegistered (should be true): " + bob.isRegistered());		
		bob.register();		
		System.out.println("isRegistered (should be true): " + bob.isRegistered());
		System.out.println("result (should be 0.0): " + bob.getResult());
		bob.setResult(10.0);
		System.out.println("result (should be 10.0): " + bob.getResult());
	}

}