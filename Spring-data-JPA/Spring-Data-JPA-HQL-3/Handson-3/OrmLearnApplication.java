private static AttemptService attemptService;
private static void testGetAttempt() {
    Attempt attempt =
            attemptService.getAttempt(1,1);
    System.out.println("User : "
            + attempt.getUser().getName());
    System.out.println("Date : "
            + attempt.getAttemptDate());
    for(AttemptQuestion aq :
            attempt.getAttemptQuestionList()) {
        System.out.println(
                aq.getQuestion().getText());
        for(AttemptOption ao :
                aq.getAttemptOptionList()) {
            System.out.println(
                    ao.getOption().getText()
                    + " "
                    + ao.getOption().getScore()
                    + " "
                    + ao.isSelected());
        }
        System.out.println();
    }
}