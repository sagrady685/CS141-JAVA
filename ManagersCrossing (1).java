/* Author: Sarah Grady
 * Date of Initialization: January 25, 2022
 * Date of Completion: January 31, 2022
 * Purpose: To practice applying boolean logic and writing longer code with real world application. 
 */
package firstProject;

public class ManagersCrossing {

	public static boolean isMoveOkay(int boatBefore, int managerABefore, int managerBBefore, int managerCBefore,
			int engineerABefore, int engineerBBefore, int engineerCBefore, int boatAfter, int managerAAfter,
			int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
		// check 1: Insuring all variables are 1 or 2.
		if ((boatBefore < 1 || boatBefore > 2) || (managerABefore < 1 || managerABefore > 2)
				|| (managerBBefore < 1 || managerBBefore > 2) || (managerCBefore < 1 || managerCBefore > 2)
				|| (engineerABefore < 1 || engineerABefore > 2) || (engineerBBefore < 1 || engineerBBefore > 2)
				|| (engineerCBefore < 1 || engineerCBefore > 2) || (boatAfter < 1 || boatAfter > 2)
				|| (managerAAfter < 1 || managerAAfter > 2) || (managerBAfter < 1 || managerBAfter > 2)
				|| (managerCAfter < 1 || managerCAfter > 2) || (engineerAAfter < 1 || engineerAAfter > 2)
				|| (engineerBAfter < 1 || engineerBAfter > 2) || (engineerCAfter < 1 || engineerCAfter > 2)) {
			System.out.println("All positions must be 1 or 2!");
			return false;
		}
		// check 2: ensuring the boat is always moving.
		if (boatBefore == boatAfter) {
			System.out.println("The boat must move!");
			return false;
		}
		// check 3: ensuring the boat and person moving are together.
		if (((managerABefore != managerAAfter) && (managerABefore != boatBefore))
				|| ((managerBBefore != managerBAfter) && (managerBBefore != boatBefore))
				|| ((managerCBefore != managerCAfter) && (managerCBefore != boatBefore))
				|| ((engineerABefore != engineerAAfter) && (engineerABefore != boatBefore))
				|| ((engineerBBefore != engineerBAfter) && (engineerBBefore != boatBefore))
				|| ((engineerCBefore != engineerCAfter) && (engineerCBefore != boatBefore))) {
			System.out.println("You may not move a person who is not with the boat!");
			return false;
		}
		// check 4: ensuring there is always 1 or 2 people moving.
		int numberMoving = 0;
		if (managerABefore != managerAAfter) {
			numberMoving++;
		}
		if (managerBBefore != managerBAfter) {
			numberMoving++;
		}
		if (managerCBefore != managerCAfter) {
			numberMoving++;
		}
		if (engineerABefore != engineerAAfter) {
			numberMoving++;
		}
		if (engineerBBefore != engineerBAfter) {
			numberMoving++;
		}
		if (engineerCBefore != engineerCAfter) {
			numberMoving++;
		}
	
		if ((numberMoving > 2) || (numberMoving < 1)) {
			System.out.println("You must move one or two people!");
			return false;
		}
		// check 5: ensuring no managers recruite engineers. 
		if (((managerAAfter == engineerBAfter) && (managerBAfter != engineerBAfter)) 
				|| ((managerAAfter == engineerCAfter) && (managerCAfter != engineerCAfter))) {
			System.out.println("Manager A would try to recruit someone!");
			return false; 
		}
		if (((managerBAfter == engineerAAfter) && (managerAAfter != engineerAAfter)) 
				|| ((managerBAfter == engineerCAfter) && (managerCAfter != engineerCAfter))) {
			System.out.println("Manager B would try to recruit someone!");
			return false;
		}
		if (((managerCAfter == engineerBAfter) && (managerBAfter != engineerBAfter)) 
				|| ((managerCAfter == engineerAAfter) && (managerAAfter != engineerAAfter))) {
			System.out.println("Manager C would try to recruit someone!");
			return false;
		}
		// final check: ensuring everyone is at checkpoint 2
		if ((managerAAfter == 2) && (managerBAfter == 2) && (managerCAfter == 2) && (engineerAAfter == 2)
				&& (engineerBAfter == 2) && (engineerCAfter == 2)) {
			// runs if all others print true, so no ways to cheat or puzzle will not be solved. 
			System.out.println("You solved the puzzle!");
		}
		return true;
		
		
	}
}
