import java.util.*;
public class Main {
    public static void main(String[] args) {
        meny();
        Falt();
    }

    public static void meny() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Buss meny:\n1.Boka en plats\n2.Visa antal lediga platser\n3.Beräkna vinster av biljetter\n4.Avsluta program");
        boolean meny = true;
        while (meny) {

            boolean avslutameny = false;
            while (!avslutameny) {
                try{ int val = scan.nextInt();
                    scan.nextLine();
                if (val == 1) {
                    Bokaplats();
                    avslutameny=true;
                    meny=false;

                } else if (val == 2) {
                    Ledigaplatser();
                } else if (val == 3) {
                    Vinst();
                } else if (val == 4) {
                    meny = false;
                    avslutameny = true;
                    System.out.println("Programmet stängs, hej då");
                } else {
                    System.out.println("va? välj 1,2,3 eller 4.");
                }
                } catch (Exception e) {
                    System.out.println("skriv rätt. 1, 2, 3 eller 4.");
                    scan.nextLine();
                }
            }
        }
    }

    public static int[][] schema = new int[5][5];

    public static void Bokaplats() {
        Scanner scan = new Scanner(System.in);
        System.out.println("boka en plats\n1.Fönster Plats\n2.Första lediga plats");

        boolean end = false;
        while (!end) {
            try {
                int val = scan.nextInt();
                if (val==1){
                    for (int i = 0; i < 5 ; i++)
                    {
                        if (schema[i][0] == 0) {
                            System.out.println("Du har fått fönsterplats, fält [" + i + "] [0]");
                            schema[i][0] = 1;
                            end = true;
                            break;
                        } else if (schema[i][4] == 0) {
                            System.out.println("Du har fått fönster plats, fält [" + i + "] [4]");
                            schema[i][4] = 1;
                            end = true;
                            break;
                        }
                    }
                    if (!end) {
                        System.out.println("finns inga lediga fönster platser.");
                    }

                    end=true;

                    meny();
                } else if (val==2) {
                    for (int i = 0; i < 5; i++) {
                        if (schema[0][i]== 0){
                            System.out.println("Du har fått plats, fält [0]["+i+"]");
                            schema[0][i] = 1;
                            end = true;
                            break;
                        }
                        else if(schema[1][i]== 0) {
                            System.out.println("Du har fått plats, fält [1][" + i + "]");
                            schema[1][i] = 1;
                            end = true;
                            break;
                        }
                        else if(schema[3][i]== 0) {
                            System.out.println("Du har fått plats, fält [3][" + i + "]");
                            schema[3][i] = 1;
                            end = true;
                            break;
                        }
                        else if(schema[4][i]== 0) {
                            System.out.println("Du har fått plats, fält [4][" + i + "]");
                            schema[4][i] = 1;
                            end = true;
                            break;
                        }
                    }
                    if (!end){
                        System.out.println("Det finns inga lediga platser kvar.");
                    }
                    end = true;
                    meny();
                }

                else {
                    System.out.println("Skriv rätt, 1 eller 2.");
                }
            } catch (Exception e){
                System.out.println("Skriv rätt, 1 eller 2.");
                scan.nextLine();
            }
    }
    }
    public static void Ledigaplatser(){
        int summa = 0;
        for (int i = 0; i < schema.length; i++) {
            for (int j = 0; j < schema[i].length; j++) {
                summa +=schema[i][j];

            }
        }
        int platser=21-summa;
        System.out.println("Det Finns "+platser+" lediga platser");
        meny();
        }

    public static void Vinst(){
        int summa = 0;
        for (int i = 0; i < schema.length; i++) {
            for (int j = 0; j < schema[i].length; j++) {
                summa +=schema[i][j];

            }
        }
        double vinst=summa*299.90;
        System.out.println("Totala vinsten är "+vinst+"kr");
        meny();
    }
    public static void Falt(){
        schema[0][0] = 0;
        schema[1][0] = 0;
        schema[2][0] = 0;
        schema[3][0] = 0;
        schema[4][0] = 0;
        schema[0][1] = 0;
        schema[1][1] = 0;
        schema[2][1] = 0;
        schema[3][1] = 0;
        schema[4][1] = 0;
        schema[0][2] = 3;
        schema[1][2] = 3;
        schema[2][2] = 3;
        schema[3][2] = 3;
        schema[4][2] = 0;
        schema[0][3] = 0;
        schema[1][3] = 0;
        schema[2][3] = 0;
        schema[3][3] = 0;
        schema[4][3] = 0;
        schema[0][4] = 0;
        schema[1][4] = 0;
        schema[2][4] = 0;
        schema[3][4] = 0;
        schema[4][4] = 0;
    }

}
