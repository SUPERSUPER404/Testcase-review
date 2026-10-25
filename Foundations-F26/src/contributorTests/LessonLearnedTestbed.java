package contributorTests;

import entityClasses.LessonLearned;

public class LessonLearnedTestbed {

	static int passed = 0, failed = 0;

	// runs one case: a lesson is valid when validate() returns ""
	static void check(int num, boolean expectValid, String error) {
		boolean actualValid = error.isEmpty();
		boolean ok = (actualValid == expectValid);
		System.out.println("Test " + num + ": " + (ok ? "PASS" : "FAIL")
				+ (error.isEmpty() ? "" : "  (" + error + ")"));
		if (ok) passed++; else failed++;
	}

	public static void main(String[] args) {

		// Test 1 (positive): a good lesson should be accepted
		LessonLearned good = new LessonLearned(1, "Save Early", "Commit often.", "Sean", "git");
		check(1, true, good.validate());

		// Test 2 (negative): an empty title should be rejected
		LessonLearned bad = new LessonLearned(2, "", "Commit often.", "Sean", "git");
		check(2, false, bad.validate());

		System.out.println(passed + " passed, " + failed + " failed");
	}
}
