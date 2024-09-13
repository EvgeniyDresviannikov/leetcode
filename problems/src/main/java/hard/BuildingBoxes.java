package hard;

public class BuildingBoxes {

    public static void main(String[] args) {
        System.out.println(new BuildingBoxes().minimumBoxes(2));
    }

    public int minimumBoxes(int n) {
        int prevLayerCnt = 1;
        int curCnt = 1;
        int level = 2;

        while (curCnt + level + prevLayerCnt <= n) {
            curCnt += level + prevLayerCnt;
            prevLayerCnt += level;
            level++;
        }

        int base = prevLayerCnt;

        int rest = 0;

        while (curCnt < n) {
            rest++;
            curCnt += rest;
        }

        return base + rest;
    }
}
