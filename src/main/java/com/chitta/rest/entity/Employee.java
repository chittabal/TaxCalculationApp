package com.chitta.rest.entity;

import java.util.List;

import com.chitta.rest.exception.IValidPhoneNumbers;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "emp_details")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "EMPLOYEE_ID", length = 20, unique = true, nullable = false)
	@Pattern(regexp = "^E[a-zA-Z0-9]{3}$", message = "employeeId must be 4 characters long and start with 'E'")
	private String employeeId;
	
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "EMAIL", length = 50, nullable = false)
	@NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
	private String email;
	
	@ElementCollection
	@CollectionTable(name = "employee_phone_numbers", joinColumns = @JoinColumn(name = "employee_id"))
	@Column(name = "PHONE_NUMBERS")
	@IValidPhoneNumbers
	private List<String> phoneNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "DOJ", length = 50, nullable = false)
	private String doj;
	
	@Column(name = "SALARY", length = 50, nullable = false)
	private Double salary;

}
