import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class main {

	static String location =""; 
	static int point; 
	static ArrayList<Node> listOfPoint = new  ArrayList<>(); 

	public static String mainx,mainy; 

	public static void main(String[] args) throws IOException {

		//		location = args[0]; 
		//		point  = Integer.parseInt(args[1]);

		location = "/Users/mohammedchowdhury/Desktop/locations.txt"; //linking the file //change to your link 
		point = 5; 

		if(point<0 || point>5000) {
			System.out.println("Not a Valid Point");
			return; 
		}


		readData();

		Collections.sort(listOfPoint,new Comparator<Node>() {
			public int compare(Node n1,Node n2) {
				double  d =  n1.getdistance() - n2.getdistance();
				if(d == 0) {
					return 0;
				}
				return d>0? 1: -1;
			}
		});

		WriteToFile();
	}




	public static void WriteToFile()throws IOException {
		String outputFile = location.replace("locations.txt", "OutPutLocations.txt"); 
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		String str =""; 
		for(int a=0 ;a<point;a++) {
			Node temp = listOfPoint.get(a); 
			str = str + temp.getData()+"\n";  
		}
		writer.write(str);
		writer.close();
	}

	public static void readData() throws IOException {
		File file = new File(location); 
		String[] arrOfStr = new String[2]; 
		int counter = 0; 
		String st; 

		try {
			BufferedReader br = new BufferedReader(new FileReader(file)); 

			while ((st = br.readLine()) != null) {

				arrOfStr = st.split(" ");
				arrOfStr[0].replaceAll(" ",""); 
				arrOfStr[1].replaceAll(" ",""); 

				String x = arrOfStr[0]; 
				String y = arrOfStr[1]; 

				if(counter==0) {
					mainx = x; 
					mainy = y; 
					counter++; 
				}
				else {	
					Node newNode = new Node(x, y,mainx,mainy); 
					listOfPoint.add(newNode); 
				}
			}

		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}

	}


}

