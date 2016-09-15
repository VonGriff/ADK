// [A-Z] = 0x41-0x5A [a-z] = 0x61-0x7A
// [ÄÅÖ] = 0xC4,0xC5,0xD6 [äåö] = 0xE4,0xE5,0xF6
// \n = 0x0A

import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.FileNotFoundException;

// TODO: the sorted list, 

public class Builder {

    private static RandomAccessFile korpus;
    private static RandomAccessFile sorteradLista;
    private static RandomAccessFile hashLista;
    private static int[] lazyHash = new int[28000];
    
    public Builder() throws IOException, FileNotFoundException {

	int i;
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
	long i = 2;
	Builder b = new Builder();
	korpus = new RandomAccessFile("korpus", "rw");
	sorteradLista = new RandomAccessFile();
    }

    // Ska ta ett ord och index för var det börjar och hasha
    // de tre första bokstäverna
    private static void hash(String s, int index) {
	char[] c = s.toCharArray();
	int size = c.length;
	int hash = 0;
	if (size < 3) {
	    int multiplier = 900;
	    for (int i = 0; i < size; i++) {
		hash += c[i]*multiplier;
		multiplier = multiplier/30;
	    }
	}
	else {
	    hash = c[0]*900 + c[1]*30 + c[2];
	}
	lazyHash[hash] = index;
    }
    private static String[][] sort(String[] s) {
	String[][] delad;
	for(int i = 0; i < s.length; i++){
	    delad[i] = s[i].split("\\s");
	}
	
    }
}
