import java.util.Scanner;
public class BOJ2578 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);
        int[][] bingo = new int[5][5]; //철수의 빙고
        int[][] ans = new int[5][5]; //사회자의 정답 빙고
        int line = 0, say=0;                // 빙고 갯수 카운트

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                bingo[i][j] = scanner.nextInt();
            }
        }                                               //이중배열로 철수 빙고 생성

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                ans[i][j] = scanner.nextInt();
            }
        }                                               //이중배열로 사회자 정답 빙고 생성


        for(int x=0; x<5; x++){
            for(int y=0; y<5; y++){
                for(int i=0; i<5; i++){
                    for(int j=0; j<5; j++){
                      if(bingo[i][j] == ans[x][y]){
                        bingo[i][j] = 0;
                      }
                                                                         //4중배열을 통한 빙고 체크, 체크 후 해당자리 0으로 변환\

                      if(line<3){
                        line = 0;
                        for(int q=0; q<5; q++){
                            if(bingo[q][0]==0){
                                if(bingo[q][1]==0){
                                    if(bingo[q][2]==0){
                                        if(bingo[q][3]==0){
                                            if(bingo[q][4]==0){
                                                line = line + 1;           //행에 대한 빙고 자리 0 체크 후 해당 열이 빙고인 경우 라인+1
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        for(int w=0; w<5; w++){
                            if(bingo[0][w]==0){
                                if(bingo[1][w]==0){
                                    if(bingo[2][w]==0){
                                        if(bingo[3][w]==0){
                                            if(bingo[4][w]==0){
                                                line = line + 1;          //열에 대한 빙고 자리 0 체크 후 해당 열이 빙고인 경우 라인+1                                                                                          
                                            }
                                        }
                                    }
                                }
                            }
                        }
  
                            if(bingo[0][0]==0){
                                if(bingo[1][1]==0){
                                    if(bingo[2][2]==0){
                                        if(bingo[3][3]==0){
                                            if(bingo[4][4]==0){
                                                line = line + 1;          //대각 빙고 자리 0 체크 후 해당 열이 빙고인 경우 라인+1                                                                                     
                                            }
                                        }
                                    }
                                }
                            }

                            if(bingo[0][4]==0){
                                if(bingo[1][3]==0){
                                    if(bingo[2][2]==0){
                                        if(bingo[3][1]==0){
                                            if(bingo[4][0]==0){
                                                line = line + 1;          //대각 빙고 자리 0 체크 후 해당 열이 빙고인 경우 라인+1                                            
                                            }
                                        }
                                    }
                                }
                            }      
                        }                      
                                            
                            

                      if(line>2){
                        say = (x*5)+(y+1);                               //행,열 연산으로 사회자의 번호 체크
                        break;
                    }
                    if(line>2){break;}}
                    
                if(line>2){break;}}
                
            if(line>2){break;}}
            
        if(line>2){break;}}
        
        System.out.println(say);

        scanner.close();
    }
}