package com.latihan.latihanweb.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.latihan.domain.Barang;

@Controller
@RequestMapping("/barang")
public class BarangController {

	//
	// TODO:  Ini adalah dummy yang perlu diganti dengan persistence ke database nantinya!
	//
	public static List<Barang> daftarBarang = new ArrayList<>();
	
	static {
		daftarBarang.add(new Barang("KODE-1", "NAMA-1", 10));
		daftarBarang.add(new Barang("KODE-2", "NAMA-2", 20));
		daftarBarang.add(new Barang("KODE-3", "NAMA-3", 30));
		daftarBarang.add(new Barang("KODE-4", "NAMA-4", 40));
	}
		
	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "barang";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Barang> listBarang() {
		return daftarBarang;
	}
	
	@RequestMapping(value="/tambah", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseBody
	public String tambah(@RequestBody Barang barang) {
		daftarBarang.add(barang);
		return "{\"hasil\": true}";
	}
	
	@RequestMapping(value="/hapus", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseBody
	public String hapus(@RequestBody List<Barang> daftarBarangDihapus) {		
		daftarBarang.removeAll(daftarBarangDihapus);			
		return "{\"hasil\": true}";
	}
	
}