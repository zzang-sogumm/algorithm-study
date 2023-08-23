import java.util.Scanner;

public class BOJ4396 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        size = scanner.nextInt();

        char[][] landmine = new char[size][size]; //지뢰찾기 판
        char[][] open = new char[size][size]; //입력한 정답 
        char[][] ans = new char[size][size];  //최종 출력판
        for(int i=0; i<size; i++){
            String l_temp = scanner.next();
            for(int j=0; j<size; j++){
                landmine[i][j] = l_temp.charAt(j);
            }
        }                                                       //지뢰 입력


        for(int i=0; i<size; i++){
            String o_temp = scanner.next();
            for(int j=0; j<size; j++){
                open[i][j] = o_temp.charAt(j);
            }
        }                                                      //정답 입력

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                ans[i][j] = '.';
            }
        }                                                       //최종출력판 .으로 초기화

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                int cnt = 0;
                if(open[i][j]== 'x'){
                    if(landmine[i][j] == '.'){
                        if(i<size-1 && j<size-1){if(landmine[i+1][j+1] == '*'){cnt=cnt+1;}}
                        if(i<size-1 && j>0){if(landmine[i+1][j-1] == '*'){cnt=cnt+1;}}
                        if(j<size-1 && i>0){if(landmine[i-1][j+1] == '*'){cnt=cnt+1;}}                                                
                        if(i>0 && j>0){if(landmine[i-1][j-1] == '*'){cnt=cnt+1;}}
                        if(i<size-1){if(landmine[i+1][j] == '*'){cnt = cnt+1;}}
                        if(j<size-1){if(landmine[i][j+1] == '*'){cnt = cnt+1;}}
                        if(i>0){if(landmine[i-1][j] == '*'){cnt = cnt+1;}}
                        if(j>0){if(landmine[i][j-1] == '*'){cnt = cnt+1;}}
                    }
                    ans[i][j] = (char)(cnt+'0');                                           //주변 탐색 후 cnt 증가                   
                
                
                if(landmine[i][j] == '*'){for(int x=0; x<size; x++){
                        for(int y=0;y<size;y++){
                            if(landmine[x][y] == '*'){ans[x][y] = '*';}
                        }
                    }            ;}                                 //지뢰 발견시 지뢰 표시
                 
                }
            }
        }

            
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }      

        scanner.close();
    }
}