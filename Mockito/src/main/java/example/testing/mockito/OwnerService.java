package example.testing.mockito;

public class OwnerService {


    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public void deleteOwner( Integer ownerId ){

        if( ownerId == null ) throw new IllegalArgumentException(" ownerId cannot be null ");

        // Delegate to OwnerRepository
        ownerRepository.deleteOwner( ownerId );
    }
}
