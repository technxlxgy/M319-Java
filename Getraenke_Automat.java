//funktioniert einwandfrei (Auswahl + Preisanzeige)

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Main {
    
    public static void main (String[] args) {
        int anzahlKaffee = 0;
        int anzahlCola = 0;
        int anzahlSchorle = 0;

        //Getränke erstellen
        produkt cola = new produkt((float)2.50, "Cola");
        produkt kaffee = new produkt((float)0.90, "Kaffee");
        produkt schorle = new produkt((float)3.20, "Schorle");
            
        Scanner Eingabe = new Scanner(System.in);
        
        //String myString;
        boolean antwortGültig = true;                            
        while (antwortGültig) {
            boolean getränkGültig = true;
            while(getränkGültig) {
                //erste Schleife
                try {
                    System.out.println("Wählen Sie ein Geränk aus. 1. Cola, 2. Kaffee, 3. Schorle");
                    int gewünschtesProdukt;
                    gewünschtesProdukt = Eingabe.nextInt(); 
                    //Auswahl Getränk
                    switch(gewünschtesProdukt) {
                        case 1:
                            boolean eingabeUngültig1 = true;
                            while(eingabeUngültig1) {
                                System.out.println("Anzahl Cola: ");
                                try {    
                                    int eingabe = Eingabe.nextInt();
                                    if(eingabe >= 1) {
                                    anzahlCola += eingabe;
                                    eingabeUngültig1 = false;
                  
                                } else { 
                                    System.out.println("Bitte eine Zahl - die grösser als Null ist - angeben.");
                                  }
                                }
                                catch(InputMismatchException myException) {
                                System.out.println("Ihre Eingabe ist ungültig.");
                                Eingabe.nextLine();
                                }
                            } 
                        break;
                        case 2:
                            boolean eingabeUngültig2 = true;
                            while(eingabeUngültig2) {
                                System.out.println("Anzahl Kaffee: ");  
                                try {    
                                    int eingabe = Eingabe.nextInt();
                                    if(eingabe >= 1) {
                                    anzahlKaffee += eingabe;
                                    eingabeUngültig2 = false;
                                } else { 
                                    System.out.println("Bitte eine Zahl - die grösser als Null ist - angeben.");
                                  }
                                }
                                catch(InputMismatchException myException) {
                                    System.out.println("Ihre Eingabe ist ungültig.");
                                    Eingabe.nextLine();
                                }
                            }
                        break;
                        case 3:
                            boolean eingabeUngültig3 = true;
                            while(eingabeUngültig3) {
                                System.out.println("Anzahl Schorle: ");  
                                try {    
                                    int eingabe = Eingabe.nextInt();
                                    if(eingabe >= 1) {
                                    anzahlSchorle += eingabe;
                                    eingabeUngültig3 = false;
                                } else { 
                                    System.out.println("Bitte eine Zahl - die grösser als Null ist - angeben.");
                                  }
                                }
                                catch(InputMismatchException myException) {
                                    System.out.println("Ihre Eingabe ist ungültig.");
                                    Eingabe.nextLine();
                                }
                            }
                        break;
                        default:
                            System.out.println("Dies ist kein vorhandenes Getränk.");
                        continue;
                    }
                }
                catch(InputMismatchException myException) {
                    System.out.println("Dies ist keine gültige Eingabe");
                    Eingabe.nextLine(); //Leer
                continue;
                }
                    break;
            }
            //zweite Schleife
            boolean antworten = true;
                while(antworten) {
                    System.out.println("Möchten Sie ein weiteres Getränk kaufen?");
                    String antwort = Eingabe.next();
                    
                    if(antwort.equals("Ja")) {
                            break;
                    }
                    else if (antwort.equals("Nein")) {      
                            antwortGültig = false;
                            break;   
                    }
                    else {
                            Eingabe.nextLine();
                            System.out.println("Bitte antworten Sie entweder mit Ja oder Nein.");
                    }
                }  
        }
        
        //Berechnung des Preises      
        float totalPreisCola = cola.preis * anzahlCola;
        float totalPreisKaffee = kaffee.preis * anzahlKaffee;
        float totalPreisSchorle = schorle.preis * anzahlSchorle;

        float totalPreis = totalPreisCola + totalPreisKaffee + totalPreisSchorle;
        System.out.printf("Total Preis: %.2f Fr.%n", totalPreis);
        
        //Geldeinwurf
        float eingeworfenesGeld = 0;
        float restBetrag = totalPreis;
        System.out.println("Bitte werfen Sie Geld ein. Wir nehmen nur Münzen!");
            
        while(restBetrag > 0) {
            
            
            try {
                float eingeworfenerBetrag = Eingabe.nextFloat();
                   if (eingeworfenerBetrag == 0.10f || eingeworfenerBetrag == 0.20f || eingeworfenerBetrag == 0.50 || eingeworfenerBetrag == 1.00 || eingeworfenerBetrag == 2.00 || eingeworfenerBetrag == 5.00) {
                        eingeworfenesGeld += eingeworfenerBetrag;
                        restBetrag -= eingeworfenerBetrag;
                                if (restBetrag > 0) {
                                System.out.printf("Noch zu zahlen: %.2f Fr.%n", restBetrag);
                                }
                                else if (restBetrag == 0) {
                                    System.out.println("Danke für Ihren Einkauf! Aufwiedersehen.");
                                }
                                else if (restBetrag < 0) {
                                    System.out.printf("Danke für Ihren Einkauf! Hier Ihr Restgeld: %.2f Fr.%n", restBetrag * -1);
                                }
                            continue;
                    }
                    else {
                        System.out.println("Ungültiger Betrag. Bitte geben Sie eine der folgenden Beträge ein:");
                        System.out.println("0.10, 0.20, 0.50, 1.00, 2.00, 5.00");
                        Eingabe.nextLine();
                    }
            }
            catch (InputMismatchException myException){
                System.out.println("Ungültige Eingabe. Bitte geben Sie einen gültigen Betrag ein.");
                Eingabe.nextLine(); //Leer                    
            }
        }
      Eingabe.close();
    }
}

class produkt {
    String name;
    float preis;

    public produkt(float p, String n){
        preis = p;
        name = n;
    }
}