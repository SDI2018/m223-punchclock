package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.CategoryService;
import ch.zli.m223.punchclock.service.EntryService;
import ch.zli.m223.punchclock.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {

    private EntryService entryService;
    private CategoryService categoryService;
    private UserService userService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    /**
     * Gibt eine Liste aller Entry Datensätze zurück
     * @return List<Entry>
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }

    @GetMapping("/byproject/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getEntriesByProjectId(@PathVariable("id") Long id){
        return entryService.getEntriesByProjectId(id);
    }

    /**
     * Erzeugt einen neuen Entry Datensatz
     * @param entry
     * @param principal
     * @return Entry
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry, Principal principal) {
        return entryService.createEntry(entry, principal);
    }

    /**
     * Löscht einen bestehenden Entry Datensatz anhand der ID
     * @param id
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEntry(@PathVariable("id") Long id){ entryService.deleteEntry(id);}

    /**
     * Aktualisiert einen bestehenden Entry Datensatz
     * @param entry
     * @param principal
     * @return Entry
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Entry updateEntry(@Valid @RequestBody Entry entry, Principal principal){ return entryService.updateEntry(entry, principal);}

}
