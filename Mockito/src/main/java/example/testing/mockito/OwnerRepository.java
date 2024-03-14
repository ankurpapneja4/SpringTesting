package example.testing.mockito;

public interface OwnerRepository {

    public Owner save(Owner owner);

    public void deleteOwner(Integer ownerId);
}
