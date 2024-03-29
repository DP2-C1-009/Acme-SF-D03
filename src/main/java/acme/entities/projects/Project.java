
package acme.entities.projects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.roles.Manager;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project extends AbstractEntity {

	// Serialisation identifier ---------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -----------------------------------------------------------------------------------------

	@Pattern(regexp = "^[A-Z]{3}-[0-9]{4}$", message = "{validation.ProjectCode.reference}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	@NotBlank
	@Length(max = 75)
	private String				title;

	@NotBlank
	@Length(max = 100)
	private String				pAbstract;

	private boolean				fatalErrors;

	@Min(value = 0)
	private int					cost;

	@URL
	private String				optionalLink;

	private boolean				draftMode;

	// Derived attributes -----------------------------------------------------

	//	@Transient
	//	public boolean isAvailable() {
	//		boolean result;
	//
	//		result = !this.draftMode && !this.hasFatalErrors;
	//
	//		return result;
	//	}

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Manager				manager;
}
