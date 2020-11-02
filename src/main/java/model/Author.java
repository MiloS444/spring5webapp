package model;

import java.util.Set;
import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class Author
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	@ManyToMany(mappedBy = "authors")
	private Set<Book> bookSet;

	@Override
	public String toString() {
		return "Author{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", bookSet=" + bookSet +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Author author = (Author) o;

		return getId() != null ? getId().equals(author.getId()) : author.getId() == null;
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}
}
