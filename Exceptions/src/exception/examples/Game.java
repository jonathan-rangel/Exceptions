package exception.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {

    private static final String FORMAT_FOR_DATES = "yyyy/MM/dd HH:mm:ss";
    private static final String FILE_NAME_SCORE = "Score.txt";
    private static final String FILE_NAME_PROGRESS = "Progress.txt";
    private static final String FILE_NAME_STATISTICS = "Statistics.txt";


    public void saveGame(){
        try {
            saveProgress();
            saveScore();
            saveStatistics();
        }
        catch (SaveProgressException ex)
        {
            System.err.println("Can't save progress" + ex.getMessage());
        }
        catch (SaveScoreException ex)
        {
            System.err.println("Can't save score" + ex.getMessage());
        }
        catch (SaveStatisticsException ex)
        {
            System.err.println("Can't save statistics" + ex.getMessage());
        }
    }

    private void saveStatistics() throws SaveStatisticsException {
        FileWriter writer = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);
            writer = new FileWriter(FILE_NAME_STATISTICS, true);
            writer.append("Guardado:").append(now.format(formatter)).append(System.lineSeparator());
            writer.close();

        } catch (IOException e) {
            throw new SaveStatisticsException();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private void saveScore() throws SaveScoreException {
        FileWriter writer = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);
            writer = new FileWriter(FILE_NAME_SCORE, true);
            writer.append("Guardado:").append(now.format(formatter)).append(System.lineSeparator());
            writer.close();

        } catch (IOException e) {
            throw new SaveScoreException();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private void saveProgress() throws SaveProgressException {
        FileWriter writer = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);
            writer = new FileWriter(FILE_NAME_PROGRESS, true);
            writer.append("Guardado:").append(now.format(formatter)).append(System.lineSeparator());
            writer.close();

        } catch (IOException e){
            throw new SaveProgressException();
        }
        finally
        {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
