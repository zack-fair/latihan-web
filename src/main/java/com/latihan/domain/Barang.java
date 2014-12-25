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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kode == null) ? 0 : kode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Barang other = (Barang) obj;
		if (kode == null) {
			if (other.kode != null)
				return false;
		} else if (!kode.equals(other.kode))
			return false;
		return true;
	}			

}
