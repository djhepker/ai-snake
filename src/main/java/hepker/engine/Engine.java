package hepker.engine;

import java.util.Random;

public class Engine {
    private String[][] sampleUI;

    public Engine() {
        renderSnake();
    }

    public void printMap() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sampleUI.length; i++) {
            for (int j = 0; j < sampleUI[i].length; j++) {
                sb.append(sampleUI[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private void renderSnake() {
        this.sampleUI = new String[7][7];
        for (int i = 0; i < sampleUI.length; i++) {
            for (int j = 0; j < sampleUI[i].length; j++) {
                if (i == 0 || j == 0 || i == sampleUI.length - 1 || j == sampleUI[i].length - 1) {
                    sampleUI[i][j] = "#";
                } else {
                    sampleUI[i][j] = " ";
                }
            }
        }
        sampleUI[sampleUI.length - 2][sampleUI[0].length - 2] = "S";
        Random rand = new Random(System.currentTimeMillis());
        int rewardX;
        int rewardY;
        do {
            rewardX = rand.nextInt(sampleUI.length - 2) + 1;
            rewardY = rand.nextInt(sampleUI[0].length - 2) + 1;
        } while (rewardX == sampleUI.length - 1 && rewardY == sampleUI[0].length - 1);
        sampleUI[rewardX][rewardY] = "R";
    }
}
