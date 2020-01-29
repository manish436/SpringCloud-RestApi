package com.hcl.learn.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.hcl.learn.domain.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue retriveSomeBean() {
		List<SomeBean> someBeanList = Arrays.asList(new SomeBean("Value1", "Value2", "value3", "value4", "value5"));

		MappingJacksonValue mapping = this.customFiltering(someBeanList);

		return mapping;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue retriveSomeBeanList() {

		List<SomeBean> someBeanList = Arrays.asList(new SomeBean("Value1", "Value2", "value3", "value4", "value5"),
				new SomeBean("Value1", "Value2", "value3", "value4", "value5"));

		MappingJacksonValue mapping = this.customFiltering(someBeanList);

		return mapping;
	}

	private MappingJacksonValue customFiltering(List<SomeBean> someBeanList) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field5", "field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = null;

		if (someBeanList.size() == 1) {
			mapping = new MappingJacksonValue(someBeanList.get(0));
		} else {
			mapping = new MappingJacksonValue(someBeanList);
		}

		mapping.setFilters(filters);
		return mapping;
	}

}
