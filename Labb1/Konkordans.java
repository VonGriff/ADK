import java.util.LinkedList;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Konkordans {

    private static RandomAccessFile file;
    private static Path 
    
    public Konkordans() {
	int i;
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
	file = new RandomAccessFile("korpus","r");
	// word.getBytes("ISO-8859-1")
	file.seek(50);
	byte[] b = new byte[10];
	String s;
	for (long i = 0; i < 10; i++) {
	    b[i] = file.readByte();
	}
	s = new String(b, "ISO-8859-1");
	System.out.println(s);
    }

    // Fetc the index of where the word with starting chars "xxx" exist
    private static int getWordIndex(String s) {
	char[] c = s.toCharArray();
	int size = c.length;
	int index = 0; // Will never exist anything on index 0
	if (size < 3) {
	    int multiplier = 900;
	    for (int i = 0; i < size; i++) {
		index += c[i]*multiplier;
		multiplier = multiplier/30;
	    }
	}
	else {
	    index = c[0]*900 + c[1]*30 + c[2];
	}
	return index;
    }

    // Fetch all indeces of where in the text word X exist
    private static LinkedList<Long> getWordLocation(int index, String word) {
	return null;
    }

    // Will print all words on every position where occurring along with
    // 30 chars before and after
    // Paramaters pos are the positions of every word, len is the length of the word
    private static void printWord(LinkedList<Long> pos,int len) throws IOException {
	// new String(b, "ISO-8859-1")
	int i;
	byte[] sentence = new byte[60+len];
	for (long l: pos) {
	    if (l < 30) {
		file.seek(0);
		//file.read(
	    }
	}
    }
}
