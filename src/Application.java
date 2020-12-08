
import java.io.File;
import java.util.Scanner;

public class Application {

	public static int menu() {
		System.out.println("Ââåä³òü 10 äëÿ òîãî, ùîá ñòâîðèòè íîâèé ê³íîòåàòð");
		System.out.println("Ââåä³òü 11 äëÿ òîãî, ùîá çáåðåãòè ê³íîòåàòð â ôàéë");
		System.out.println("Ââåä³òü 12 äëÿ òîãî, ùîá çàâàíòàæèòè ê³íîòåàòð ³ç ôàéëó");
		System.out.println("Ââåä³òü 13 äëÿ òîãî, ùîá äîäàòè ô³ëüì");
		System.out.println("Ââåä³òü 14 äëÿ òîãî, ùîá âèäàëèòè ô³ëüì");
		System.out.println("Ââåä³òü 15 äëÿ òîãî, ùîá âèâåñòè âñ³ ô³ëüìè");
		System.out.println("Ââåä³òü 16 äëÿ òîãî, ùîá äîäàòè ñåàíñ");
		System.out.println("Ââåä³òü 17 äëÿ òîãî, ùîá âèäàëèòè ñåàíñ");
		System.out.println("Ââåä³òü 18 äëÿ òîãî, ùîá âèâåñòè ñïèñîê ñåàíñ³â íà äåíü");
		System.out.println("Ââåä³òü 19 äëÿ òîãî, ùîá âèâåñòè ðîçêëàä");
		System.out.println("Ââåä³òü 0 äëÿ òîãî, ùîá âèéòè");

		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Çðîá³òü Âàø âèá³ð: ");
		int menuChoise = scanner.nextInt();

		return menuChoise;
	}

	public static void main(String[] args) throws Exception {
		Cinema cinema = null;
		Days days;
		Schedule schedule;

		while (true) {
			switch (menu()) {

			case 10: {
				cinema = Cinema.inputCinema();
				break;
			}

			case 11: {
				SerializeMethods.serialize(cinema, new File("Cinema.txt"));
				System.out.println("Ê³íîòåàòð \"" + cinema.getName() + "\" óñï³øíî çáåðåæåíî â ôàéë!\n");
				break;
			}

			case 12: {
				cinema = (Cinema) SerializeMethods.deserialize(new File("Cinema.txt"));
				System.out.println("Ê³íîòåàòð \"" + cinema.getName() + "\" óñï³øíî çàâàíòàæåíèé ç ôàéëó!\n");
				break;
			}

			case 13: {
				cinema.addMovie();
				break;
			}

			case 14: {
				Movie movie = Movie.inputMovie();
				cinema.removeMovie(movie);
				break;
			}

			case 15: {
				cinema.printAllMovie();
				break;
			}

			case 16: {
				System.out.println("Ââåä³òü äåíü äëÿ ñåàíñó:");
				days = Days.inputDay();
				Movie movie = Movie.inputMovie();
				cinema.addSeance(movie, days);
				break;
			}
			case 17: {
				System.out.println("Ââåä³òü äåíü ñåàíñó, ÿêèé ïîòð³áíî âèäàëèòè");
				days = Days.inputDay();
				for (Days day1 : Days.values()) {
					if (day1.name().equals(days.name().toUpperCase())) {
						cinema.removeSeance(day1);
					}
				}
				break;
			}

			case 18: {
				Days day = Days.inputDay();
				System.out.println("Âèâîäèìî ðîçêëàä ñåàíñ³â íà " + day.name());
				schedule = cinema.getScheduleMap().get(day);
				cinema.getSchedule(schedule);
				break;
			}

			case 19: {
				for (Days day1 : Days.values()) {
					System.out.println();
					System.out.println(day1.name());
					schedule = cinema.getScheduleMap().get(day1);
					cinema.getSchedule(schedule);
				}
				break;
			}

			case 0: {
				System.out.println("Äÿêóºìî, ùî ñêîðèñòàëèñÿ íàøèì ê³íîòåàòðîì. Âñüîãî íàéêðàùîãî\n");
				System.exit(0);
				break;
			}

			default: {
				System.out.println("Òàêèé ïóíêò â ìåíþ â³äñóòí³é!");
				break;
			}
			}
		}
	}
}