@Repository
public interface AttemptRepository extends JpaRepository<Attempt,Integer> {
    @Query("select distinct a from Attempt a "
         + "join fetch a.user u "
         + "join fetch a.attemptQuestionList aq "
         + "join fetch aq.question q "
         + "join fetch aq.attemptOptionList ao "
         + "join fetch ao.option o "
         + "where u.id=:userId and a.id=:attemptId")
    Attempt getAttempt(int userId,int attemptId);
}