
/*
 * Author: Sarah Grady
 * Date of Initialization: January 24, 2022
 * Date of Completion: January 24. 2022
 * Purpose: To become familiar with Switch's in coding by practicing them.
 */
public class computePay {
	public static void main(String[] args) {
		double miles = 700;
		// Connection to switch per trucker pay.
		double pay1 = truckerPay(1, miles);
		double pay2 = truckerPay(2, miles);
		double pay3 = truckerPay(3, miles);

		System.out.println("Company 1 will pay trucker $" + pay1 + " to transport the cargo " + miles + " miles.");
		System.out.println("Company 2 will pay trucker $" + pay2 + " to transport the cargo " + miles + " miles.");
		System.out.println("Company 3 will pay trucker $" + pay3 + " to transport the cargo " + miles + " miles.");
		
		if ((pay1 > pay2) || (pay1 > pay3)){
			System.out.println("Company 1 makes the most money.");
		}
		if ((pay2 > pay1) || (pay2 > pay3)){
				System.out.println("Company 2 makes the most money.");
		}
		if ((pay3 > pay2) || (pay3 > pay1)){
			System.out.println("Company 3 makes the most money.");
		}
	}

	public static double truckerPay(int shipper, double miles) {
		int days = (int) Math.ceil(miles / 660);
		double payForDay = 0;
		double payForMiles = 0;

		// Switch for each company's pay policy.
		switch (shipper) {
		case 1:
			payForDay = days * 200;
			payForMiles = 0.2 * miles;
			break;
		case 2:
			payForDay = days * 300;
			break;
		case 3:
			payForDay = days * 100;
			payForMiles = 0.35 * miles;
			break;
		}
		return payForDay + payForMiles;

	}

}
