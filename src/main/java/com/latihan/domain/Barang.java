package com.latihan.domain;

public class Barang {
	
	private String kode;
	
	private String nama;
	
	private Integer qty;
	
	public Barang() {}		

	public Barang(String kode, String nama, Integer qty) {
		this.kode = kode;
		this.nama = nama;
		this.qty = qty;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	public void kurang(Integer qty) {		
		this.qty -= qty;
		if (this.qty < 0) {
			throw new IllegalStateException(String.format("Jumlah barang %s mencapai negatif.", nama));
		}
	}

}
