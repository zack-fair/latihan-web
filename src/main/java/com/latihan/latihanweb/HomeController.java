package com.latihan.latihanweb;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latihan.domain.Barang;

@Controller
public class HomeController {
	
	public HomeController(){
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Barang> ListBarang = new ArrayList<Barang>();
		
		ListBarang.add(new Barang("101","Komputer keren",1));
		ListBarang.add(new Barang("102","Komputer canggih",1));
		return "barang";
	}

}
