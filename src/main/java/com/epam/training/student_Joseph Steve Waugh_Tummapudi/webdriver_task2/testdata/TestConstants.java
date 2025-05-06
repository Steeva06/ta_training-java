package com.epam.webdriver_task2.testdata;

public interface TestConstants {
    String CODE_SNIPPET = "            git config --global user.name  \"New Sheriff in Town\"\n" +
            "            git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "            git push origin master --force";
    String TITLE = "how to gain dominance among developers";
    String HIGHLIGHTING_OPTION = "Bash";
}
