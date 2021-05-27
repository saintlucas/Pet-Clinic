package pl.sdacademy.petclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.petclinic.model.Owner;
import pl.sdacademy.petclinic.model.repository.OwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public void save(Owner owner){
        ownerRepository.save(owner);
    }

    public void save(Owner updatedOwner, Long ownerId){
        Owner ownerToUpdate = ownerRepository.findById(ownerId)
                .orElseThrow(()->new IllegalArgumentException("Owner with such id doesn't exist"));
        ownerToUpdate.setName(updatedOwner.getName());
        ownerToUpdate.setAddress(updatedOwner.getAddress());
        ownerToUpdate.setCity(updatedOwner.getCity());
        ownerToUpdate.setPets(updatedOwner.getPets());
        ownerRepository.save(ownerToUpdate);
    }

    public List<Owner> findAll(){
        return ownerRepository.findAll();
    }

    public Optional<Owner> findById(Long id){return ownerRepository.findById(id);}


}
