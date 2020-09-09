package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import ch.zli.m223.punchclock.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class EntryService {
    private EntryRepository entryRepository;
    private ApplicationUserRepository userRepository;

    public EntryService(EntryRepository entryRepository, ApplicationUserRepository userRepository) {
        this.entryRepository = entryRepository;
        this.userRepository = userRepository;
    }

    public Entry createEntry(Entry entry, Principal principal) {
        entry.setApplicationUser(userRepository.findByUsername(principal.getName()));
        return entryRepository.saveAndFlush(entry);
    }

    public void deleteEntry(Long id){entryRepository.deleteById(id);}

    public Entry updateEntry(Entry entry,Principal principal){
        if (entryRepository.findById(entry.getId())!=null){
            entry.setApplicationUser(userRepository.findByUsername(principal.getName()));
            return entryRepository.save(entry);
        }
        return null;
    }

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }
}
