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
            ex.printStackTrace();
        }
        catch (SaveStatisticsException ex)
        {
            System.err.println("Can't save statistics" + ex.getMessage());
        }
    }

    private void saveStatistics() throws SaveStatisticsException {
        try(FileWriter writer = new FileWriter(FILE_NAME_STATISTICS, true);)
        {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);

            writer.append("Guardado:").append(now.format(formatter)).append(System.lineSeparator());

        } catch (IOException e)
        {
            throw new SaveStatisticsException();
        }
    }

    private void saveScore() throws SaveScoreException {
        try(FileWriter writer = new FileWriter(FILE_NAME_SCORE, true);)
        {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);


            writer.append("Guardado:").append(now.format(formatter)).append(System.lineSeparator());

            throw new IOException("IO exception de prueba");

        } catch (IOException e)
        {
            throw new SaveScoreException("El mensaje", e);
        }
    }

    private void saveProgress() throws SaveProgressException {
        try(FileWriter writer = new FileWriter(FILE_NAME_PROGRESS, true);
)       {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_FOR_DATES);
            writer.append("Guardado:").append(now.format(formatter)).append(System.lineSeparator());

        } catch (IOException e)
        {
            throw new SaveProgressException();
        }
    }
}
