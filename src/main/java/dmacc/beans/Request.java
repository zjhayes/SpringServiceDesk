package dmacc.beans;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "requests")
public class Request
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String subject;
	private String description;
	private String requestType;
	@CreationTimestamp
	private LocalDate createdDate;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private User customer;
	
	public Request()
	{
		super();
		setMockUser();
	}
	
	public Request(String subject, String description, String requestType)
	{
		super();
		setMockUser();
		this.subject = subject;
		this.description = description;
		this.requestType = requestType;
	}
	
	public Request(String subject, String description, String requestType, User customer)
	{
		super();
		setMockUser();
		this.subject = subject;
		this.description = description;
		this.requestType = requestType;
		this.customer = customer;
	}
	
	public Request(String subject, String description, String requestType, LocalDate createdDate)
	{
		super();
		setMockUser();
		this.subject = subject;
		this.description = description;
		this.requestType = requestType;
		this.createdDate = createdDate;
	}
	
	public Request(String subject, String description, String requestType, LocalDate createdDate, User customer)
	{
		super();
		setMockUser();
		this.subject = subject;
		this.description = description;
		this.requestType = requestType;
		this.createdDate = createdDate;
		this.customer = customer;
	}
	
	public void setMockUser()
	{
		//this.customer = new User("sjohn@example.com", "John Smith", "kjagds");
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getRequestType()
	{
		return requestType;
	}

	public void setRequestType(String requestType)
	{
		this.requestType = requestType;
	}

	public LocalDate getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate)
	{
		this.createdDate = createdDate;
	}

	public User getCustomer()
	{
		return customer;
	}

	public void setCustomer(User customer)
	{
		this.customer = customer;
	}

	@Override
	public String toString()
	{
		return "Request [id=" + id + ", subject=" + subject + ", description=" + description + ", requestType="
				+ requestType + ", createdDate=" + createdDate + ", customer=" + customer + "]";
	}
}
