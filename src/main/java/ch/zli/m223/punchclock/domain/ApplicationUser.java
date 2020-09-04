package ch.zli.m223.punchclock.domain;

import java.util.ArrayList;
import java.util.List;

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

    // @OneToMany(mappedBy="applicationUser")
	// private List<Entry> entry = new ArrayList<Entry>();
    
    
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
    
    // public List<Entry> getEntry() {
	// 	return entry;
	// }

	// public void setEntry(List<Entry> entry) {
	// 	this.entry = entry;
	// }
    
}