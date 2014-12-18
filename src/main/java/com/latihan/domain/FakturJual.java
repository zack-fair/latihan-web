package com.latihan.domain;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class FakturJual {

	private String nomor;
	
	private LocalDate tanggal;
	
	private String namaKonsumen;
	
	private LocalDate tanggalJatuhTempo;
	
	private List<ItemFaktur> items = new ArrayList<>();	
		
	public FakturJual() {}
	
	public FakturJual(String nomor, LocalDate tanggal, String namaKonsumen, LocalDate tanggalJatuhTempo) {		
		this.nomor = nomor;
		this.tanggal = tanggal;
		this.namaKonsumen = namaKonsumen;
		this.tanggalJatuhTempo = tanggalJatuhTempo;		
	}

	public String getNomor() {
		return nomor;
	}

	public void setNomor(String nomor) {
		this.nomor = nomor;
	}

	public LocalDate getTanggal() {
		return tanggal;
	}

	public void setTanggal(LocalDate tanggal) {
		this.tanggal = tanggal;
	}

	public String getNamaKonsumen() {
		return namaKonsumen;
	}

	public void setNamaKonsumen(String namaKonsumen) {
		this.namaKonsumen = namaKonsumen;
	}

	public LocalDate getTanggalJatuhTempo() {
		return tanggalJatuhTempo;
	}

	public void setTanggalJatuhTempo(LocalDate tanggalJatuhTempo) {
		this.tanggalJatuhTempo = tanggalJatuhTempo;
	}
			
	public List<ItemFaktur> getItems() {
		return items;
	}
		
	public void tambah(Barang barang, Integer qty, Double harga, Double diskonPersen) {		
		tambah(new ItemFaktur(barang, qty, harga, diskonPersen));
	}
	
	public void tambah(ItemFaktur itemFaktur) {
		if (itemFaktur.getBarang().getQty() < itemFaktur.getQty()) {
			throw new IllegalArgumentException(String.format("Jumlah barang %s sebesar %d tidak mencukupi untuk %d.", 
				itemFaktur.getBarang().getNama(), itemFaktur.getBarang().getQty(), itemFaktur.getQty()));
		}
		items.add(itemFaktur);		
	}

	public Double total() {
		return items.stream().mapToDouble(i -> i.total()).sum();
	}
	
}