import java.util.*;
import java.io.*;

public class Main {

    // 0: 위, 1: 왼쪽, 2: 앞, 3: 오른쪽, 4: 뒤, 5: 아래
    private static char[][][] cube = new char[6][3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            init();
            int N = Integer.parseInt(br.readLine());
            String[] command = br.readLine().split(" ");
            for (String c:command) {
                char[] curCommand = c.toCharArray();
                rotation(curCommand);
            }
            print();
        }
    }

    private static void rotation(char[] command) {
        if (command[0]=='U') {
            rotationTop();
            if (command[1]=='-') {
                rotationTop();
                rotationTop();
            }
        } else if (command[0]=='L') {
            rotationLeft();
            if (command[1]=='-') {
                rotationLeft();
                rotationLeft();
            }
        } else if (command[0]=='F') {
            rotationFront();
            if (command[1]=='-') {
                rotationFront();
                rotationFront();
            }
        } else if (command[0]=='R') {
            rotationRight();
            if (command[1]=='-') {
                rotationRight();
                rotationRight();
            }
        } else if (command[0]=='B') {
            rotationBack();
            if (command[1]=='-') {
                rotationBack();
                rotationBack();
            }
        } else if (command[0]=='D') {
            rotationBottom();
            if (command[1]=='-') {
                rotationBottom();
                rotationBottom();
            }
        }
    }

    private static void rotationTop() {
        rightRotation(0);
        char[][] temp = new char[][]{cube[4][0], cube[3][0], cube[2][0], cube[1][0]};
        cube[4][0] = temp[3];
        cube[3][0] = temp[0];
        cube[2][0] = temp[1];
        cube[1][0] = temp[2];
    }

    private static void rotationLeft() {
        rightRotation(1);
        char[] temp1 = new char[]{cube[0][0][0], cube[0][1][0], cube[0][2][0]}; // 위의 왼쪽
        char[] temp2 = new char[]{cube[2][0][0], cube[2][1][0], cube[2][2][0]}; // 앞의 왼쪽
        char[] temp3 = new char[]{cube[5][0][2], cube[5][1][2], cube[5][2][2]}; // 밑의 오른쪽
        char[] temp4 = new char[]{cube[4][0][2], cube[4][1][2], cube[4][2][2]}; // 뒤의 오른쪽
        cube[0][0][0] = temp4[2]; cube[0][1][0] = temp4[1]; cube[0][2][0] = temp4[0]; // 위에 뒤
        cube[2][0][0] = temp1[0]; cube[2][1][0] = temp1[1]; cube[2][2][0] = temp1[2]; // 앞에 위
        cube[5][0][2] = temp2[2]; cube[5][1][2] = temp2[1]; cube[5][2][2] = temp2[0]; // 밑에 앞
        cube[4][0][2] = temp3[0]; cube[4][1][2] = temp3[1]; cube[4][2][2] = temp3[2]; // 뒤에 밑
    }

    private static void rotationFront() {
        rightRotation(2);
        char[] temp1 = new char[]{cube[0][2][0], cube[0][2][1], cube[0][2][2]}; // 위의 밑
        char[] temp2 = new char[]{cube[1][0][2], cube[1][1][2], cube[1][2][2]}; // 왼쪽의 오른쪽
        char[] temp3 = new char[]{cube[5][2][0], cube[5][2][1], cube[5][2][2]}; // 밑의 밑
        char[] temp4 = new char[]{cube[3][0][0], cube[3][1][0], cube[3][2][0]}; // 오른쪽의 왼쪽
        cube[0][2][0] = temp2[2]; cube[0][2][1] = temp2[1]; cube[0][2][2] = temp2[0];
        cube[1][0][2] = temp3[2]; cube[1][1][2] = temp3[1]; cube[1][2][2] = temp3[0];
        cube[5][2][0] = temp4[0]; cube[5][2][1] = temp4[1]; cube[5][2][2] = temp4[2];
        cube[3][0][0] = temp1[0]; cube[3][1][0] = temp1[1]; cube[3][2][0] = temp1[2];
    }

    private static void rotationRight() {
        rightRotation(3);
        char[] temp1 = new char[]{cube[2][0][2], cube[2][1][2], cube[2][2][2]}; // 앞의 오른쪽
        char[] temp2 = new char[]{cube[0][0][2], cube[0][1][2], cube[0][2][2]}; // 위의 오른쪽
        char[] temp3 = new char[]{cube[5][0][0], cube[5][1][0], cube[5][2][0]}; // 밑의 왼쪽
        char[] temp4 = new char[]{cube[4][0][0], cube[4][1][0], cube[4][2][0]}; // 뒤의 왼쪽
        cube[0][0][2] = temp1[0]; cube[0][1][2] = temp1[1]; cube[0][2][2] = temp1[2]; // 위에 앞
        cube[2][0][2] = temp3[2]; cube[2][1][2] = temp3[1]; cube[2][2][2] = temp3[0]; // 앞에 밑
        cube[5][0][0] = temp4[0]; cube[5][1][0] = temp4[1]; cube[5][2][0] = temp4[2]; // 밑에 뒤
        cube[4][0][0] = temp2[2]; cube[4][1][0] = temp2[1]; cube[4][2][0] = temp2[0]; // 뒤에 위
    }

    private static void rotationBack() {
        rightRotation(4);
        char[] temp1 = new char[]{cube[0][0][0], cube[0][0][1], cube[0][0][2]}; // 위의 위
        char[] temp2 = new char[]{cube[3][0][2], cube[3][1][2], cube[3][2][2]}; // 오의 오른쪽
        char[] temp3 = new char[]{cube[5][0][0], cube[5][0][1], cube[5][0][2]}; // 밑의 위
        char[] temp4 = new char[]{cube[1][0][0], cube[1][1][0], cube[1][2][0]}; // 왼의 왼쪽
        cube[0][0][0] = temp2[0]; cube[0][0][1] = temp2[1]; cube[0][0][2] = temp2[2];
        cube[3][0][2] = temp3[0]; cube[3][1][2] = temp3[1]; cube[3][2][2] = temp3[2];
        cube[5][0][0] = temp4[2]; cube[5][0][1] = temp4[1]; cube[5][0][2] = temp4[0];
        cube[1][0][0] = temp1[2]; cube[1][1][0] = temp1[1]; cube[1][2][0] = temp1[0];
    }

    private static void rotationBottom() {
        rightRotation(5);
        char[][] temp = new char[][]{cube[4][2], cube[1][2], cube[2][2], cube[3][2]}; // 뒤 왼 앞 오
        cube[4][2] = temp[3];
        cube[1][2] = temp[0];
        cube[2][2] = temp[1];
        cube[3][2] = temp[2];
    }

    /**
     * n번 면을 오른쪽으로 돌리기
     */
    private static void rightRotation(int n) {
        char[][] temp = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[j][3 - 1 - i] = cube[n][i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[n][i][j] = temp[i][j];
            }
        }
    }

    /**
     * 제일 윗면 출력
     */
    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(cube[0][i][j]);
            }
            if (i != 2)
                sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void init() {
        char[] color = new char[]{'w', 'g', 'r', 'b', 'o', 'y'};
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(cube[i][j], color[i]);
            }
        }
    }

}