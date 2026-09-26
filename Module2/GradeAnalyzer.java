import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {
    
    public static void main(String[] args) {
        // Step 1: read scores from file
        String filename = "scores.txt";
        ArrayList<Integer> scores = readScores(filename);
        String reportFilename = "report.txt";
        // Step 2: calculate statistics
        double average = calculateAverage(scores);
        int highest = Integer.MIN_VALUE;
        int lowest  = Integer.MAX_VALUE;
        int countA=0, countB=0, countC=0, countD=0, countF=0;
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            
            if (score < lowest) {
                lowest = score;
            }

            if (score >= 90) {
                countA++;
            } else if ((score >= 80) && (score <= 89)) {
                countB++;
            } else if ((score >= 70) && (score <= 79)) {
                countC++;
            } else if ((score >= 60) && (score <= 69)) {
                countD++;
            } else if (score < 60) {
                countF++;
            }
        }
        // Step 3: write and print report
        writeReport(scores, average, highest, lowest, countA, countB, countC, countD, countF, reportFilename);

    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int score;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    score = Integer.parseInt(line.trim());
                    scores.add(score);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()){
            return 0.0;
        }

        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   int countA, int countB, int countC, int countD, int countF,
                                   String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("=== Grade Analysis Report ===\n");

            writer.write(String.format("Total scores processed:     %d%n", scores.size()));
            writer.write(String.format("Average score:     %.2f%n", avg));
            writer.write(String.format("Highest score:     %d%n", high));
            writer.write(String.format("Lowest  score:     %d%n%n", low));

            writer.write("Grade distribution:\n");
            writer.write(String.format("  A (90-100):    %d%n", countA));
            writer.write(String.format("  B (80-89):     %d%n", countB));
            writer.write(String.format("  C (70-79):     %d%n", countC));
            writer.write(String.format("  D (60-69):     %d%n", countD));
            writer.write(String.format("  F (below 60):  %d%n", countF));
            if (scores.size() > 0) {
                System.out.println("=== Grade Analysis Report ===");
                System.out.println(String.format("Total scores processed:     %d", scores.size()));
                System.out.println(String.format("Average score:     %.2f", avg));
                System.out.println(String.format("Highest score:     %d", high));
                System.out.println(String.format("Lowest  score:     %d%n", low));

                System.out.println("Grade distribution:");
                System.out.println(String.format("  A (90-100):    %d", countA));
                System.out.println(String.format("  B (80-89):     %d", countB));
                System.out.println(String.format("  C (70-79):     %d", countC));
                System.out.println(String.format("  D (60-69):     %d", countD));
                System.out.println(String.format("  F (below 60):  %d", countF));
            } else {
                System.out.println("Grade Analysis Report could not be generated.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error while writing file: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error while writing file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while writing file: " + e.getMessage());
        } 
    }
}
