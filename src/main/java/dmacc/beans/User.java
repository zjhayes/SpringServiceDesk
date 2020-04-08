package dmacc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "users")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	private String email;
	private String displayName;
	private String password;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = { CascadeType.MERGE, CascadeType.REMOVE })
	private List<Request> requests = new ArrayList<Request>();
	
	public User()
	{
		super();
	}
	
	public User(String email, String displayName, String password)
	{
		super();
		this.email = email;
		this.displayName = displayName;
		this.password = password;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public List<Request> getRequests()
	{
		return requests;
	}

	public void setRequests(List<Request> requests)
	{
		this.requests = requests;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "User [email=" + email + ", displayName=" + displayName + ", password=" + password + "]";
	}
}
