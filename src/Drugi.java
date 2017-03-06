/**
 * Created by Kamil_2 on 2017-03-06.
 */
public class Drugi {

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


        //licznik liter
        int lettercounter=0;

        //licznik wierszy
        int rows=0;

        //wspolrzedne dla kazdej litery
        int[][] position = new int[clearText.length()][2];


        System.out.println(klucz[3]);


        while(lettercounter<clearText.length())
        {

            for(int i=0;i<key.length();++i)
            {

                for(int u=0;u<key.length();++u)
                {

                    if(i==klucz[u])
                    {

                        for(int j=0;j<u+1;++j)
                        {

                            if(lettercounter>=clearText.length())
                                break;


                            while(clearText.charAt(lettercounter)==' ' && lettercounter<clearText.length())
                                ++lettercounter;


                           if(lettercounter<clearText.length())
                           {

                               position[lettercounter][0]=rows;
                               position[lettercounter][1]=j;
                               System.out.println("Rows: "+rows+" Columns: "+j+" Letter:"+lettercounter);
                               ++lettercounter;
                           }
                        }//
                        ++rows;
                    }
                }//drugi for
            }//pierwszy for
        }//konie while


        System.out.println(lettercounter);
        System.out.println(clearText.charAt(51));


        char[][] ciphertable = new char[rows][key.length()];

        for(int i = 0; i<rows;i++)
        {
            for(int j=0;j<key.length();++j)
                ciphertable[i][j]=' ';
        }


        for(int i=0;i<lettercounter;++i)
        {

            if(!(clearText.charAt(i)==' '))
                ciphertable[position[i][0]][position[i][1]]=clearText.charAt(i);
        }


        System.out.println(ciphertable[6]);

        int number=0;
        String codedword="";

        for(int i=0;i<key.length(); ++i) {

            for(int k=0;k<key.length();++k){
                if(klucz[k]==i)
                    number=k;
            }

            for (int j = 0; j < rows; ++j) {
                if(!(ciphertable[j][number]==' '))
                    codedword = codedword + ciphertable[j][number];
            }
        }



System.out.println(codedword);



        return "answer";
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



        //licznik liter
        int lettercounter=0;

        //licznik wierszy
        int rows=0;

        //wspolrzedne dla kazdej litery
        int[][] position = new int[zaszyfrowane.length()][2];


        System.out.println(klucz[3]);


        while(lettercounter<zaszyfrowane.length())
        {

            for(int i=0;i<key.length();++i)
            {

                for(int u=0;u<key.length();++u)
                {

                    if(i==klucz[u])
                    {

                        for(int j=0;j<u+1;++j)
                        {

                            if(lettercounter>=zaszyfrowane.length())
                                break;



                            if(lettercounter<zaszyfrowane.length())
                            {

                                position[lettercounter][0]=rows;
                                position[lettercounter][1]=j;
                                System.out.println("Rows: "+rows+" Columns: "+j+" Letter:"+lettercounter);
                                ++lettercounter;
                            }
                        }//
                        ++rows;
                    }
                }//drugi for
            }//pierwszy for
        }//konie while



        System.out.println(lettercounter);
        System.out.println(zaszyfrowane.charAt(44));


        char[][] ciphertable = new char[rows][key.length()];

        for(int i = 0; i<rows;i++)
        {
            for(int j=0;j<key.length();++j)
                ciphertable[i][j]=' ';
        }


        for(int i=0;i<lettercounter;++i)
        {

            if(!(zaszyfrowane.charAt(i)==' '))
                ciphertable[position[i][0]][position[i][1]]='*';
        }



        System.out.println(ciphertable[4]);



        int number=0;
        int actualIndex=0;
        String codedword="";

        for(int i=0;i<key.length(); ++i) {

            for(int k=0;k<key.length();++k){
                if(klucz[k]==i)
                    number=k;
            }

            for (int j = 0; j < rows; ++j) {
                if(ciphertable[j][number]=='*')
                {
                    ciphertable[j][number]=zaszyfrowane.charAt(actualIndex);

                    actualIndex++;

                }
                   // codedword = codedword + ciphertable[j][number];
            }
        }


        System.out.println(ciphertable[4]);


        String answer="";

        for(int i=0;i<rows;++i)
        {
            for(int j=0;j<key.length();++j)
                if(ciphertable[i][j]!=' ')
                answer=answer+ciphertable[i][j];
        }

        System.out.println(answer);




        return "ANSWER";
    }





}
