package ch.zli.m223.punchclock.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Entry> entries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Entry> getEntry() {
        return entries;
    }

    public void setEntry(Set<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        String result = String.format("Category[id=%d,name='%s']%n", id, name);

        if (entries != null) {
            for (Entry entry : entries) {
                result += result =
                        String.format("Entry[id=%d,checkIn='%i',checkOut='%o']%n",
                                entry.getId(), entry.getCheckIn(), entry.getCheckOut());
            }
        }
        return result;
    }
}
