package ProjectExample;

public class ChangeString {

	public static void main(String[] args) {
		String change = "사과사과사과사과사아과는 맛있다";
		char[] a = change.toCharArray();
		int saCount = 0;
		int gwaCount = 0;
		int applecount = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == '사') {
				saCount++;
				for (int j = 0; j < a.length; j++) {
					if (a[j] == '과') {
						gwaCount++;
					}
				}
				if (saCount >= 1 && gwaCount >= 1) {
					applecount++;
				}
				saCount = 0;
				gwaCount = 0;
			}

		}
		System.out.println("사과가 나온 횟수는 " + applecount + "입니다.");
	}
}
