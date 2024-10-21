import java.util.*;

class Solution {
    private int[][] locker;
    private int N, M;
    
    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length; M = key.length;
        
        locker = new int[N+2*(M-1)][N+2*(M-1)];
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                locker[i+M-1][j+M-1] = lock[i][j];
            }
        }
        
        // 4방향 회전을 하면서 이동 검사
        for (int r = 0; r < 4; r++) {
            key = rotation(key);
            for (int x=0; x<=N+M-2; x++) {
                for (int y=0; y<=N+M-2; y++) {
                    if (isOpen(x, y, key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    // 키를 자물쇠에 맞추어 보는 함수
    private boolean isOpen(int startX, int startY, int[][] key) {
        int[][] tempLock = copy(locker);
        
        for (int i=0; i<M; i++) {
            for (int j=0; j<M; j++) {
                tempLock[startX + i][startY + j] += key[i][j];
            }
        }
        
        // 자물쇠 부분이 완전히 1로 채워져 있는지 확인
        for (int i=M-1;i<N+M-1; i++) {
            for (int j=M-1; j<N+M-1; j++) {
                if (tempLock[i][j] != 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    

    private int[][] rotation(int[][] array) {
        int[][] afterArray = new int[M][M];
        for (int i=M-1,k=0; i>=0 && k<M; i--, k++) {
            for (int j=0;j<M; j++) {
                afterArray[j][k] = array[i][j];
            }
        }
        return afterArray;
    }
    
    private int[][] copy(int[][] array) {
        int size = array.length;
        int[][] newArray = new int[size][size];
        for (int i=0; i<size; i++) {
            newArray[i] = Arrays.copyOf(array[i], size);
        }
        return newArray;
    }
}
