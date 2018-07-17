import java.io.*;
import java.util.*;

public class TwoStrings {
	private static String twoStrings(String s1, String s2) {
		boolean[] a1 = new boolean[26];
		boolean[] a2 = new boolean[26];

		for (char c : s1.toCharArray())
			a1[c - 97] = true;

		for (char c : s2.toCharArray())
			a2[c - 97] = true;

		for (int i = 0; i < 26; i++)
			if (a1[i] && a2[i])
				return "YES";
		
		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}