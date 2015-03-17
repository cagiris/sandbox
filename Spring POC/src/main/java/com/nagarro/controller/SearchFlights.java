package com.nagarro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.bean.SearchParametersBean;
import com.nagarro.entity.flight.FlightDetails;
import com.nagarro.service.flight.FlightsSearchService;

/**
 * Controller to handle direction of views for search flight operations.
 * @author ashish2069
 *
 */
@Controller
public class SearchFlights {

	/**
	 * Service to handle the flight search operation.
	 */
	@Autowired
	private FlightsSearchService flightSearchService;

	@RequestMapping(value = "/search-flights", method = RequestMethod.GET)
	public String showSearchPage(Model model) {
		model.addAttribute("searchParameters", new SearchParametersBean());
		return "flights/search-flights";
	}
	
	@RequestMapping(value = "/search-flights", method = RequestMethod.POST)
	public String performSearch(@Valid @ModelAttribute("searchParameters") SearchParametersBean searchParameters,
								BindingResult result,
								Model model) {
		if (!result.hasErrors() && (model != null)) {
			List<FlightDetails> searchedFlights = flightSearchService.findFlights(searchParameters);
			model.addAttribute("searchResults", searchedFlights);
		}
		
		return "flights/search-flights";
	}
	
	/*@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
	  DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
	  CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
	  binder.registerCustomEditor(Date.class, orderDateEditor);
	}*/
}
