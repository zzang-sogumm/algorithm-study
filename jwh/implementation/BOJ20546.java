import java.util.Scanner;
public class BOJ20546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int jun=0, sung =0, day=0, junhave=0, sunghave=0, Tcheck =0;//준현, 성민, 날짜 초기화
        int[] juga = new int[14];  //주가 배열 선언


        int Money = scanner.nextInt(); 
        jun = Money;
        sung = Money;    //자금 초기화 및 입력


         for(int i =0; i<14; i++){
        day = scanner.nextInt();
        juga[i] = day;
        }                         // 주가 입력


        for(int j =0; j<14; j++){
            
         if(jun>=juga[j]){
            int junbuy=0; 
            junbuy = (jun/juga[j]);
            junhave = junhave + junbuy;
            jun = jun - (junbuy*juga[j]);
            }
        
        }
        jun = jun +(junhave*juga[13]);
         
                                      //준현 알고리즘

 
     for(int k =0; k<14; k++){
        if(k>3){
         if(juga[k-1]<juga[k]){
            if(juga[k-2]<juga[k-1]){
                if(juga[k-3]<juga[k-2]){
                    Tcheck = Tcheck+3;}
                }
            }
         if(juga[k-1]>juga[k]){
            if(juga[k-2]>juga[k-1]){
                if(juga[k-3]>juga[k-2]){
                    Tcheck = Tcheck-3;}
                }
            }
         if(juga[k-1]==juga[k]){Tcheck = 0;}
        }                                         // D-3일, D-2일, D-1일 비교하여 .Tcheck에 상승, 하락을 기록

         if(Tcheck>2){
            int sungsell=0;
            if(sunghave>0){
                sungsell = (sunghave*juga[k]);
                sung = sung + sungsell;
                sunghave = 0;
               }
            }                                      //상승장일경우, 성민이가 갖고있는 주식 전량 판매
     
         if(sung>juga[k]){
            int sungbuy=0; 
            if(Tcheck<-2){
                sungbuy = (sung/juga[k]);
                sunghave = sunghave + sungbuy;
                sung = sung - (sungbuy*juga[k]);
                } 
         }                                          // 성민이가 주가보다 많이 갖고있다는 전제 및 하락장이라는 전제 하, 준현 구매 알고리즘과 동일.
/*
            System.out.println("일자 체크="+k);
            System.out.println("상승,하락 체크="+Tcheck);
            System.out.println("성민이의 재산" + sung);
            System.out.println("성민이의 주식" + sunghave);
*/
            if(Tcheck>2){Tcheck = 0;}
            if(Tcheck<-2){Tcheck = 0;}   //상승, 하락 후 초기화

        } 
        sung = sung + (sunghave*juga[13]);
                                      //성민 알고리즘
/*
        System.out.println("준현이의 재산" + jun);
        System.out.println("성민이의 재산" + sung);
 */

        if(jun > sung) System.out.println("BNP");
        if(sung > jun) System.out.println("TIMING");
        if(jun == sung) System.out.println("SAMESAME");

        scanner.close();
    }
}
