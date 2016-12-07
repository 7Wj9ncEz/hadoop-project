import java.io.File;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Collection;
import java.util.ArrayList;

public class FriendCounter {

    public static void main(String[] args) {

	//Mapeia o primeiro nome como uma chave para uma coleção de nomes dos amigos
	Map<String,Collection<String>> friends = new HashMap<String,Collection<String>>();

        try {
	    //Especifica o arquivo a ser processado
	    Scanner input = new Scanner("in.txt");

	    File file = new File(input.nextLine());
	    input = new Scanner(file);

	    //Enquanto houver conteúdo nas linhas do arquivo
	    while (input.hasNextLine()) {

		//Lê a linha como um todo e separa as string por uma vírgula e coloca-as em um array de Strings
		String line = input.nextLine();
		String pessoas[] = line.split(", ");

		for(int i=0; i< pessoas.length; i++){
			//Para cada pessoa com o índice par, ou seja, que é o primeiro na ordem Amigo1, Amigo2
			//Coloca o Amigo1 como chave e adiciona o Amigo2 na coleção de strings
			//Dessa forma todos os amigos do Amigo1 estarão contidos na coleção de strings e 
			//pode ser acessado pelo nome do Amigo1
			if(i%2 == 0){
				Collection<String> values = friends.get(pessoas[i]);
				if (values==null) {
				    values = new ArrayList<String>();
				    friends.put(pessoas[i], values);
				}
				values.add(pessoas[i+1]);
			}
		}
	    }

            //Para todas as chaves existentes no Map
            //Imprime o nome da pessoa, o nome dos amigos desta pessoas e quantos amigos ela possui
	    for(String name : friends.keySet()) {
		Collection<String> value = friends.get(name);
		System.out.println(name +" " + value + " " + value.size());
	    }
		
	    //Fecha o arquivo
            input.close();

        } catch (Exception e) {
	    //Captura execções e imprime seu log
            e.printStackTrace();
        }
    }
}
