package example.testing.mockito;

public class OwnerService {


    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner saveOwner( Owner owner){

        // Delegate to OwnerRepository
        return ownerRepository.save( owner );
    }

    public void deleteOwner( Integer ownerId ){

        if( ownerId == null ) throw new IllegalArgumentException(" ownerId cannot be null ");

        // Delegate to OwnerRepository
        ownerRepository.deleteOwner( ownerId );
    }
}
