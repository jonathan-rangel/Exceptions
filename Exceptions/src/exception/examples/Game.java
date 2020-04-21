package exception.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {


    public void saveGame(){
        try {
            saveProgress();
        } catch (SaveProgressException ex) {
            System.err.println("Can't save progress" + ex.getMessage());
        }
        try {
            saveScore();
        } catch (SaveScoreException ex) {
            System.err.println("Can't save score" + ex.getMessage());

        }
        try {
            saveStatistics();
        } catch (SaveStatisticsException ex) {
            System.err.println("Can't save statistics" + ex.getMessage());

        }
    }

    private void saveStatistics() throws SaveStatisticsException {
        FileWriter writer = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            writer = new FileWriter("Statistics.txt", true);
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            writer = new FileWriter("Score.txt", true);
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            writer = new FileWriter("Progress.txt", true);
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
