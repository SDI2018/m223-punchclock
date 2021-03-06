package ch.zli.m223.punchclock.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.*;

@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy="applicationUser")
  	private Set<Entry> entries;

//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "applicationUser_roles", joinColumns = @JoinColumn(name = "applicationUser_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles;

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

    public Set<Entry> getEntries() {
	 	return entries;
	 }

    public void setEntries(Set<Entry> entries) {
	 	this.entries = entries;
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