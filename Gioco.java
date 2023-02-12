import java.util.Scanner;
import java.util.Random;
public class Gioco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);//serve per fare l'input dei numeri
		int[] numerigiocati = new int[5];//array dei numeri giocati dall'utente
		int[] numusciti = new int[5];//array dei numeri che sono usciti 
		int n;
		System.out.println("Inserisci 5 numeri");
		for(int i = 0; i < 5; i++) {//scorro array per giocare i numeri nel mentre controlla i numeri inseriti
			do {
		    n = input.nextInt();//serve per fare l'input dei numeri
			}
			while(check(n, numerigiocati));
			numerigiocati[i] = n;//aggiungo all'array il numero giocato
		}
		System.out.println("Ecco i numeri usciti");
		estrazione(numusciti);//richiamo al metodo estrazione

			if(ver(numusciti, numerigiocati) == 0) //controlli se i numeri giocati e inseriti sono uguali o diversi
				System.out.println("HAI PERSO!!");
			if(ver(numusciti, numerigiocati) == 1)
				System.out.println("HAI TROVATO UN NUMERO UGUALE!");
			if(ver(numusciti, numerigiocati) == 2)
				System.out.println("AMBO");
			if(ver(numusciti, numerigiocati) == 3)
				System.out.println("TERNO");
			if(ver(numusciti, numerigiocati) == 4)
				System.out.println("QUATERNA");
			if(ver(numusciti, numerigiocati) == 5)
				System.out.println("CINQUINA");
		}
			
	public static Boolean check(int n,int[] ng){ //controllo dei numeri giocati dall'utente
		 Boolean trovato = false;
			for(int i = 0; i < 5; i++) {
				if((n == ng[i]) || (n > 90) || (n <= 0)) {
					System.out.println("Numero non valido, reinserirlo: ");
					trovato = true;
				}
			}
			return trovato;
		}
	public static void estrazione(int[] nest) { //estrazione numeri casuali da 1 a 90
		int numero = 0;
	    Random r = new Random();
		for(int i = 0; i < 5; i++){
		numero = r.nextInt(90)+1;
		nest[i] = numero;
		System.out.println(nest[i]);
		for(int j = 0; j < i; j++) {
			if(nest[i] == nest[j]) { //controllo se l'elemento estratto adesso sia uguale a quello estratto in precedenza
				System.out.println("E' stato estratto un numero uguale al precedente, quindi ne estraggo un altro");
				i--;}
			}
		}
	}
	public static int ver(int[] nest, int[] ngioc) { //verifica se i numeri giocati dall'utente sono uguali a quelli estratti
		int count = 0;
	for(int i = 0; i < 5; i++) {
		for(int j = 0; j < 5; j++) {
		if(nest[i] == ngioc[j]) {
			count++; //incrementa il contatore che serve per dare il risultato del gioco
			}
		}
	}
	return count;
	}
}

