
package acme.entities.progressLogs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import acme.client.data.AbstractEntity;
import acme.entities.contract.Contract;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProgressLog extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^PG-[A-Z]{1,2}-[0-9]{4}$", message = "{validation.ProgressLogRecord}")
	protected String			recordId;

	@Positive
	@NotNull
	protected Integer			completeness;

	@NotBlank
	@Length(max = 100)
	private String				comment;

	@Temporal(TemporalType.TIMESTAMP)
	@PastOrPresent
	@NotNull
	protected Date				registrationMoment;

	@NotBlank
	@Length(max = 75)
	protected String			responsiblePerson;

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Contract			contract;

}
