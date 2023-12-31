package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "Sample")

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)

@FilterDef(name = SampleEntity.FILTER_NAME, parameters = @ParamDef(name = SampleEntity.PARAM_NAME, type = "java.lang.String"))
public class SampleEntity {

	public static final String FILTER_NAME = "localeFilter";
	public static final String PARAM_NAME = "currentLocaleISOCode";

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	@ToString.Include
	private Long id;

	private String name;

	@Filter(name = SampleEntity.FILTER_NAME, condition = "localeISOCode=:" + SampleEntity.PARAM_NAME)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Translation> field1TranslationList = new ArrayList<>();
	
	@Filter(name = SampleEntity.FILTER_NAME, condition = "localeISOCode=:" + SampleEntity.PARAM_NAME)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Translation> field2TranslationList = new ArrayList<>();
}