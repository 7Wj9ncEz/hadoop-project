import java.io.File;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Collection;
import java.util.ArrayList;

public class FriendCounter {

    public static void main(String[] args) {

	Map<String,Collection<String>> friends = new HashMap<String,Collection<String>>();

        try {
	    Scanner input = new Scanner("in.txt");

	    File file = new File(input.nextLine());
	    input = new Scanner(file);

	    while (input.hasNextLine()) {
		String line = input.nextLine();
		String pessoas[] = line.split(", ");
		for(int i=0; i< pessoas.length; i++){
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

	    for(String name : friends.keySet()) {
		Collection<String> value = friends.get(name);
		System.out.println(name +" " + value + " " + value.size());
	    }

            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
