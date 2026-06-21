public class UserService {
    private UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));
    }
}