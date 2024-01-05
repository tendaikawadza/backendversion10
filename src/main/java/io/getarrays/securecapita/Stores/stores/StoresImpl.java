package io.getarrays.securecapita.Stores.stores;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoresImpl implements StoresService {
    private final StoresRepository<Stores> StoresRepository;

    //delete requests

    @Override
    public boolean deleteStores(Long id) {
        return StoresRepository.delete(id);
    }

    @Override
    public Stores createStores(Stores Stores) {
        return StoresRepository.create(Stores);
    }

    @Override
    public List<Stores> getAllStores() {
        return StoresRepository.list();
    }

    @Override
    public Stores getStoresById(Long id) {
        return (Stores) StoresRepository.get(id);
    }






}
