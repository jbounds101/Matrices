public class Main {
    public static void main(String[] args) {
        Matrix ag = multiply(new Matrix(new double[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12},
                {13}, {14}, {15}, {16},
        }));
    }

    public static Matrix multiply(Matrix v) {
        if (v.getM() == 1) {
            return v;
        }

        double[][] vTopData = new double[v.getM() / 2][1];
        double[][] vBotData = new double[v.getM() / 2][1];
        double[][] vData = v.getData();


        int j = v.getM() / 2;
        for (int i = 0; i < v.getM() / 2; i++) {
            vTopData[i][0] = vData[i][0];
            vBotData[i][0] = vData[j][0];
            j++;
        }

        Matrix vTop = new Matrix(vTopData);
        Matrix vBot = new Matrix(vBotData);

        Matrix subTop = multiply(vTop);
        Matrix subBot = multiply(vBot);

        double[][] retData = new double[v.getM()][1];
        for (int i = 0; i < v.getM() / 2; i++) {
            retData[i][0] = subTop.getData()[i][0] - subBot.getData()[i][0];
            retData[i + v.getM()/2][0] = (3 * subTop.getData()[i][0]) + subBot.getData()[subBot.getM() - i - 1][0];
        }

        return new Matrix(retData);
    }
}