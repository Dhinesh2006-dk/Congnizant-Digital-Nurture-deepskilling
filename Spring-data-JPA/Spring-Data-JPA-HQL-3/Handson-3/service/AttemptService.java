@Service
public class AttemptService {
    @Autowired
    private AttemptRepository attemptRepository;
    @Transactional
    public Attempt getAttempt(int userId,int attemptId){
        return attemptRepository.getAttempt(userId,attemptId);
    }
}