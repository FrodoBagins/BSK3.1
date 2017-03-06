/**
 * Created by Kamil_2 on 2017-03-01.
 */
public class Main {

    public static void main(String [] args){

      //  Main szyfr = new Main();

        Drugi szyfr = new Drugi();


        String ciphered = szyfr.PrzestawieniowyJedenSzyfruj("CONVENIENCE","HERE IS A SECRET MESSAGE ENCIPHERED BY TRANSPOSITION");

        System.out.println(ciphered);


        szyfr.PrzestawieniwyJedenDeszyfruj("CONVENIENCE","HEESPNIRRSSEESEIYASCBTEMGEPNANDICTRTAHSOIEERO");



    }


    public String PrzestawieniowyJedenSzyfruj(String key,String clearText){


        //Utworzenie klucza
        int count=0;
        int[] klucz= new int[key.length()];

        for(char let='A';let<='Z';++let) {

            for(int i=0;i<key.length();++i){

                if(key.charAt(i)==let) {
                    klucz[i] =  count;
                    ++count;
                }
            }
        }

        // Wyznaczenie liczby wierszy
        int rows = clearText.length() / key.length();

        if( (clearText.length() % key.length())>0)
            rows = rows + 1;


        char[][] kodowanie = new char[rows][key.length()];

        for(int i = 0; i<rows;i++)
        {
            for(int j=0;j<key.length();++j)
                kodowanie[i][j]=' ';
        }



        int count2=0;


        // Uzupełnienie tabliczy słowem do zaszyfrowania
        for(int i=0;i<rows;++i){

            for(int j=0; j < key.length(); ++j){

                if(count2<clearText.length())
                {
                    if(clearText.charAt(count2)==' ')
                        ++count2;
                    kodowanie[i][j]= clearText.charAt(count2);
                    ++count2;
                }
            }
            System.out.println(kodowanie[i]);
        }

        String codedword="";


        int number=0;

        //Odczytanie kolumn do zakodowania według klucza
        for(int i=0;i<key.length(); ++i) {

            for(int k=0;k<key.length();++k){
                if(klucz[k]==i)
                    number=k;
            }

            for (int j = 0; j < rows; ++j) {
                if(kodowanie[j][number]!=' ')
                codedword = codedword + kodowanie[j][number];
            }
        }
        return codedword;
    }



    public String PrzestawieniwyJedenDeszyfruj(String key,String zaszyfrowane){


        //Utworzenie klucza
        int count=0;
        int[] klucz= new int[key.length()];

        for(char let='A';let<='Z';++let) {

            for(int i=0;i<key.length();++i){

                if(key.charAt(i)==let) {
                    klucz[i] =  count;
                    ++count;
                }
            }
        }



        int rows = zaszyfrowane.length() / key.length();

        if( (zaszyfrowane.length() % key.length())>0)
            rows = rows + 1;

        int longercolumns=0;

        if(rows!=zaszyfrowane.length()/key.length())
           longercolumns=zaszyfrowane.length() - ((rows-1)*key.length());

        System.out.println("Longer column"+longercolumns);

        System.out.println(klucz[1]);


        System.out.println("Key lenght"+key.length());
        System.out.println("Rows:"+rows);

        char[][] kodowanie = new char[rows][key.length()];
        int actualrows=0;
        int letterindex=0;

        for(int i=0;i<key.length();++i)
        {

            for(int j=0;j<key.length();++j)
            {

                if(klucz[j]==i)
                {
                    if(j<longercolumns || longercolumns==0)
                        actualrows=rows;
                    else
                        actualrows=rows-1;

                    for(int u=0;u<actualrows;++u)
                    {
                        kodowanie[u][j]=zaszyfrowane.charAt(letterindex);

                        ++letterindex;

                    }//Trzeci for
                }//Pierszy if
            }//Drugi for
        }//Pierwszy for


        System.out.println(kodowanie[0]);
        System.out.println(kodowanie[1]);
        System.out.println(kodowanie[2]);
        System.out.println(kodowanie[3]);
//        System.out.println(kodowanie[4]);


        String answer="";

        for(int i=0;i<rows;++i)
        {
            for(int j=0;j<key.length();++j)
                answer=answer+kodowanie[i][j];
        }

       System.out.println(answer);

        return answer;
    }

}
