package ProjectExample;

public class ChangeString {

	public static void main(String[] args) {
		String change = "��������������ư��� ���ִ�";
		char[] a = change.toCharArray();
		int saCount = 0;
		int gwaCount = 0;
		int applecount = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == '��') {
				saCount++;
				for (int j = 0; j < a.length; j++) {
					if (a[j] == '��') {
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
		System.out.println("����� ���� Ƚ���� " + applecount + "�Դϴ�.");
	}
}
