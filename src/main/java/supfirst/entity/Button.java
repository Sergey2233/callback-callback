package supfirst.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Serhii
 *
 */
@Entity
@Table(name = "BUTTON")
public class Button implements Serializable {

	private static final long serialVersionUID = -2858739935182280031L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	@NotNull
	@Column(name = "color")
	private String color;
	@NotNull
	@Column(name = "code")
	private String code;
	@NotNull
	@Column(name = "domen")
	private String domen;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private User user;

	public Button() {
		super();

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDomen() {
		return domen;
	}

	public void setDomen(String domen) {
		this.domen = domen;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((date == null) ? 0 : (date.clone()).hashCode());
		result = prime * result + ((domen == null) ? 0 : domen.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((user == null) ? 0 : (user.clone()).hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Button other = (Button) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (domen == null) {
			if (other.domen != null)
				return false;
		} else if (!domen.equals(other.domen))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
