package Square;

public class SquareRoot {
    public int squareRoot(int radicand) {
        int num = 0;
        while (num * num < radicand) {
            num++;
        }
        return num;
    }
}
