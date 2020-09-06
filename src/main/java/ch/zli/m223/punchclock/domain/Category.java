package ch.zli.m223.punchclock.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	 @OneToMany(mappedBy="category")
	 private List<Entry> entry = new ArrayList<Entry>();

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

	 public List<Entry> getEntry() {
	 	return entry;
	 }

	 public void setEntry(List<Entry> entry) {
	 	this.entry = entry;
	 }
	
	

}
