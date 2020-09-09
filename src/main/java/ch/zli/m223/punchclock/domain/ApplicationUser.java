package ch.zli.m223.punchclock.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;

    @OneToMany(mappedBy="applicationUser")
	private Set<Entry> entries;
    
    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public Set<Entry> getEntry() {
	 	return entries;
	 }

	 public void setEntry(Set<Entry> entry) {
	 	this.entries = entry;
	 }
    @Override
    public String toString() {
        String result = String.format("Category[id=%d,username='%s']%n",
                id,
                username);

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