package com.pdp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.pdp.controll.Controll;
import com.pdp.entity.Player;

public class Client {

	static Scanner sc = new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Controll c = new Controll();

	public static void main(String[] args) {

		System.out.println("---------------- * IPL CRUD PROJECT * ---------------");

		int choice = 0;
		do {
			System.out.println("============================");
			System.out.println("|           MENU           |");
			System.out.println("============================");
			System.out.println("| 1. Insert into table     |");
			System.out.println("|--------------------------|");
			System.out.println("| 2. Display from table    |");
			System.out.println("|--------------------------|");
			System.out.println("| 3. Update into table     |");
			System.out.println("|--------------------------|");
			System.out.println("| 4. Delete form table     |");
			System.out.println("|--------------------------|");
			System.out.println("| 5. Exit...               |");
			System.out.println("----------------------------");

			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter only integer number's...");
				e.printStackTrace();
				break;
			}
			switch (choice) {

			case 1: {
				int pjrno = 0;
				String pname = null;
				int run = 0;
				int wicket = 0;
				String tname = null;

				try {
					System.out.println("Enter Jercey Number : ");
					pjrno = sc.nextInt();
					System.out.println("Enter Player Name : ");
					pname = br.readLine();
					System.out.println("Enter Player Run : ");
					run = sc.nextInt();
					System.out.println("Enter Player Wicket : ");
					wicket = sc.nextInt();
					System.out.println("Enter Player Team name : ");
					tname = br.readLine();

				} catch (Exception e) {
					System.out.println("Please enter valid input...");
					e.printStackTrace();
					break;
				}

				String res = c.insertPla(pjrno, pname, run, wicket, tname);
				System.out.println(res);
				System.out.println(); // for new line
				break;
			}
			case 2: {
				int ch = 0;
				do {
					System.out.println("================================================");
					System.out.println("|              For Display Menu                |");
					System.out.println("================================================");
					System.out.println("| 1. See All team's in player table            |");
					System.out.println("|----------------------------------------------|");
					System.out.println("| 2. See player name by using team name        |");
					System.out.println("|----------------------------------------------|");
					System.out.println("| 3. See All Players and it's info in the table|");
					System.out.println("|----------------------------------------------|");
					System.out.println("| 4. Main Menu                                 |");
					System.out.println("------------------------------------------------");

					try {
						ch = sc.nextInt();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("please enter only integer number's...");
						break;
					}

					switch (ch) {
					case 1: {
						Set<String> at = c.getAllTname();
						System.out.println("=============================");
						System.out.println("| ALL TEAM NAME IN DATABASE |");
						System.out.println("|===========================|");
						for (String teamnames : at) {
							System.out.printf("| %-25s |\n", teamnames);
						}
						System.out.println("-----------------------------");
						System.out.println();// for new line

						break;
					}
					case 2: {
						System.out.println("Which Team player do you want : ");
						System.out.println("Enter This Team name ");
						String tname = null;

						try {
							tname = br.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}

						Set<String> pn = c.getPlayerName(tname);
						System.out.println("===============================");
						System.out.println("|    ALL Player's in " + tname + "      |");
						System.out.println("|=============================|");
						for (String pnames : pn) {
							System.out.printf("| %-27s |\n", pnames);
							System.out.println("|-----------------------------|");

						}
						System.out.println(); // for new line

						break;
					}
					case 3: {
						List<Player> lop = c.getAllPlaInfo();
						System.out.println(
								"=============================================================================");
						System.out.println(
								"|                   ALL PLAYER'S IN DATABASE                                |");
						System.out.println(
								"|===========================================================================|");
						for (Player player : lop) {
							System.out.printf("| %-73s |\n", player);
							System.out.println(
									"----------------------------------------------------------------------------");

						}
						System.out.println(); // for new line
						break;
					}
					case 4: {

						break;
					}
					default: {
						System.out.println("Invalid Input ...\nPlease enter valid input...\n");
						break;
					}

					}

				} while (ch != 4);

				break;
			}
			case 3: {
				int cho = 0;
				String pname = null;
				do {
					System.out.println("===============================");
					System.out.println("|         Update Menu         |");
					System.out.println("===============================");
					System.out.println("| What do you want update :-  |");
					System.out.println("-------------------------------");
					System.out.println("|  1. Update jersey number    |");
					System.out.println("|-----------------------------|");
					System.out.println("|  2. Update player run's     |");
					System.out.println("|-----------------------------|");
					System.out.println("|  3. Update player wicket    |");
					System.out.println("|-----------------------------|");
					System.out.println("|  4. Update player Team name |");
					System.out.println("|-----------------------------|");
					System.out.println("|  5. Update All info         |");
					System.out.println("|-----------------------------|");
					System.out.println("|  6. Main Menu               |");
					System.out.println("-------------------------------");

					try {
						cho = sc.nextInt();
					} catch (Exception e) {
						System.out.println("Please enter only integer number's");
						e.printStackTrace();
						break;
					}

					switch (cho) {
					case 1: {
						int ujn = 0;
						try {
							System.out.println("enter player name : ");
							pname = br.readLine();
							System.out.println("enter Updated jersey num : ");
							ujn = sc.nextInt();
						} catch (Exception e) {
							System.out.println("Please enter valid input..");
							e.printStackTrace();
							break;
						}
						String res = c.updatePlaJrno(pname, ujn);
						System.out.println(res);
						System.out.println(); // for new line
						break;
					}
					case 2: {

						int run = 0;
						try {
							System.out.println("enter player name : ");
							pname = br.readLine();
							System.out.println("Enter Updated runs : ");
							run = sc.nextInt();
						} catch (Exception e) {
							System.out.println("Please enter valid input..");
							e.printStackTrace();
							break;
						}
						String res = c.updateRun(pname, run);
						System.out.println(res);
						System.out.println(); // for new line
						break;
					}
					case 3: {
						int wicket = 0;
						try {
							System.out.println("enter player name : ");
							pname = br.readLine();
							System.out.println("Enter Updated Wickets : ");
							wicket = sc.nextInt();
						} catch (Exception e) {
							System.out.println("Please enter valid input..");
							e.printStackTrace();
							break;
						}
						String res = c.updateWicket(pname, wicket);
						System.out.println(res);
						System.out.println(); // for new line
						break;
					}
					case 4: {
						String tname = null;
						try {
							System.out.println("Enter player name : ");
							pname = br.readLine();
							System.out.println("Enter Updated Team name : ");
							tname = br.readLine();
						} catch (Exception e) {
							System.out.println("Please enter valid input..");
							e.printStackTrace();
							break;
						}
						String res = c.updateTname(pname, tname);
						System.out.println(res);
						System.out.println(); // for new line
						break;
					}
					case 5: {
						int ujn = 0;
						String un = null;
						int ur = 0;
						int uw = 0;
						String utn = null;
						try {
							System.out.println("Enter player name ");
							pname = br.readLine();
							System.out.println("Enter Updated jersey num ");
							ujn = sc.nextInt();
							System.out.println("Enter Updated player name ");
							un = br.readLine();
							System.out.println("Enter Updated Player run ");
							ur = sc.nextInt();
							System.out.println("Enter Updated Player wicket ");
							uw = sc.nextInt();
							System.out.println("Enter Updated Team name ");
							utn = br.readLine();

							String res = c.updateInfo(pname, ujn, un, ur, uw, utn);
							System.out.println(res);
							System.out.println(); // for new line

						} catch (Exception e) {
							System.out.println("enter valid input..");
							e.printStackTrace();
						}

						break;
					}
					case 6: {
						break;
					}
					default: {
						System.out.println("Invalid numbe.. \nPlease enter valid number...\n");
					}

					}

				} while (cho != 6);

				break;
			}
			case 4: {
				System.out.println("Which player information do you want Delete : ");
				System.out.println("Enter this player name : ");
				String pname = null;
				try {
					pname = br.readLine();
				} catch (IOException e) {
					System.out.println("Please enter valid input..");
					e.printStackTrace();
					break;
				}

				String res = c.deletePlaInfo(pname);
				System.out.println(res);
				System.out.println(); // for new line

				break;
			}
			case 5: {
				System.out.println("Thank you for use our application... \n कृपया पुन्हा भेट द्या धन्यवाद...");
				break;
			}
			default: {
				System.out.println("Invalid input...\nPlease try again... \n");
			}

			}

		} while (choice != 5);

	}

}
