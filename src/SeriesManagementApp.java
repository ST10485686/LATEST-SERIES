import java.util.ArrayList;
import java.util.Scanner;

public class SeriesManagementApp {
    // ArrayList to store series data
    private static ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcomeMessage();
        launchMainMenu();
    }

    private static void displayWelcomeMessage() {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("*******************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String input = scanner.nextLine();

        if (!input.equals("1")) {
            System.out.println("Exiting application...");
            System.exit(0);
        }
    }

    private static void launchMainMenu() {
        while (true) {
            displayMenuOptions();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    captureNewSeries();
                    break;
                case "2":
                    searchForSeries();
                    break;
                case "3":
                    updateAgeRestriction();
                    break;
                case "4":
                    deleteSeries();
                    break;
                case "5":
                    printSeriesReport();
                    break;
                case "6":
                    System.out.println("Exiting application...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenuOptions() {
        System.out.println("\nPlease select one of the following menu items:");
        System.out.println("(1) Capture a new series.");
        System.out.println("(2) Search for a series.");
        System.out.println("(3) Update series age restriction");
        System.out.println("(4) Delete a series.");
        System.out.println("(5) Print series report - 2025");
        System.out.println("(6) Exit Application.");
        System.out.print("Enter your choice: ");
    }

    private static void captureNewSeries() {
        System.out.println("\n--- Capture A New Series ---");
        System.out.print("********************************");

        SeriesModel series = new SeriesModel();

        System.out.print("Enter the series Id : 101 ");
        series.setSeriesId(scanner.nextLine());

        System.out.print("Enter the series name : Extreme Sports ");
        series.setSeriesName(scanner.nextLine());

        System.out.print("Enter the series age restriction: 12 ");
        series.setSeriesAge(scanner.nextLine());

        System.out.print("Enter the number of episodes for Extreme Sports:10 ");
        series.setSeriesNumberOfEpisodes(scanner.nextLine());

        seriesList.add(series);
        System.out.println("Series processed successfully!!!");
    }

    private static void searchForSeries() {
        System.out.println("\n--- Search for Series ---");
        System.out.print("Enter series id or name to search: ");
        String searchTerm = scanner.nextLine();

        boolean found = false;
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equalsIgnoreCase(searchTerm) ||
                    series.getSeriesName().equalsIgnoreCase(searchTerm)) {
                displaySeriesDetails(series);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No series found matching your search.");
        }
    }

    private static void updateAgeRestriction() {
        System.out.println("\n--- Update Age Restriction ---");
        System.out.print("Enter Series id to update: ");
        String seriesId = scanner.nextLine();

        boolean found = false;
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equalsIgnoreCase(seriesId)) {
                System.out.print("Enter new Age Restriction: ");
                series.setSeriesAge(scanner.nextLine());
                System.out.println("Age restriction updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Series was not found with Id: " + seriesId);
        }
    }

    private static void deleteSeries() {
        System.out.println("\n--- Delete Series ---");
        System.out.print("Enter series id to delete: 101 ");
        String seriesId = scanner.nextLine();
        System.out.println("Are you sure you want to delete series 101 from the system? Yes(y) to delete. ");

        boolean removed = false;
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesId().equalsIgnoreCase(seriesId)) {
                seriesList.remove(i);
                System.out.println("Series deleted successfully!");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Series not found with ID: " + seriesId);
        }
    }

    private static void printSeriesReport() {
        System.out.println("\n--- Series Report 2025 ---");
        System.out.println("Total Series: " + seriesList.size());
        System.out.println("--------------------------");

        for (SeriesModel series : seriesList) {
            displaySeriesDetails(series);
            System.out.println("--------------------------");
        }
    }

    private static void displaySeriesDetails(SeriesModel series) {
        System.out.println("Series ID: " + series.getSeriesId());
        System.out.println("Series Name: " + series.getSeriesName());
        System.out.println("Age Restriction: " + series.getSeriesAge());
        System.out.println("Number of Episodes: " + series.getSeriesNumberOfEpisodes());
    }
}

class SeriesModel {
    private String SeriesId;
    private String SeriesName;
    private String SeriesAge;
    private String SeriesNumberOfEpisodes;

    // Getters and Setters
    public String getSeriesId() {
        return SeriesId;
    }

    public void setSeriesId(String seriesId) {
        SeriesId = seriesId;
    }

    public String getSeriesName() {
        return SeriesName;
    }

    public void setSeriesName(String seriesName) {
        SeriesName = seriesName;
    }

    public String getSeriesAge() {
        return SeriesAge;
    }

    public void setSeriesAge(String seriesAge) {
        SeriesAge = seriesAge;
    }

    public String getSeriesNumberOfEpisodes() {
        return SeriesNumberOfEpisodes;
    }

    public void setSeriesNumberOfEpisodes(String seriesNumberOfEpisodes) {
        SeriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }
}